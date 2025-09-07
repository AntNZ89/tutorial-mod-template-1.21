package net.antnz.tutorialmod.util;

import net.antnz.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {


    public static class Blocks{

        public static final TagKey<Block> INCORRECT_FOR_PINK_GARNET_TOOL = register("incorrect_for_pink_garnet_tool");

        public static final TagKey<Block> NEEDS_PINK_GARNET_TOOL = register("needs_pink_garnet_tool");


        private static TagKey<Block> register(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TutorialMod.MOD_ID, name));
        }

    }


    public static class Items{

        public static final TagKey<Item> TRANSFORMABLE_ITEMS = register("transformable_items");

        public static final TagKey<Item> TEST = register("test");


        private static TagKey<Item> register(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name));
        }
    }







}
