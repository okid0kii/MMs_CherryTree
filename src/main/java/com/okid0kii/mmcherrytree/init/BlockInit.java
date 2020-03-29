package com.okid0kii.mmcherrytree.init;

import com.okid0kii.mmcherrytree.CherryTreeMod;
import com.okid0kii.mmcherrytree.objects.blocks.SculptureBlock;
import com.okid0kii.mmcherrytree.objects.items.CherryTree;

import net.minecraft.block.Block;

import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.GlazedTerracottaBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.SaplingBlock;
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

//VEGETABLES
	public static final RegistryObject<Block> CHERRY_LEAVES = BLOCKS.register("cherry_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

//DECORATION
	public static final RegistryObject<Block> CHERRY_CARVED = BLOCKS.register("cherry_carved",  () -> new GlazedTerracottaBlock(Block.Properties.from(Blocks.OAK_PLANKS)));
	public static final RegistryObject<Block> CHERRY_TANUKI = BLOCKS.register("cherry_tanuki", () -> new SculptureBlock(Block.Properties.from(Blocks.OAK_PLANKS)));
	
//BLOCKITEMS
	public static final DeferredRegister<Block> NO_BLOCKS = new DeferredRegister<> (ForgeRegistries.BLOCKS, CherryTreeMod.MOD_ID);
	public static final RegistryObject<Block> CHERRY_SAPLING = NO_BLOCKS.register("cherry_sapling", () -> new SaplingBlock(new CherryTree(), Block.Properties.from(Blocks.OAK_SAPLING)) {});


}  

	










