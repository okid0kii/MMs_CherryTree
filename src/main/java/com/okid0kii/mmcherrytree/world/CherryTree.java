package com.okid0kii.mmcherrytree.world;


import java.util.Random;

import com.okid0kii.mmcherrytree.init.BlockInit;


import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

public class CherryTree extends Tree {

	public static final TreeFeatureConfig CHERRY_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.CHERRY_LOG.get().getDefaultState()),
			new SimpleBlockStateProvider(BlockInit.CHERRY_LEAVES.get().getDefaultState()),
			new BlobFoliagePlacer(2, 0))).baseHeight(5).heightRandA(2).foliageHeight(4).ignoreVines()
					.setSapling((IPlantable) BlockInit.CHERRY_SAPLING.get()).build();

	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
		//return Feature.NORMAL_TREE.withConfiguration(CHERRY_TREE_CONFIG);
		return Feature.FANCY_TREE.withConfiguration(CHERRY_TREE_CONFIG);
	}
};