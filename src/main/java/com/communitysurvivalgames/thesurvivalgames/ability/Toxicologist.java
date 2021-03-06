package com.communitysurvivalgames.thesurvivalgames.ability;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import com.communitysurvivalgames.thesurvivalgames.exception.ArenaNotFoundException;
import com.communitysurvivalgames.thesurvivalgames.managers.SGApi;
import com.communitysurvivalgames.thesurvivalgames.util.CircleUtil;

public class Toxicologist extends SGAbility implements Listener {

	public Toxicologist() {
		super(4);
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onInteract(final PlayerInteractEvent event) {
		Player player = event.getPlayer();
		if (this.hasAbility(player)) {
			final Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 10, player.getLocation().getZ());
			final Random rnd = new Random();
			if (player.getItemInHand().getType() == Material.CLAY_BALL && player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("Toxin Bomb")) {
				CircleUtil.getCircleUtil().playFireworkCircle(event.getPlayer(), FireworkEffect.builder().withColor(Color.SILVER).withFade(Color.GREEN).flicker(true).trail(false).build(), 5, 14);
				Bukkit.getScheduler().runTaskLater(SGApi.getPlugin(), new Runnable() {

					@Override
					public void run() {
						for (int i = 0; i < 15; i++) {
							Potion potion = new Potion(PotionType.POISON, 2);
							potion.setSplash(true);
							ItemStack itemStack = new ItemStack(Material.POTION);
							potion.apply(itemStack);
							Bukkit.getWorlds().get(0);
							ThrownPotion thrownPotion = null;
							try {
								thrownPotion = (ThrownPotion) SGApi.getArenaManager().getArena(event.getPlayer()).getArenaWorld().spawnEntity(loc.add(rnd.nextInt(20) - 10, rnd.nextInt(20) - 10, rnd.nextInt(20) - 10), EntityType.SPLASH_POTION);
							} catch (ArenaNotFoundException e) {
								e.printStackTrace();
							}
							thrownPotion.setItem(itemStack);
						}
					}
				}, 100L);
			}
		}
	}
}
