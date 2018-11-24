package Commands;

import Utils.API;
import Utils.Translate;
import World16.World16.World16.Main;
import cn.nukkit.IPlayer;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class gms extends Command {

  private static Main plugin = Main.getInstance();
  API api = new API();
  
  public gms(String name) {
    super(name);
    this.setPermission("world16." + name + "." + "permission");
    this.setAliases(new String[] {"gm0"});
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("Only Players Can Use This Command.");
      return true;
    }

    Player p = (Player) sender;

    if (!p.hasPermission("world16.gms.permission")) {
      p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
      return true;
    }
    if (args.length == 0) {
    p.setGamemode(Player.SURVIVAL);
    p.sendMessage(
        Translate.chat("&6Set game mode &csurvival&6 for " + ((Player) sender).getDisplayName()));
    return true;
  }else {
    IPlayer target = plugin.getServer().getPlayerExact(args[0]);
    if (args.length >= 1 && target != null && target.isOnline()) {
      if (!p.hasPermission("world16.gms.others.permission")) {
        p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
        return true;
      }
      target.getPlayer().setGamemode(Player.SURVIVAL);
      p.sendMessage(
          Translate.chat("&6Set game mode &csurvival&6 for " + target.getPlayer().getDisplayName()));
    }else {
      p.sendMessage(Translate.chat("&cUsage: /gms OR /gms <Player>"));
    }
  }
    return true;
  }
}