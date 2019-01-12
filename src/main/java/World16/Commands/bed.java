package World16.Commands;

import World16.Main.Main;
import World16.Utils.API;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;

public class bed extends Command {

  private static Main plugin = Main.getInstance();
  API api = new API();

  public bed(String name) {
    super(name);
    this.setPermission("world16." + name + "." + "permission");
    this.plugin.getServer().getCommandMap().register("bed", this);
  }


  public boolean execute(CommandSender sender, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("Only Players Can Use This Command.");
      return true;
    }

    Player p = (Player) sender;

    if (!p.hasPermission("world16.bed.permission")) {
      p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
      return true;
    }
    Item item1 = new Item(Item.BED);
    p.getInventory().addItem(item1);
    return true;
  }
}
