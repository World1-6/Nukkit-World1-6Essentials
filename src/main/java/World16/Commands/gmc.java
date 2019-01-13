package World16.Commands;

import World16.Main.Main;
import World16.Utils.API;
import World16.Utils.Translate;
import cn.nukkit.IPlayer;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class gmc extends Command {

  private static Main plugin = Main.getInstance();
  API api = new API();

  public gmc(String name) {
    super(name);
    this.setPermission("world16." + name + "." + "permission");
    this.setAliases(new String[] {"gm1"});
    this.setDescription("Set's your gamemode too creative or who's ever gamemode too creative.");
    this.plugin.getServer().getCommandMap().register("gmc", this);
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("Only Players Can Use This Command.");
      return true;
    }

    Player p = (Player) sender;

    if (!p.hasPermission("world16.gmc.permission")) {
      p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
      return true;
    }
    if (args.length == 0) {
    p.setGamemode(Player.CREATIVE);
    p.sendMessage(
        Translate.chat("&6Set game mode &ccreative&6 for " + ((Player) sender).getDisplayName()));
    return true;
  }else {
    IPlayer target = plugin.getServer().getPlayerExact(args[0]);
    if (args.length >= 1 && target != null && target.isOnline()) {
      if (!p.hasPermission("world16.gmc.others.permission")) {
        p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
        return true;
      }
      target.getPlayer().setGamemode(Player.CREATIVE);
      p.sendMessage(
          Translate.chat("&6Set game mode &ccreative&6 for " + target.getPlayer().getDisplayName()));
  }else {
    p.sendMessage(Translate.chat("&cUsage: /gmc OR /gmc <Player>"));
  }
  }
    return true;
  }
}
