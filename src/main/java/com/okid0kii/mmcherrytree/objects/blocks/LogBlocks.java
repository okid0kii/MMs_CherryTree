package com.okid0kii.mmcherrytree.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;

public class LogBlocks extends LogBlock {

	
	
	public LogBlocks(MaterialColor verticalColorIn, Properties properties) {
		super(verticalColorIn, properties);
		

	}

	public static final LogBlocks CHERRY_LOG = new LogBlocks(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG));
	
}