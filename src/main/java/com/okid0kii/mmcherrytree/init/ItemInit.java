package com.okid0kii.mmcherrytree.init;

import com.okid0kii.mmcherrytree.CherryTreeMod;
import com.okid0kii.mmcherrytree.CherryTreeMod.MMItemGroup;

import net.minecraft.item.Item;

import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
	 
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<> (ForgeRegistries.ITEMS, CherryTreeMod.MOD_ID);
	
	public static final RegistryObject<Item> DEF_ITEM = ITEMS.register("def_item", () -> new Item(new Item.Properties().group(MMItemGroup.instance)));
}
