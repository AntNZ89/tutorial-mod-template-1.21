package net.antnz.tutorialmod.util;

import net.antnz.tutorialmod.TutorialMod;
import net.antnz.tutorialmod.component.ModDataComponentTypes;
import net.antnz.tutorialmod.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicates {
    public static void registerModelPredicates(){
        ModelPredicateProviderRegistry.register(ModItems.CHISEL, Identifier.of(TutorialMod.MOD_ID, "used"),
                (stack, world, entity, seed) -> stack.get(ModDataComponentTypes.COORDINATES) != null? 1f : 0f);
    }
}
