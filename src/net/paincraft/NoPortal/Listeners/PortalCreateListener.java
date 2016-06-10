package net.paincraft.NoPortal.Listeners;

import net.paincraft.NoPortal.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;

/**
 * 
 * @author ElSheriff
 *
 */

public class PortalCreateListener implements Listener {
    public static Main plugin;

    public PortalCreateListener(Main instance) {
    this.plugin = instance;
    }

    @EventHandler
    public void onPortalCreate(PortalCreateEvent event) {
    if (plugin.getConfig().getBoolean("options.portal-create", true)) {
    event.setCancelled(true);
    } else {
    event.setCancelled(false);
    }
    }}