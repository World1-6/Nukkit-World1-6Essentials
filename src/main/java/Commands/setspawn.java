package Commands;

import Utils.API;
import Utils.CustomYmlManger;
import Utils.Translate;
import World16.World16.World16.Main;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class setspawn extends Command {

  private static Main plugin = Main.getInstance();
  API api = new API();
  private CustomYmlManger yml = null;

  public setspawn(String name, CustomYmlManger yml) {
    super(name);
    this.setPermission("world16." + name + "." + "permission");
    this.yml = yml;
    this.plugin.getServer().getCommandMap().register("setspawn", this);
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("Only Players Can Use This Command.");
      return true;
    }
    Player p = (Player) sender;

    if (!p.hasPermission("world16.setspawn.permission")) {
      p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
      return true;
    }
    double x = p.getLocation().getX();
    double y = p.getLocation().getY();
    double z = p.getLocation().getZ();
    double yaw = p.getLocation().getYaw();
    double pitch = p.getLocation().getPitch();
    String worldName = p.getLevel().getName();

    yml.getshit().set("Spawn.Data.X", String.valueOf(x));
    yml.getshit().set("Spawn.Data.Y", String.valueOf(y));
    yml.getshit().set("Spawn.Data.Z", String.valueOf(z));
    yml.getshit().set("Spawn.Data.Yaw", String.valueOf(yaw));
    yml.getshit().set("Spawn.Data.Pitch", String.valueOf(pitch));

    yml.getshit().set("Spawn.Data.World", worldName);
    yml.getshit().set("Spawn.Player.Data.NAME", p.getDisplayName());
    yml.getshit().set("Spawn.Player.Data.UUID", p.getUniqueId().toString());
    yml.saveshit();
//    p.sendMessage("X->: " + x + " Y->: " + y + " Z->: " + z + " YAW->: " + yaw + " PITCH->: " + pitch); <-- DEBUG
    p.sendMessage(Translate.chat("&6Spawn location set for group default."));
    return true;
  }
}