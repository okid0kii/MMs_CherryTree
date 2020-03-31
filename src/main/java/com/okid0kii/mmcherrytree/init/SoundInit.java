package com.okid0kii.mmcherrytree.init;

import com.okid0kii.mmcherrytree.CherryTreeMod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

	public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS,
			CherryTreeMod.MOD_ID);

	public static final RegistryObject<SoundEvent> MUSIC_DISC_CHERRY = SOUNDS.register("init.ItemInit.music_disc_cherry",
			() -> new SoundEvent(new ResourceLocation(CherryTreeMod.MOD_ID, "music_disc.cherry")));
}
