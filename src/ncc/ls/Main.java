package ncc.ls;


import java.util.logging.Logger;
import ncc.ls.commands.LSendListener;
import ncc.ls.player.InteractListener;
import ncc.ls.player.PlaceListener;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    public static Main statthis;
    public final static Logger log = Logger.getLogger("Minecraft");


    @Override
    public void onEnable()
    {
        this.getCommand("lsend").setExecutor(new LSendListener(this));
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new InteractListener(this), this);
        pm.registerEvents(new PlaceListener(this), this);

        toLog("Plugin enabled.");
    }

    @Override
    public void onDisable()
    {
        toLog("Plugin disabled.");
    }


    public static void toLog(String msg)
    {
    log.info("[LinkSender] " + msg);
    }

    public static void toChat(CommandSender cs, String m)
    {
    cs.sendMessage(ChatColor.GOLD + "[LinkSender] " + m);
    }

    public static void sendLink(CommandSender cs, String link)
    {
    cs.sendMessage("LINK: " + link);
    }

}
