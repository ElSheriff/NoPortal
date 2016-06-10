package net.paincraft.NoPortal;

import net.paincraft.NoPortal.Commands.NoPortalCommand;
import net.paincraft.NoPortal.Files.MessagesFile;
import net.paincraft.NoPortal.Listeners.PlayerPortalListener;
import net.paincraft.NoPortal.Listeners.PortalCreateListener;
import net.paincraft.NoPortal.Utilities.ConfigUtil;
import net.paincraft.NoPortal.Utilities.UpdateCheckerUtil;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * 
 * @author ElSheriff
 *
 */

public class Main extends JavaPlugin implements Listener {
    private static Main instance;
    public static ConfigUtil messagesFile;

    public static Main getInstance() {
    return instance;
    }

    public void startPlugin() {
    loadFiles();
    registerFiles();
    registerCommands();
    registerListeners();
    }

    @Override
    public void onEnable() {
    instance = this;
    getServer().getConsoleSender().sendMessage(UpdateCheckerUtil.getInstance().ConsoleUpdateChecker());

    startPlugin();
    saveDefaultConfig();
    }

    @Override
    public void onDisable() {
    saveDefaultConfig();
    }

    // Load the files of the plugin.
    public void loadFiles() {
    MessagesFile.loadMessagesConfig();
    }

    // Register the files of the plugin.
    public void registerFiles() {
    getServer().getPluginManager().registerEvents(new MessagesFile(this), this);
    }

    // Register the commands of the plugin.
    public void registerCommands() {
    getCommand("noportal").setExecutor(new NoPortalCommand(this));

    getServer().getPluginManager().registerEvents(new NoPortalCommand(this), this);
    }

    // Register the listeners of the plugin.
    public void registerListeners() {
    getServer().getPluginManager().registerEvents(this, this);
    getServer().getPluginManager().registerEvents(new PlayerPortalListener(this), this);
    getServer().getPluginManager().registerEvents(new PortalCreateListener(this), this);
    }}