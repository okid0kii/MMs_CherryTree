package com.okid0kii.mmcherrytree;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.okid0kii.mmcherrytree.init.BlockInit;
import com.okid0kii.mmcherrytree.init.ItemInit;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;


@Mod("mmcherrytree")
@Mod.EventBusSubscriber(modid = CherryTreeMod.MOD_ID, bus = Bus.MOD)

public class CherryTreeMod {

	public static final Logger LOGGER = LogManager.getLogger();
 	public static final String MOD_ID = "mmcherrytree";
	public static CherryTreeMod instance;
 

		public CherryTreeMod() {
			final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
			modEventBus.addListener(this::setup);
			modEventBus.addListener(this::doClientStuff);

			ItemInit.ITEMS.register(modEventBus);
			BlockInit.BLOCKS.register(modEventBus);
		

			instance = this;
			MinecraftForge.EVENT_BUS.register(this);
	}
 

@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();

		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(MMsItemGroup.instance);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});


		LOGGER.debug("Registered BlockItems!");
	}
 

		
 private void setup(final FMLCommonSetupEvent event)
 {
    
 }


 private void doClientStuff(final FMLClientSetupEvent event) 
 {
    
 }

 public void onServerStarting(FMLServerStartingEvent event) 
 {
     
 }

	public static class MMsItemGroup extends ItemGroup {
		public static final ItemGroup instance = new MMsItemGroup(ItemGroup.GROUPS.length, "MiniMod series");

		private MMsItemGroup(int index, String label) {
			super(index, label);
		}
		
	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemInit.CHERRY_FRUIT.get());
	}
  }
}






