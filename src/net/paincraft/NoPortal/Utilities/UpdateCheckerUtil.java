package net.paincraft.NoPortal.Utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import net.paincraft.NoPortal.Main;

/**
 * 
 * @author ElSheriff
 *
 */

public class UpdateCheckerUtil {
    private static Main plugin = Main.getInstance();
    private static UpdateCheckerUtil instance = new UpdateCheckerUtil();

    public static UpdateCheckerUtil getInstance() {
    return instance;
    }

    /**
    *
    * Credits to @Maximvdw
    * For making this method.
    * @Maximvdw: https://www.spigotmc.org/members/maximvdw.6687/
    *
    */
    public String ConsoleUpdateChecker() {
    try {
    HttpURLConnection connection = (HttpURLConnection) new URL("http://www.spigotmc.org/api/general.php").openConnection();
    connection.setDoOutput(true);
    connection.setRequestMethod("POST");
    connection.getOutputStream().write(("key=98BE0FE67F88AB82B4C197FAF1DC3B69206EFDCC4D3B80FC83A00037510B99B4&resource=" + "24642").getBytes("UTF-8"));
    String NewVersion = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine().replaceAll("[a-zA-Z ]", "");
    String OldVersion = plugin.getDescription().getVersion();
    if (!NewVersion.equals(OldVersion)) {
    return ColorUtil.getColorConsole("&9NoPortal &8| &cNew update for NoPortal is available for download on Spigot!");  
    }
    } catch (Exception exception) {
    plugin.getLogger().info(ColorUtil.getColorConsole("&9NoPortal &8| &cFailed to check for a update on spigot."));
    }
    return ColorUtil.getColorConsole("&9NoPortal &8| &aNo updates avialable at this time.");
    }}