package com.okid0kii.mmcherrytree.init;

import com.okid0kii.mmcherrytree.CherryTreeMod;


import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class BlockInit {
	 
	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<> (ForgeRegistries.BLOCKS, CherryTreeMod.MOD_ID);
	
	
//LOGBLOCKS "RotatedPillarBlock"
	public static final RegistryObject<Block> CHERRY_LOG = BLOCKS.register("cherry_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
	public static final RegistryObject<Block> STRIPPED_CHERRY_LOG = BLOCKS.register("stripped_cherry_log", () -> new LogBlock(MaterialColor.WOOD,Block.Properties.from(Blocks.STRIPPED_OAK_LOG)));
	
//BLOCKS "Simple Block"
	public static final RegistryObject<Block> CHERRY_WOOD = BLOCKS.register("cherry_wood", () -> new Block(Block.Properties.from(Blocks.OAK_WOOD)));
	public static final RegistryObject<Block> STRIPPED_CHERRY_WOOD = BLOCKS.register("stripped_cherry_wood", () -> new Block(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)));
	public static final RegistryObject<Block> CHERRY_PLANKS = BLOCKS.register("cherry_planks", () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	
//CONSTRUCTION BLOCKS
	public static final RegistryObject<Block> CHERRY_WOOD_FENCE = BLOCKS.register("cherry_wood_fence", () -> new FenceBlock(Block.Properties.from(Blocks.OAK_FENCE)));
	public static final RegistryObject<Block> CHERRY_FENCE = BLOCKS.register("cherry_fence", () -> new FenceBlock(Block.Properties.from(Blocks.OAK_FENCE)));
	
	public static final RegistryObject<Block> CHERRY_SLAB = BLOCKS.register("cherry_slab", () -> new SlabBlock(Block.Properties.from(Blocks.OAK_SLAB)));
	public static final RegistryObject<Block> CHERRY_WOOD_SLAB = BLOCKS.register("cherry_wood_slab", () -> new SlabBlock(Block.Properties.from(Blocks.OAK_SLAB)));
	
	public static final RegistryObject<Block> CHERRY_STAIRS = BLOCKS.register("cherry_stairs", () -> new StairsBlock(() -> BlockInit.CHERRY_PLANKS.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)));
	public static final RegistryObject<Block> CHERRY_WOOD_STAIRS = BLOCKS.register("cherry_wood_stairs", () -> new StairsBlock(() -> BlockInit.CHERRY_WOOD.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)));
}
