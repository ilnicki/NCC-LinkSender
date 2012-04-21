package ncc.ls.player;

import ncc.ls.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener
{
   private final Main plugin;

   public InteractListener(Main plugin)
   {
	this.plugin = plugin;
   }

   @EventHandler(priority = EventPriority.MONITOR)
   public void onPlayerInteract(PlayerInteractEvent event)
   {
       Block block = event.getClickedBlock();
       if(block.getType().equals(Material.WALL_SIGN) || block.getType().equals(Material.SIGN_POST))
       {
           if (event.getAction() == Action.RIGHT_CLICK_BLOCK)
           {
               Sign s = (Sign) block.getState();
               if (s.getLine(0).equalsIgnoreCase("[Link]"))
               {
                   Main.sendLink(event.getPlayer(), s.getLine(1)+s.getLine(2)+s.getLine(3));
               }
           }
       }
   }
}