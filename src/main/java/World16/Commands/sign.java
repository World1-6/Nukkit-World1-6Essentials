package World16.Commands;

import World16.Main.Main;
import World16.Utils.API;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;

public class sign extends Command {

  private static Main plugin = Main.getInstance();
  API api = new API();
  
  public sign(String name) {
    super(name);
    this.setPermission("world16." + name + "." + "permission");
    this.setDescription("Give's you a sign that's all.");
    this.plugin.getServer().getCommandMap().register("sign", this);
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
    Item item1 = new Item(Item.SIGN);
    p.getInventory().addItem(item1);
    return true;
  }
}
