package com.okid0kii.mmcherrytree.init;

import com.okid0kii.mmcherrytree.CherryTreeMod;
import com.okid0kii.mmcherrytree.CherryTreeMod.MMsItemGroup;
import com.okid0kii.mmcherrytree.objects.items.FoodItems;
import com.okid0kii.mmcherrytree.init.SoundInit;

import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.Rarity;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,
			CherryTreeMod.MOD_ID);

	public static final RegistryObject<Item> CHERRY_FRUIT = ITEMS.register("cherry_fruit",
			() -> new Item(new Item.Properties().group(MMsItemGroup.instance).food(FoodItems.CHERRY_FRUIT)));

	public static final RegistryObject<Item> CHERRY_SAPLING = ITEMS.register("cherry_sapling",
			() -> new BlockItem(BlockInit.CHERRY_SAPLING.get(), new Item.Properties().group(MMsItemGroup.instance)));

	
	//public static final RegistryObject<Item> MUSIC_DISC_CHERRY = ITEMS.register("music_disc_cherry",
		//	() -> new MusicDiscItem(100, SoundInit.MUSIC_DISC_CHERRY, (new Item.Properties()).maxStackSize(1).group(MMsItemGroup.instance).rarity(Rarity.RARE)));

}
