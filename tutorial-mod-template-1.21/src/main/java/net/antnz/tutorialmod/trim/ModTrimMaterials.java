package net.antnz.tutorialmod.trim;

import net.antnz.tutorialmod.TutorialMod;
import net.antnz.tutorialmod.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class ModTrimMaterials {

    public static final RegistryKey<ArmorTrimMaterial> PINK_GARNET = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(TutorialMod.MOD_ID, "pink_garnet"));


    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable){
        register(registerable, PINK_GARNET, Registries.ITEM.getEntry(ModItems.PINK_GARNET),
                Style.EMPTY.withColor(TextColor.parse("#b03fe0").getOrThrow()), 1.0f);
    }


    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimMaterialRegistryKey,
                                 RegistryEntry<Item> item, Style style, float itemModelIndex){

        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(armorTrimMaterialRegistryKey.getValue().getPath(), item, itemModelIndex, Map.of(),
                Text.translatable(Util.createTranslationKey("trim_material", armorTrimMaterialRegistryKey.getValue())).fillStyle(style));

        registerable.register(armorTrimMaterialRegistryKey, trimMaterial);


    }



}
