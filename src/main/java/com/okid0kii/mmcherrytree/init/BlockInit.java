package com.okid0kii.mmcherrytree.init;

import com.okid0kii.mmcherrytree.CherryTreeMod;


import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class BlockInit {
	 
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<> (ForgeRegistries.BLOCKS, CherryTreeMod.MOD_ID);
	
	public static final RegistryObject<Block> CHERRY_LOG = BLOCKS.register("cherry_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
	
	public static final RegistryObject<Block> CHERRY_WOOD = BLOCKS.register("cherry_wood", () -> new Block(Block.Properties.from(Blocks.OAK_WOOD)));
	
	public static final RegistryObject<Block> CHERRY_PLANKS = BLOCKS.register("cherry_planks", () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	
	public static final RegistryObject<Block> CHERRY_FENCE = BLOCKS.register("cherry_fence", () -> new FenceBlock(Block.Properties.from(Blocks.OAK_FENCE)));
	
	//public static final RegistryObject<Block> CHERRY_FENCE = BLOCKS.register("cherry_fence", () -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	

	//public static final RegistryObject<Block> DEF = BLOCKS.register("def", () -> new Block(Block.Properties.create(Material.WOOD)));
}
