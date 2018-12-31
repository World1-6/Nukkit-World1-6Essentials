package Commands;

import Utils.API;
import Utils.CustomYmlManger;
import Utils.Translate;
import World16.World16.World16.Main;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;

public class spawn extends Command {

  private static Main plugin = Main.getInstance();
  API api = new API();
  private CustomYmlManger yml = null;

  public spawn(String name, CustomYmlManger yml) {
    super(name);
    this.setPermission("world16." + name + "." + "permission");
    this.yml = yml;
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

    double x = Double.parseDouble(yml.getshit().getString("Spawn.Data.X"));
    double y = Double.parseDouble(yml.getshit().getString("Spawn.Data.Y"));
    double z = Double.parseDouble(yml.getshit().getString("Spawn.Data.Z"));
    double yaw = Double.parseDouble(yml.getshit().getString("Spawn.Data.Yaw"));
    double pitch = Double.parseDouble(yml.getshit().getString("Spawn.Data.Pitch"));
    Level world = this.plugin.getServer().getLevelByName(yml.getshit().getString("Spawn.Data.World"));

    Location spawn = new Location(x, y, z, yaw, pitch, world);
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