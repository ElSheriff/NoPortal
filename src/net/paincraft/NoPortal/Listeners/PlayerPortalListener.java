package net.paincraft.NoPortal.Listeners;

import net.paincraft.NoPortal.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

/**
 * 
 * @author ElSheriff
 *
 */

public class PlayerPortalListener implements Listener {
    public static Main plugin;

    public PlayerPortalListener(Main instance) {
    this.plugin = instance;
    }

    @EventHandler
    public void onPortalEnter(PlayerPortalEvent event) {
    Player player = (Player)event.getPlayer();
    if (plugin.getConfig().getBoolean("options.portal-enter", true) && (!player.hasPermission(plugin.getConfig().getString("options.permission")))) {
    event.setCancelled(true);
    } else {
    event.setCancelled(false);
    }}}