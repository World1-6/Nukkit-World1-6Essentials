package World16.Commands;

import World16.Main.Main;
import World16.Utils.API;
import World16.Utils.CustomYmlManger;
import World16.Utils.Translate;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class setspawn extends Command {

  private static Main plugin = Main.getInstance();
  API api;
  private CustomYmlManger yml = null;

  public setspawn(String name, CustomYmlManger yml) {
    super(name);
    this.setPermission("world16." + name + "." + "permission");
    this.yml = yml;
    this.api = new API(this.yml);
    this.setDescription("Set's the spawn for the world.");
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

    this.api.SetSpawn(p, x, y, z, yaw, pitch, worldName, "Default");
//    p.sendMessage("X->: " + x + " Y->: " + y + " Z->: " + z + " YAW->: " + yaw + " PITCH->: " + pitch); <-- DEBUG
    p.sendMessage(Translate.chat("&6Spawn location set for group default."));
    return true;
  }
}