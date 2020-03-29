package com.okid0kii.mmcherrytree.world;

import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;
import com.okid0kii.mmcherrytree.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.state.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraftforge.common.IPlantable;

public class CherryTreeFeature extends AbstractTreeFeature<TreeFeatureConfig>
{
	private static final BlockState TRUNK = BlockInit.CHERRY_LOG.get().getDefaultState();
	private static final BlockState LEAF = BlockInit.CHERRY_LEAVES.get().getDefaultState();
	protected final int minTreeHeight;

	private final boolean vinesGrow;
	private final BlockState trunk;
	private final BlockState leaf;

	

	
	public CherryTreeFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> configFactoryIn, boolean doBlockNotifyOnPlace)
	{
		this(configFactoryIn, doBlockNotifyOnPlace, 4, TRUNK, LEAF, false);
	}

	public CherryTreeFeature(Function<Dynamic<?>, ? extends TreeFeatureConfig> configFactoryIn, boolean doBlockNotifyOnPlace, int minTreeHeightIn, BlockState trunkState, BlockState leafState, boolean vinesGrowIn)
	{
		super(configFactoryIn);
		this.minTreeHeight = minTreeHeightIn;
		this.trunk = trunkState;
		this.leaf = leafState;
		this.vinesGrow = vinesGrowIn;
	}

	@Override
	protected boolean func_225557_a_(IWorldGenerationReader worldIn, Random rand, BlockPos position, Set<BlockPos> set1, Set<BlockPos> set2, MutableBoundingBox boundsIn, TreeFeatureConfig config)
	{
		int i = this.getHeight(rand);
		boolean flag = true;
		if (position.getY() >= 1 && position.getY() + i + 1 <= worldIn.getMaxHeight())
		{
			for (int j = position.getY(); j <= position.getY() + 1 + i; ++j)
			{
				int k = 1;
				if (j == position.getY())
				{
					k = 0;
				}

				if (j >= position.getY() + 1 + i - 2)
				{
					k = 2;
				}

				BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();

				for (int l = position.getX() - k; l <= position.getX() + k && flag; ++l)
				{
					for (int i1 = position.getZ() - k; i1 <= position.getZ() + k && flag; ++i1)
					{
						if (j >= 0 && j < worldIn.getMaxHeight())
						{
							if (!func_214587_a(worldIn, blockpos$mutableblockpos.setPos(l, j, i1)))
							{
								flag = false;
							}
						}
						else
						{
							flag = false;
						}
					}
				}
			}

			if (!flag)
			{
				return false;
			}
			else if (isSoil(worldIn, position.down(), (IPlantable) BlockInit.CHERRY_SAPLING.get()) && position.getY() < worldIn.getMaxHeight() - i - 1)
			{
				this.setDirtAt(worldIn, position.down(), position);

				for (int l2 = position.getY() - 5 + i; l2 <= position.getY() + i; ++l2)
				{
					int l3 = l2 - (position.getY() + i);
					int j4 = 1 - l3 / 2;

					for (int j1 = position.getX() - j4; j1 <= position.getX() + j4; ++j1)
					{
						int k1 = j1 - position.getX();

						for (int l1 = position.getZ() - j4; l1 <= position.getZ() + j4; ++l1)
						{
							int i2 = l1 - position.getZ();
							if (Math.abs(k1) != j4 || Math.abs(i2) != j4 || rand.nextInt(2) != 0 && l3 != 0)
							{
								BlockPos blockpos = new BlockPos(j1, l2, l1);
								if (isAirOrLeaves(worldIn, blockpos) || isTallPlants(worldIn, blockpos))
								{
									this.func_227217_a_(worldIn, blockpos, this.leaf, boundsIn);
								}
							}
						}
					}
				}

				for (int i3 = 0; i3 < i; ++i3)
				{
					if (isAirOrLeaves(worldIn, position.up(i3)) || isTallPlants(worldIn, position.up(i3)))
					{
						this.func_227217_a_(worldIn, position.up(i3), this.trunk, boundsIn);
						set1.add(position.up(i3).toImmutable());

						if (this.vinesGrow && i3 > 0)
						{
							if (rand.nextInt(3) > 0 && isAir(worldIn, position.add(-1, i3, 0)))
							{
								this.addVine(worldIn, position.add(-1, i3, 0), VineBlock.EAST);
							}

							if (rand.nextInt(3) > 0 && isAir(worldIn, position.add(1, i3, 0)))
							{
								this.addVine(worldIn, position.add(1, i3, 0), VineBlock.WEST);
							}

							if (rand.nextInt(3) > 0 && isAir(worldIn, position.add(0, i3, -1)))
							{
								this.addVine(worldIn, position.add(0, i3, -1), VineBlock.SOUTH);
							}

							if (rand.nextInt(3) > 0 && isAir(worldIn, position.add(0, i3, 1)))
							{
								this.addVine(worldIn, position.add(0, i3, 1), VineBlock.NORTH);
							}
						}
					}
				}

				if (this.vinesGrow)
				{
					for (int j3 = position.getY() - 3 + i; j3 <= position.getY() + i; ++j3)
					{
						int i4 = j3 - (position.getY() + i);
						int k4 = 2 - i4 / 2;
						BlockPos.Mutable blockpos$mutableblockpos1 = new BlockPos.Mutable();

						for (int l4 = position.getX() - k4; l4 <= position.getX() + k4; ++l4)
						{
							for (int i5 = position.getZ() - k4; i5 <= position.getZ() + k4; ++i5)
							{
								blockpos$mutableblockpos1.setPos(l4, j3, i5);
								if (isAirOrLeaves(worldIn, blockpos$mutableblockpos1))
								{
									BlockPos blockpos3 = blockpos$mutableblockpos1.west();
									BlockPos blockpos4 = blockpos$mutableblockpos1.east();
									BlockPos blockpos1 = blockpos$mutableblockpos1.north();
									BlockPos blockpos2 = blockpos$mutableblockpos1.south();
									if (rand.nextInt(4) == 0 && isAir(worldIn, blockpos3))
									{
										this.addHangingVine(worldIn, blockpos3, VineBlock.EAST);
									}

									if (rand.nextInt(4) == 0 && isAir(worldIn, blockpos4))
									{
										this.addHangingVine(worldIn, blockpos4, VineBlock.WEST);
									}

									if (rand.nextInt(4) == 0 && isAir(worldIn, blockpos1))
									{
										this.addHangingVine(worldIn, blockpos1, VineBlock.SOUTH);
									}

									if (rand.nextInt(4) == 0 && isAir(worldIn, blockpos2))
									{
										this.addHangingVine(worldIn, blockpos2, VineBlock.NORTH);
									}
								}
							}
						}
					}
				}

				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	protected int getHeight(Random random)
	{
		return this.minTreeHeight + random.nextInt(5);
	}

	private void addVine(IWorldWriter worldIn, BlockPos pos, BooleanProperty prop)
	{
		this.setBlockState(worldIn, pos, Blocks.VINE.getDefaultState().with(prop, Boolean.valueOf(true)));
	}

	private void addHangingVine(IWorldGenerationReader worldIn, BlockPos pos, BooleanProperty prop)
	{
		this.addVine(worldIn, pos, prop);
		int i = 4;

		for (BlockPos blockpos = pos.down(); isAir(worldIn, blockpos) && i > 0; --i)
		{
			this.addVine(worldIn, blockpos, prop);
			blockpos = blockpos.down();
		}

	}
}
