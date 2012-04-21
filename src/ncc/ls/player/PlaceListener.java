package ncc.ls.player;

import ncc.ls.Main;
import ncc.ls.Validator;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.inventory.ItemStack;

public class PlaceListener implements Listener
{
   private Player player;
   private Block block;

   private final Main plugin;

   public PlaceListener(Main plugin)
   {
	this.plugin = plugin;
   }
@EventHandler(priority = EventPriority.MONITOR)
public void onSignChange(SignChangeEvent arg0)
   {
       if (!arg0.getLine(0).equalsIgnoreCase("[Link]")) return;

       block = arg0.getBlock();
	if (block == null) return;

       player = arg0.getPlayer();

       if (!player.hasPermission("ls.create"))
       {
           signDrop();
           Main.toChat(player, "You have no permissions to place link.");
           return;
       }

       if(!Validator.validURL(arg0.getLine(1) + arg0.getLine(2) + arg0.getLine(3)))
       {
           signDrop();
           Main.toChat(player, "Not valid URL.");
           return;
       }

       Main.toChat(player, "Link successfully created.");
}

   private void signDrop()
   {
       ItemStack sign = new ItemStack(323, 1);

       player.getWorld().dropItem(block.getLocation(), sign);
       block.setTypeId(0);
   }


}