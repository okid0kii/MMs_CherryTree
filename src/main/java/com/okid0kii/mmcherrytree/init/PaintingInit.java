package com.okid0kii.mmcherrytree.init;

import com.okid0kii.mmcherrytree.CherryTreeMod;

import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PaintingInit {
	
	public static final DeferredRegister<PaintingType> PAINTING_TYPES = new DeferredRegister<PaintingType> (ForgeRegistries.PAINTING_TYPES, CherryTreeMod.MOD_ID);
	
	public static final RegistryObject<PaintingType> CHERRY_PAINTING = PAINTING_TYPES.register("cherry_painting", () -> new PaintingType(96,48));
	
	
}
