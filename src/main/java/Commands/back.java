package Commands;

import Events.OnDeathEvent;
import Utils.Translate;
import World16.World16.World16.Main;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Location;
import java.util.LinkedHashMap;

public class back extends Command {

  private static Main plugin;
  LinkedHashMap<String, Location> backmap = OnDeathEvent.backmap;

  public back(String name, Main getPlugin) {
    super(name);
    this.plugin = getPlugin;

    this.setDescription("When you die use this.");
    this.setPermission("world16." + name + "." + "permission");

    this.plugin.getServer().getCommandMap().register(name, this);
  }

  @Override
  public boolean execute(CommandSender sender, String s, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage("Only Players Can Do This Command.");
    }
    Player p = (Player) sender;

    if (args.length >= 0) {
      if (backmap.get(p.getDisplayName()) != null) {
        p.teleport(backmap.get(p.getDisplayName()));
      } else {
        p.sendMessage(Translate.chat("&4Looks like you didn't die yet."));
      }
      return true;
    }
    return true;
  }
}