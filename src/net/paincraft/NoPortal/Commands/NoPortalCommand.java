package net.paincraft.NoPortal.Commands;

import net.paincraft.NoPortal.Main;
import net.paincraft.NoPortal.Utilities.ColorUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

/**
 * 
 * @author ElSheriff
 *
 */

public class NoPortalCommand implements CommandExecutor, Listener {
    public static Main plugin;

    public NoPortalCommand(Main instance) {
    this.plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] arguments) {
    if (!(sender instanceof Player)) {
    sender.sendMessage(ColorUtil.getColorConsole(plugin.messagesFile.getConfig().getString("messages.only-player")));
    return true;
    }
    Player player = (Player)sender;
    if (command.getName().equalsIgnoreCase("noportal")) {
    if (arguments.length < 1) {
    player.sendMessage(ColorUtil.getColor("&2&m===================================="));
    player.sendMessage(ColorUtil.getColor("&f "));
    player.sendMessage(ColorUtil.getColor(" &9NoPortal &6by &dElSheriff"));
    player.sendMessage(ColorUtil.getColor(" &aReload Configuration: &e/noportal reload"));
    player.sendMessage(ColorUtil.getColor("&f "));
    player.sendMessage(ColorUtil.getColor("&2&m===================================="));
    } else if (player.hasPermission("noportal.command.reload")) {
    if (arguments[0] == "reload") {}
    plugin.saveConfig();
    plugin.messagesFile.saveConfig();
    plugin.reloadConfig();
    plugin.messagesFile.reloadConfig();
    // Message reload config.
    player.sendMessage(ColorUtil.getColor(plugin.messagesFile.getConfig().getString("messages.reload-config")));
    } else {
    // Message no-permission.
    player.sendMessage(ColorUtil.getColor(plugin.messagesFile.getConfig().getString("messages.no-premission")));
    }}
    return false;
    }}