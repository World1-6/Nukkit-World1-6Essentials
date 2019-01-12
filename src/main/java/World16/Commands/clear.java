package World16.Commands;

import World16.Main.Main;
import World16.Utils.API;
import World16.Utils.Translate;
import cn.nukkit.IPlayer;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class clear extends Command {

  private static Main plugin = Main.getInstance();
  API api = new API();
  
  public clear(String name) {
    super(name);
    this.setPermission("world16." + name + "." + "permission");
    this.plugin.getServer().getCommandMap().register("clear", this);
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("Only Players Can Use This Command.");
      return true;
    }

    Player p = (Player) sender;

    if (!p.hasPermission("world16.clear.permission")) {
      p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
      return true;
    }
    if (args.length == 0) {
    p.getInventory().clearAll();
    p.sendMessage(Translate.chat("&6Cleared inventory"));
    }else {
      IPlayer target = plugin.getServer().getPlayerExact(args[0]);
      if (args.length >= 1 && target != null && target.isOnline()) {
        if (!p.hasPermission("world16.clear.others.permission")) {
          p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
          return true;
        }
        target.getPlayer().getInventory().clearAll();
        p.sendMessage(Translate.chat("&6Cleared inventory of &c" + target.getPlayer().getDisplayName()));
      }else {
        p.sendMessage(Translate.chat("&cUsage: /clear OR /clear <Player>"));
      }
    }
    return true;
  }
}
