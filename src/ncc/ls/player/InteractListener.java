package ncc.ls.player;

import ncc.ls.Main;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener 
{
	  @EventHandler(priority = EventPriority.MONITOR)
	  public void onPlayerInteract(PlayerInteractEvent arg0)
          {
		  if (arg0.getAction() != Action.RIGHT_CLICK_BLOCK) return;
		  
		  Block b = arg0.getClickedBlock();
		  if (b == null) return;
		  
		  Sign s = (Sign) b.getState();
		  if (!s.getLine(0).equalsIgnoreCase("[Link]")) return;
                  
                  Main.sendLink(arg0.getPlayer(), s.getLine(1)+s.getLine(2)+s.getLine(3));
	  }
          

}