package net.antnz.tutorialmod.block.custom;

import net.antnz.tutorialmod.item.ModItems;
import net.antnz.tutorialmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;

public class MagicBlock extends Block {

    public MagicBlock(Settings settings) {
        super(settings);
    }


    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        world.playSound(player, pos, SoundEvents.WEATHER_RAIN, SoundCategory.BLOCKS);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {

        if (entity instanceof ItemEntity itemEntity){
            if (isValidItem(itemEntity.getStack())){

                itemEntity.setStack(new ItemStack(ModItems.PINK_GARNET, itemEntity.getStack().getCount()));

            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.TRANSFORMABLE_ITEMS);
    }


}