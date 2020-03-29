package com.okid0kii.mmcherrytree.objects.items;

import java.util.Random;

import com.okid0kii.mmcherrytree.world.CherryTreeFeature;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public class CherryTree extends Tree
{
	@Override
	protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random p_225546_1_, boolean p_225546_2_)
	{
		return new CherryTreeFeature(TreeFeatureConfig::func_227338_a_, true).withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG);
		
	}
}
