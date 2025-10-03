package net.antnz.tutorialmod.component;

import com.mojang.serialization.Codec;
import net.antnz.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.Date;
import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    public static final ComponentType<BlockPos> COORDINATES = register("coordinates", blockPosBuilder -> blockPosBuilder.codec(BlockPos.CODEC));

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderUnaryOperator){
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(TutorialMod.MOD_ID, name),
                builderUnaryOperator.apply(ComponentType.builder()).build());
    }

    public static void registerModDataComponentTypes(){
        TutorialMod.LOGGER.info("Registering Mod Data Component Types for " + TutorialMod.MOD_ID);
    }
}
