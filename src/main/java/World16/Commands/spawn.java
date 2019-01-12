package World16.Commands;

import World16.Main.Main;
import World16.Utils.API;
import World16.Utils.CustomYmlManger;
import World16.Utils.Translate;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Location;

public class spawn extends Command {

  private static Main plugin = Main.getInstance();
  API api;
  private CustomYmlManger yml = null;

  public spawn(String name, CustomYmlManger yml) {
    super(name);
    this.setPermission("world16." + name + "." + "permission");
    this.yml = yml;
    this.api = new API(this.yml);
    this.setDescription("Goes too the spawn.");
    this.plugin.getServer().getCommandMap().register("spawn", this);
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("Only Players Can Use This Command.");
      return true;
    }
    Player p = (Player) sender;

    if (!p.hasPermission("world16.spawn.permission")) {
      p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
      return true;
    }
    Location spawn = this.api.GetSpawn("Default");
    //
    if (args.length == 0) {
      p.teleport(spawn);
      p.sendMessage(Translate.chat("&6Teleporting..."));
//      p.sendMessage("X->: " + x + " Y->: " + y + " Z->: " + z + " YAW->: " + yaw + " PITCH->: " + pitch); <-- DEBUG
      return true;
    } else {
      Player target = plugin.getServer().getPlayerExact(args[0]);
      if (args.length >= 1 && target != null && target.isOnline()) {
        if (!p.hasPermission("world16.spawn.other.permission")) {
          api.PermissionErrorMessage(p);
          return true;
        }
        target.teleport(spawn);
        target.sendMessage(Translate.chat("&6Teleporting..."));
      } else {
        p.sendMessage(Translate.chat("&cUsage: for yourself do /spawn OR /spawn <Player>"));
      }
    }
    return true;
  }
}