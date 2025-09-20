package net.antnz.tutorialmod.block;

import net.antnz.tutorialmod.TutorialMod;
import net.antnz.tutorialmod.block.custom.MagicBlock;
import net.antnz.tutorialmod.block.custom.PinkGarnetLampBlock;
import net.antnz.tutorialmod.sound.ModSounds;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {


    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block", new Block(AbstractBlock.Settings.create()));

    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block", new Block(AbstractBlock.Settings.create()));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block", new MagicBlock(AbstractBlock.Settings.create()
            .luminance(state-> 15).sounds(ModSounds.MAGIC_BLOCK_SOUNDS)));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2,5), AbstractBlock.Settings.create()));

    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore", new ExperienceDroppingBlock(UniformIntProvider.create(100,200),
            AbstractBlock.Settings.create()));




    public static final Block PINK_GARNET_STAIRS = registerBlock("pink_garnet_stairs", new StairsBlock(ModBlocks.PINK_GARNET_BLOCK.getDefaultState(),
            AbstractBlock.Settings.create()));

    public static final Block PINK_GARNET_SLAB = registerBlock("pink_garnet_slab", new SlabBlock(AbstractBlock.Settings.create()));

    public static final Block PINK_GARNET_BUTTON = registerBlock("pink_garnet_button", new ButtonBlock(BlockSetType.IRON, 2, AbstractBlock.Settings.create().noCollision()));

    public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock("pink_garnet_pressure_plate", new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create()));

    public static final Block PINK_GARNET_FENCE = registerBlock("pink_garnet_fence", new FenceBlock(AbstractBlock.Settings.create()));

    public static final Block PINK_GARNET_FENCE_GATE = registerBlock("pink_garnet_fence_gate", new FenceGateBlock(WoodType.WARPED, AbstractBlock.Settings.create()));

    public static final Block PINK_GARNET_WALL = registerBlock("pink_garnet_wall", new WallBlock(AbstractBlock.Settings.create()));

    public static final Block PINK_GARNET_DOOR = registerBlock("pink_garnet_door", new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().nonOpaque()));

    public static final Block PINK_GARNET_TRAPDOOR = registerBlock("pink_garnet_trapdoor", new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().nonOpaque()));

    public static final Block PINK_GARNET_LAMP = registerBlock("pink_garnet_lamp",
            new PinkGarnetLampBlock(AbstractBlock.Settings.create().luminance(state-> state.get(PinkGarnetLampBlock.CLICKED)? 0:15)));



    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("Registering blocks for " + TutorialMod.MOD_ID);
    }

}
