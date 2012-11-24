package com.wolvencraft.prison.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.wolvencraft.prison.PrisonSuite;
import com.wolvencraft.prison.hooks.WorldEditHook;
import com.wolvencraft.prison.region.PrisonSelection;
import com.wolvencraft.prison.settings.Settings;
import com.wolvencraft.prison.util.Message;

public class WandListener implements Listener
{
	public WandListener(PrisonSuite plugin)
	{
        Message.debug("Initiating PlayerInteractListener");
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if(event.isCancelled()) return;
		
		Player player = event.getPlayer();
		Settings settings = PrisonSuite.getSettings();
		ItemStack wand = new ItemStack(settings.WAND);
		
		if(!player.getItemInHand().equals(wand)
			|| !player.hasPermission("prison.select")
			|| (WorldEditHook.usingWorldEdit() && WorldEditHook.getWandItem() == settings.WAND)) return;
		
		if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			Location loc = event.getClickedBlock().getLocation();
			PrisonSelection selection = PrisonSuite.getSelection(player);
			selection.setFirstCoordinate(loc);
			event.setCancelled(true);

			String message = "First point selected (" + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ() + ")";
			if(selection.locationsSet()) message = message + ": " + selection.getBlockCount() + " blocks";
			Message.sendSuccess(player, message);
			return;
		}
		else if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			Location loc = event.getClickedBlock().getLocation();
			PrisonSelection selection = PrisonSuite.getSelection(player);
			selection.setSecondCoordinate(loc);
			event.setCancelled(true);

			String message = "Second point selected (" + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ() + ")";
			if(selection.locationsSet()) message = message + ": " + selection.getBlockCount() + " blocks";
			Message.sendSuccess(player, message);
			return;
		}
		else return;

	}
}
