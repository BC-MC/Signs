package com.ep2.signs;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener {

	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}

	@EventHandler
	public void colorSign(SignChangeEvent e) {
		e.setLine(0, ChatColor.translateAlternateColorCodes('&', e.getLine(0)));
		e.setLine(1, ChatColor.translateAlternateColorCodes('&', e.getLine(1)));
		e.setLine(2, ChatColor.translateAlternateColorCodes('&', e.getLine(2)));
		e.setLine(3, ChatColor.translateAlternateColorCodes('&', e.getLine(3)));
	}

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		if (e.getLine(0).equals("Website")) {
			e.setLine(0, ChatColor.GREEN + "Website:");
			e.setLine(1, ChatColor.RED + "xex-mc.info");
		}
	}

	@EventHandler
	public void onPlayerIteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		Block block = e.getClickedBlock();
		Action action = e.getAction();

		if (e.getClickedBlock() == null) {
			return;
		}

		if (action == Action.RIGHT_CLICK_BLOCK
				&& block != null
				&& (block.getType() == Material.SIGN_POST || block.getType() == Material.WALL_SIGN)) {
			Sign sign = (Sign) block.getState();
			
			if (sign.getLine(0).equals(ChatColor.GREEN + "Website:") && sign.getLine(1).equals(ChatColor.RED + "xex-mc.info")){
				player.sendMessage(ChatColor.GREEN + "Website: " + ChatColor.RED + "xex-mc.info");
			}
		}

	}

}
