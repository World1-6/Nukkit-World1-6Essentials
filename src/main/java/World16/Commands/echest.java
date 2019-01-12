package World16.Commands;

import World16.Main.Main;
import World16.Utils.API;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Sound;

public class echest extends Command {

  API api = new API();
  
  private static Main plugin = Main.getInstance();

  public echest(String name){
    super(name);
    this.setPermission("world16." + name + "." + "permission");
    this.plugin.getServer().getCommandMap().register("echest", this);
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("Only Players Can Use This Command.");
      return true;
    }

    Player p = (Player) sender;

    if (!p.hasPermission("world16.echest.permission")) {
      p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
      return true;
    }
    p.getEnderChestInventory().open(p);
    // p.playSound(p.getLocation(), Sound.RANDOM_CHESTOPEN, 10.0f, 1.0f);
    p.getLevel().addSound(p.getLocation(), Sound.RANDOM_CHESTOPEN);
    return true;
  }
}
