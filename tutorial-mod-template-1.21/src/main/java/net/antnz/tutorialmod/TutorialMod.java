package net.antnz.tutorialmod;

import net.antnz.tutorialmod.block.ModBlocks;
import net.antnz.tutorialmod.component.ModDataComponentTypes;
import net.antnz.tutorialmod.item.ModItemGroups;
import net.antnz.tutorialmod.item.ModItems;
import net.antnz.tutorialmod.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

	}
}