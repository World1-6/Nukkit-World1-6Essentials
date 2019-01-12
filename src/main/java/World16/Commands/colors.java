package World16.Commands;

import World16.Main.Main;
import World16.Utils.API;
import World16.Utils.Translate;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class colors extends Command {

  private static Main plugin = Main.getInstance();
  API api = new API();

  public colors(String name) {
    super(name);
    this.setPermission("world16." + name + "." + "permission");
    this.setDescription("Show's the color codes.");
    this.plugin.getServer().getCommandMap().register("colors", this);
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("Only Players Can Use This Command.");
      return true;
    }

    Player p = (Player) sender;

    if (!p.hasPermission("world16.colors.permission")) {
      p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
      /* PERMISSION ERROR MESSAGE */ return true;
    }
    p.sendMessage("Dark Red &4 " + Translate.chat("&4EXAMPLE"));
    p.sendMessage("Red &c " + Translate.chat("&cEXAMPLE"));
    p.sendMessage("Gold &6 " + Translate.chat("&6EXAMPLE"));
    p.sendMessage("Yellow &e " + Translate.chat("&eEXAMPLE"));
    p.sendMessage("Dark Green &2" + Translate.chat("&2EXAMPLE"));
    p.sendMessage("Green &a " + Translate.chat("&aEXAMPLE"));
    p.sendMessage("Aqua &b " + Translate.chat("&bEXAMPLE"));
    p.sendMessage("Dark Aqua &3 " + Translate.chat("&3EXAMPLE"));
    p.sendMessage("Dark Blue &1 " + Translate.chat("&1EXAMPLE"));
    p.sendMessage("Blue &9 " + Translate.chat("&9EXAMPLE"));
    p.sendMessage("Light Purple &d " + Translate.chat("&dEXAMPLE"));
    p.sendMessage("Dark Purple &5 " + Translate.chat("&5EXAMPLE"));
    p.sendMessage("White &f " + Translate.chat("&fEXAMPLE"));
    p.sendMessage("Gray &7 " + Translate.chat("&7EXAMPLE"));
    p.sendMessage("Dark Gray &8 " + Translate.chat("&8EXAMPLE"));
    p.sendMessage("Black &0 " + Translate.chat("&0EXAMPLE"));
    return true;
  }
}
