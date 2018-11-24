package World16.World16.World16;

import Commands.afk;
import Commands.bed;
import Commands.clear;
import Commands.colors;
import Commands.day;
import Commands.echest;
import Commands.feed;
import Commands.fly;
import Commands.gmc;
import Commands.gms;
import Commands.gmsp;
import Commands.heal;
import Commands.night;
import Commands.sign;
import Utils.Translate;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase {

  public static Main plugin;

  public static Main getInstance() {
    return plugin;
  }

  // MySQL mysql = new MySQL(Main.plugin.getConfig().getString("MysqlHOST"),
  // Main.plugin.getConfig().getString("MysqlDATABASE"),
  // Main.plugin.getConfig().getString("MysqlUSER"),
  // Main.plugin.getConfig().getString("MysqlPASSWORD"));
  // GOT THE MYSQL API AT https://www.spigotmc.org/resources/simple-easy-mysql-api.36447/
  // GOT THE TITLE API AT https://www.spigotmc.org/resources/titleapi-1-8-1-13.1325/
  public void onLoad() {
    plugin = this;
  }

  @Override
  public void onEnable() {
    plugin = this;
    YmlConfigGen();
    FileConfigGen();
    eventsEnable();
    commandsEnable();
    getLogger().info("[World1-6Essentials] is now loaded!");
    // START OF UPDATER
    // FROM https://www.spigotmc.org/resources/api-pluginupdater-with-website.5578/
    // FINISH OF UPDATER
  }

  public void onDisable() {
    getLogger().info("[World1-6Essentials] is now disabled.");
  }

  public void commandsEnable() {
    getServer().getCommandMap().register("afk", (Command) new afk("afk"));
    getServer().getCommandMap().register("bed", (Command) new bed("bed"));
    getServer().getCommandMap().register("colors", (Command) new colors("colors"));
    getServer().getCommandMap().register("day", (Command) new day("day"));
    getServer().getCommandMap().register("echest", (Command) new echest("echest"));
    getServer().getCommandMap().register("feed", (Command) new feed("feed"));
    getServer().getCommandMap().register("fly", (Command) new fly("fly"));
    getServer().getCommandMap().register("clear", (Command) new clear("clear"));
    //
    getServer().getCommandMap().register("gmc", (Command) new gmc("gmc"));
    getServer().getCommandMap().register("gms", (Command) new gms("gms"));
    getServer().getCommandMap().register("gmsp", (Command) new gmsp("gmsp"));
    //
    getServer().getCommandMap().register("heal", (Command) new heal("heal"));
    getServer().getCommandMap().register("night", (Command) new night("night"));
    getServer().getCommandMap().register("sign", (Command) new sign("sign"));
  }

  public void eventsEnable() {

  }

  public void FileConfigGen() {

  }

  public void YmlConfigGen() {

  }

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    {
      Player p = (Player) sender;

      if (cmd.getName().equalsIgnoreCase("World1-6Ess")) {
        if (args.length == 0) {
          p.sendMessage(Translate.chat("&6Made By Andrew121410#2035"));
          return true;
        }
      }
    }
    return false;
  }
}
