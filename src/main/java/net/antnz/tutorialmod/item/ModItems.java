package net.antnz.tutorialmod.item;

import net.antnz.tutorialmod.TutorialMod;
import net.antnz.tutorialmod.item.custom.Chisel;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final FoodComponent FOOD_COMPONENT = new FoodComponent.Builder().statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 100),1f).build();


    public static final Item CHISEL = registerItem("chisel", new Chisel(new Item.Settings()));


    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));

    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(FOOD_COMPONENT)));

    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));

    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));



    public static Chisel registerChisel(String name, Chisel chisel){
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), chisel);
    }


    public static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }



    public static void registerModItems(){

        TutorialMod.LOGGER.info("Registering items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModItems.PINK_GARNET);
            fabricItemGroupEntries.add(ModItems.RAW_PINK_GARNET);


        });



    }

    public static void registerFuels(){
        FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES,200);
    }





}
