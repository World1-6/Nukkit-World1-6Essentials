package World16.Commands;

import World16.Main.Main;
import World16.Utils.API;
import World16.Utils.Translate;
import cn.nukkit.IPlayer;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class heal extends Command {

  private static Main plugin = Main.getInstance();
  API api = new API();
  
  public heal(String name) {
    super(name);
    this.setPermission("world16." + name + "." + "permission");
    this.plugin.getServer().getCommandMap().register("heal", this);
  }

  @Override
  public boolean execute(CommandSender sender, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("Only Players Can Use This Command.");
      return true;
    }

    Player p = (Player) sender;

    if (!p.hasPermission("world16.heal.permission")) {
      p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
      return true;
    }
    if (args.length == 0) {
    // p.setMaxHealth(/*20.0D*/20);
    p.setHealth((float) 20.0D);
    p.getFoodData().setLevel(20);
    // p.isOnFire();
    // for (Potion effect : p.getpot())
    // p.removePotionEffect(effect.());
    p.sendMessage(Translate.chat("&6You have been healed."));
    return true;
  }else {
    IPlayer target = plugin.getServer().getPlayerExact(args[0]);
    if (args.length >= 1 && target != null && target.isOnline()) {
      if (!p.hasPermission("world16.heal.others.permission")) {
        p.sendMessage(api.PERMISSION_ERROR_MESSAGE);
        return true;
      }
      target.getPlayer().setHealth((float) 20.0D);
      target.getPlayer().getFoodData().setLevel(20);
      // p.isOnFire();
      // for (Potion effect : p.getpot())
      // p.removePotionEffect(effect.());
      p.sendMessage(Translate.chat("&6You healed &c" + target.getPlayer().getDisplayName()));
  }else {
    p.sendMessage(Translate.chat("&cUsage: /heal OR /heal <Player>"));
  }
  }
    return true;
  }
}