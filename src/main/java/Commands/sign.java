package Commands;

import Utils.API;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;

public class sign extends Command {

  API api = new API();
  
  public sign(String name) {
    super(name);
    this.setPermission("world16." + name + "." + "permission");
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("Only Players Can Use This Command.");
      return true;
    }

    Player p = (Player) sender;

    if (!p.hasPermission("world16.sign.permission")) {
      p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
      return true;
    }
    Item item1 = new Item(Item.SIGN, 1);
    p.getInventory().addItem(item1);
    return true;
  }
}
