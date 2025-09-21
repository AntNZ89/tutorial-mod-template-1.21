package net.antnz.tutorialmod;

import net.antnz.tutorialmod.block.ModBlocks;
import net.antnz.tutorialmod.component.ModDataComponentTypes;
import net.antnz.tutorialmod.item.ModItemGroups;
import net.antnz.tutorialmod.item.ModItems;
import net.antnz.tutorialmod.sound.ModSounds;
import net.antnz.tutorialmod.util.HammerUsageEvent;
import net.antnz.tutorialmod.util.ModTags;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.injection.At;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItems.registerFuels();
		ModItemGroups.registerItemGroups();
		ModDataComponentTypes.registerModDataComponentTypes();
		ModSounds.registerSounds();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());



		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (entity instanceof SheepEntity sheep && world instanceof ServerWorld){
				if (player.getMainHandStack().getItem() == Items.END_ROD){
					player.sendMessage(Text.literal("..."));
					player.getMainHandStack().decrement(1);
					sheep.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 200));
				}
				return ActionResult.PASS;
			}
			return ActionResult.PASS;
		});


	}
}