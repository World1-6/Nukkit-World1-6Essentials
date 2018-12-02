package Commands;

import java.util.ArrayList;
import Utils.API;
import Utils.Translate;
import World16.World16.World16.Main;
import cn.nukkit.IPlayer;
import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class fly extends Command {

  private static Main plugin = Main.getInstance();
  API api = new API();
  public static ArrayList<String> Fly = new ArrayList<String>();
  public int gamemmode;


  public fly(String name) {
    super(name);
    this.gamemmode = Server.getInstance().getGamemode();
    this.setPermission("world16." + name + "." + "permission");
    this.plugin.getServer().getCommandMap().register("fly", this);
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("Only Players Can Use This Command.");
      return true;
    }

    Player p = (Player) sender;

    if (!p.hasPermission("world16.fly.permission")) {
      p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
      return true;
    }
    if (args.length == 0) {
      if (!Fly.contains(p.getDisplayName()) && (this.gamemmode != Player.CREATIVE)) {
        p.setAllowFlight(true);
        p.sendMessage(Translate.chat("&6Set fly mode &cenabled&6 for " + p.getDisplayName()));
        Fly.add(p.getDisplayName());
      } else if (Fly.contains(p.getDisplayName())) {
        p.setAllowFlight(false);
        p.sendMessage(Translate.chat("&6Set fly mode &cdisabled&6 for " + p.getDisplayName()));
        Fly.remove(p.getDisplayName());
      }else {
        IPlayer target = plugin.getServer().getPlayerExact(args[0]);
        if (args.length >= 1 && target != null && target.isOnline()) {
          if (!p.hasPermission("world16.fly.others.permission")) {
            p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
            return true;
          }
          if (!Fly.contains(target.getPlayer().getDisplayName()) && (this.gamemmode != Player.CREATIVE)) {
            target.getPlayer().setAllowFlight(true);
            p.sendMessage(Translate.chat("&6Set fly mode &cenabled&6 for " + target.getPlayer().getDisplayName()));
            Fly.add(target.getPlayer().getDisplayName());
          } else if (Fly.contains(target.getPlayer().getDisplayName())) {
            target.getPlayer().setAllowFlight(false);
            p.sendMessage(Translate.chat("&6Set fly mode &cdisabled&6 for " + target.getPlayer().getDisplayName()));
            Fly.remove(target.getPlayer().getDisplayName());
        }else {
          p.sendMessage(Translate.chat("&cUsage: /fly OR /fly <Player>"));
        }
        }
      }
    }
    return true;
  }
}