package ncc.ls.commands;

import ncc.ls.Main;
import ncc.ls.Validator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LSendListener implements CommandExecutor
{
    
    public Main plugin;

    public LSendListener(Main plugin) 
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args)  
    {
        if (!cs.hasPermission("ls.send")) 
        {
             Main.toChat(cs, "You have no permissions to send link.");
             return false;
        }
        else
        {
            if(!Validator.validURL(args[0]))
            {
                Main.toChat(cs, "Not valid URL.");
                return false;   
            }
            else
            {
                sendLinkGlobal(cs, args[0]);
                Main.toChat(cs, "Link sended.");
                return true;
            }

        }
    }
    
    private void sendLinkGlobal(CommandSender cs,String URL)
    {
        for(Player player: this.plugin.getServer().getOnlinePlayers())
        {
            if(!player.getName().equals(cs.getName()))
            player.sendMessage("LINK: " + URL);
        }
    }
    
}
