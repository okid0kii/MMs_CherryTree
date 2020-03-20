package com.okid0kii.mmcherrytree.init;

import com.okid0kii.mmcherrytree.CherryTreeMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	 
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<> (ForgeRegistries.BLOCKS, CherryTreeMod.MOD_ID);
	
	//public static final RegistryObject<Block> DEF_BLOCK = BLOCKS.register("def_block", () -> new Block(Block.Properties.create(Material.IRON)));
	
	public static final RegistryObject<Block> CHERRY_LOG = BLOCKS.register("cherry_log", () -> new Block(Block.Properties.create(Material.WOOD)));
}

