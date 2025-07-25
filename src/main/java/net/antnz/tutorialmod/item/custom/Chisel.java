package net.antnz.tutorialmod.item.custom;

import net.antnz.tutorialmod.block.ModBlocks;
import net.antnz.tutorialmod.component.ModDataComponentTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.ComponentType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class Chisel extends Item {


    public static final Map<Block, Block> CHISEL_MAP =
            Map.of(
                    Blocks.GRASS_BLOCK, ModBlocks.PINK_GARNET_LAMP
            );


    public Chisel(Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        Block clickedBlock = world.getBlockState(pos).getBlock();

        if (world instanceof ServerWorld){
            if (CHISEL_MAP.containsKey(clickedBlock)){

                world.setBlockState(pos, CHISEL_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, pos, SoundEvents.WEATHER_RAIN, SoundCategory.BLOCKS);

                context.getStack().set(ModDataComponentTypes.COORDINATES, pos);

            }
        }
        return ActionResult.SUCCESS;

    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {

        tooltip.add(Text.translatable("tipp1"));

        if (stack.get(ModDataComponentTypes.COORDINATES) != null){
            tooltip.add(Text.literal("§4Last clicked block at: " + stack.get(ModDataComponentTypes.COORDINATES)));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
