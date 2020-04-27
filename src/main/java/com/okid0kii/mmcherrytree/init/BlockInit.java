package com.okid0kii.mmcherrytree.init;

import com.okid0kii.mmcherrytree.CherryTreeMod;
import com.okid0kii.mmcherrytree.objects.blocks.SculptureBlock;
import com.okid0kii.mmcherrytree.objects.blocks.TrapDoorBlockMod;
import com.okid0kii.mmcherrytree.world.CherryTree;
import com.okid0kii.mmcherrytree.objects.blocks.DoorBlockMod;
import com.okid0kii.mmcherrytree.objects.blocks.PaneBlockMod;
import com.okid0kii.mmcherrytree.objects.blocks.SaplingBlockMod;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.GlazedTerracottaBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,
			CherryTreeMod.MOD_ID);
	public static final DeferredRegister<Block> NO_BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,
			CherryTreeMod.MOD_ID);

//LOGBLOCKS "RotatedPillarBlock"
	public static final RegistryObject<Block> CHERRY_LOG = BLOCKS.register("cherry_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));

	public static final RegistryObject<Block> STRIPPED_CHERRY_LOG = BLOCKS.register("stripped_cherry_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.STRIPPED_OAK_LOG)));

//BLOCKS "Simple Block"
	public static final RegistryObject<Block> CHERRY_WOOD = BLOCKS.register("cherry_wood",
			() -> new RotatedPillarBlock(Block.Properties.from(Blocks.OAK_WOOD)));

	public static final RegistryObject<Block> STRIPPED_CHERRY_WOOD = BLOCKS.register("stripped_cherry_wood",
			() -> new Block(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)));

	public static final RegistryObject<Block> CHERRY_PLANKS = BLOCKS.register("cherry_planks",
			() -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));

//CONSTRUCTION BLOCKS
	public static final RegistryObject<Block> CHERRY_WOOD_FENCE = BLOCKS.register("cherry_wood_fence",
			() -> new FenceBlock(Block.Properties.from(Blocks.OAK_FENCE)));

	public static final RegistryObject<Block> CHERRY_WOOD_FENCE_GATE = BLOCKS.register("cherry_wood_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));

	public static final RegistryObject<Block> CHERRY_FENCE = BLOCKS.register("cherry_fence",
			() -> new FenceBlock(Block.Properties.from(Blocks.OAK_FENCE)));

	public static final RegistryObject<Block> CHERRY_FENCE_GATE = BLOCKS.register("cherry_fence_gate",
			() -> new FenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)));

	public static final RegistryObject<Block> CHERRY_SLAB = BLOCKS.register("cherry_slab",
			() -> new SlabBlock(Block.Properties.from(Blocks.OAK_SLAB)));

	public static final RegistryObject<Block> CHERRY_WOOD_SLAB = BLOCKS.register("cherry_wood_slab",
			() -> new SlabBlock(Block.Properties.from(Blocks.OAK_SLAB)));

	public static final RegistryObject<Block> CHERRY_STAIRS = BLOCKS.register("cherry_stairs",
			() -> new StairsBlock(() -> BlockInit.CHERRY_PLANKS.get().getDefaultState(),
					Block.Properties.from(Blocks.OAK_STAIRS)));

	public static final RegistryObject<Block> CHERRY_WOOD_STAIRS = BLOCKS.register("cherry_wood_stairs",
			() -> new StairsBlock(() -> BlockInit.CHERRY_WOOD.get().getDefaultState(),
					Block.Properties.from(Blocks.OAK_STAIRS)));

	public static final RegistryObject<Block> CHERRY_WALL = BLOCKS.register("cherry_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.OAK_PLANKS)));

	public static final RegistryObject<Block> CHERRY_WOOD_WALL = BLOCKS.register("cherry_wood_wall",
			() -> new WallBlock(Block.Properties.from(Blocks.OAK_PLANKS)));

//VEGETABLES
	public static final RegistryObject<Block> CHERRY_LEAVES = BLOCKS.register("cherry_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

	public static final RegistryObject<Block> CHERRY_SAPLING = NO_BLOCKS.register("cherry_sapling",
			() -> new SaplingBlockMod(() -> new CherryTree(), Block.Properties.from(Blocks.OAK_SAPLING)));

//DECORATION
	public static final RegistryObject<Block> CHERRY_CARVED = BLOCKS.register("cherry_carved",
			() -> new GlazedTerracottaBlock(Block.Properties.from(Blocks.OAK_PLANKS)));

	public static final RegistryObject<Block> CHERRY_TANUKI = BLOCKS.register("cherry_tanuki",
			() -> new SculptureBlock(Block.Properties.from(Blocks.OAK_PLANKS)));

	public static final RegistryObject<Block> CHERRY_GLASS = BLOCKS.register("cherry_glass",
			() -> new Block(Block.Properties.from(Blocks.GLASS)));

	public static final RegistryObject<Block> CHERRY_PANE = BLOCKS.register("cherry_pane",
			() -> new PaneBlockMod(Block.Properties.from(Blocks.GLASS_PANE)));

//FURNITURE
	public static final RegistryObject<Block> CHERRY_DOOR = BLOCKS.register("cherry_door",
			() -> new DoorBlockMod(Block.Properties.from(Blocks.OAK_DOOR)));

	public static final RegistryObject<Block> CHERRY_TRAPDOOR = BLOCKS.register("cherry_trapdoor",
			() -> new TrapDoorBlockMod(Block.Properties.from(Blocks.OAK_TRAPDOOR)));


/*SIGN PANEL	
	public static final RegistryObject<Block> CHERRY_SIGN = BLOCKS.register("cherry_sign",
			() -> new StandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement()
					.hardnessAndResistance(1.0F).sound(SoundType.WOOD), WoodType.OAK));
	
	public static final RegistryObject<Block> CHERRY_WALL_SIGN = BLOCKS.register("cherry_wall_sign",
			() -> new WallSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F)
					.sound(SoundType.WOOD).lootFrom(CHERRY_SIGN.get()), WoodType.OAK));*/

}
