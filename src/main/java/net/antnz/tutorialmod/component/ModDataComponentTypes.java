package net.antnz.tutorialmod.component;

import com.mojang.serialization.Codec;
import net.antnz.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {



    public static void registerDataComponentTypes(){
        TutorialMod.LOGGER.info("Registering Data Component Types for " + TutorialMod.MOD_ID);
    }



}
