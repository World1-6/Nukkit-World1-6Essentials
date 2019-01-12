package World16.Commands;

import World16.Main.Main;
import World16.Utils.API;
import World16.Utils.Translate;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import java.util.ArrayList;

public class afk extends Command {

  public static ArrayList<String> Afk = new ArrayList<String>();

  private static Main plugin = Main.getInstance();
  API api = new API();

  public afk(String name) {
    super(name);
    this.setPermission("world16." + name + "." + "permission");
    this.plugin.getServer().getCommandMap().register("afk", this);
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("Only Players Can Use This Command.");
      return true;
    }

    Player p = (Player) sender;

    if (!p.hasPermission("world16.afk.permission")) {
      p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
      return true;
    }
    if (args.length == 0) {
      if (!Afk.contains(p.getDisplayName())) {
        plugin.getServer().broadcastMessage(
            Translate.chat("&8<&4&lAFK&r&8>&r " + p.getDisplayName() + " &chas GONE afk."));
        Afk.add(p.getDisplayName());
      } else if (Afk.contains(p.getDisplayName())) {
        plugin.getServer().broadcastMessage(
            Translate.chat("&8<&4&lAFK&r&8>&r " + p.getDisplayName() + " &2is now back from afk."));
        Afk.remove(p.getDisplayName());
        return true;
      }
    }
    return true;
  }
}
