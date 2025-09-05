package net.antnz.tutorialmod.datagen;

import net.antnz.tutorialmod.block.ModBlocks;
import net.antnz.tutorialmod.block.custom.PinkGarnetLampBlock;
import net.antnz.tutorialmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.AnimalArmorItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider{

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {


        BlockStateModelGenerator.BlockTexturePool blockTexturePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.PINK_GARNET_BLOCK);
        
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        
        blockTexturePool.slab(ModBlocks.PINK_GARNET_SLAB);
        blockTexturePool.stairs(ModBlocks.PINK_GARNET_STAIRS);
        blockTexturePool.wall(ModBlocks.PINK_GARNET_WALL);
        blockTexturePool.fence(ModBlocks.PINK_GARNET_FENCE);
        blockTexturePool.fenceGate(ModBlocks.PINK_GARNET_FENCE_GATE);
        blockTexturePool.pressurePlate(ModBlocks.PINK_GARNET_PRESSURE_PLATE);
        blockTexturePool.button(ModBlocks.PINK_GARNET_BUTTON);


        blockStateModelGenerator.registerTrapdoor(ModBlocks.PINK_GARNET_TRAPDOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.PINK_GARNET_DOOR);


        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.PINK_GARNET_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.PINK_GARNET_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.PINK_GARNET_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(PinkGarnetLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
//        itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);
        
        itemModelGenerator.register(ModItems.PINK_GARNET_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PINK_GARNET_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.PINK_GARNET_HAMMER, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_BOOTS));
        
        itemModelGenerator.register(ModItems.PINK_GARNET_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.KAUPEN_SMITHING_TEMPLATE, Models.GENERATED);
        
        
    }
}
