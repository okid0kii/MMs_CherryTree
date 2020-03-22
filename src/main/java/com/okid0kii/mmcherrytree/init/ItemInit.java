package com.okid0kii.mmcherrytree.init;

import com.okid0kii.mmcherrytree.CherryTreeMod;
import com.okid0kii.mmcherrytree.CherryTreeMod.MMsItemGroup;
import com.okid0kii.mmcherrytree.objects.items.FoodItems;

import net.minecraft.item.Item;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	 
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<> (ForgeRegistries.ITEMS, CherryTreeMod.MOD_ID);
	
	public static final RegistryObject<Item> CHERRY_FRUIT = ITEMS.register("cherry_fruit", () -> new Item(new Item.Properties().group(MMsItemGroup.instance).food(FoodItems.CHERRY_FRUIT)));
			

}

