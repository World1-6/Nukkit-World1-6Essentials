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
  CustomYmlManger yml = new CustomYmlManger();

  public spawn(String name) {
    super(name);
    this.setPermission("world16." + name + "." + "permission");
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

    double x = yml.getshit().getInt("Spawn.Data.X");
    double y = yml.getshit().getInt("Spawn.Data.Y");
    double z = yml.getshit().getInt("Spawn.Data.Z");
    float yaw = (float) yml.getshit().getInt("Spawn.Data.Yaw");
    float pitch = (float) yml.getshit().getInt("Spawn.Data.Pitch");
    Level world = this.plugin.getServer()
        .getLevelByName(yml.getshit().getString("Spawn.Data.World"));

    Location spawn = new Location(x, y, z, yaw, pitch, world);
    //
    if (args.length == 0) {
      p.teleport(spawn);
      p.sendMessage(Translate.chat("&6Teleporting..."));
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