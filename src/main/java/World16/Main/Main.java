package World16.Main;

import World16.Commands.afk;
import World16.Commands.back;
import World16.Commands.bed;
import World16.Commands.clear;
import World16.Commands.colors;
import World16.Commands.day;
import World16.Commands.echest;
import World16.Commands.feed;
import World16.Commands.fly;
import World16.Commands.gmc;
import World16.Commands.gms;
import World16.Commands.gmsp;
import World16.Commands.heal;
import World16.Commands.night;
import World16.Commands.setspawn;
import World16.Commands.sign;
import World16.Commands.spawn;
import World16.Events.OnDeathEvent;
import World16.Events.OnJoinEvent;
import World16.Events.OnLeaveEvent;
import World16.Utils.API;
import World16.Utils.CustomYmlManger;
import World16.Utils.Translate;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase {

  private static Main plugin;
  private CustomYmlManger customyml;
  private API api;
//  HashMap<String, String> keyDataM = OnJoinEvent.keydatam;

  public static Main getInstance() {
    return plugin;
  }

  public void onLoad() {
    plugin = this;
  }

  @Override
  public void onEnable() {
    plugin = this;
    CustomYmlConfigGEN();
    FileConfigGen();
    regEvents();
    regCommands();
    getLogger().info("[World1-6Essentials] is now loaded!");
  }

  public void onDisable() {
    //JUST IN CASE
//    keyDataM.clear();
    getLogger().info("[World1-6Essentials] is now disabled.");
  }

  public void regCommands() {
    new afk("afk");
    new bed("bed");
    new clear("clear");
    new colors("colors");
    new day("day");
    new echest("echest");
    new feed("feed");
    new fly("fly");
    //
    new gmc("gmc");
    new gms("gms");
    new gmsp("gmsp");
    //
    new heal("heal");
    new night("night");
    new sign("sign");
//    new debug("debug1-6");
    new setspawn("setspawn", customyml);
    new spawn("spawn", customyml);
    new back("back", this);
  }

  public void regEvents() {
    new OnJoinEvent(this);
//    new OnJoinTittleEvent(this); -> TODO TO FIX
    new OnLeaveEvent(this);
    new OnDeathEvent(this);
  }

  public void FileConfigGen() {
    this.saveDefaultConfig();
    this.saveConfig();
  }

  public void CustomYmlConfigGEN() {
    customyml = new CustomYmlManger();
    // Shit.yml
    customyml.setupshit();
    customyml.saveshit();
    customyml.reloadshit();
    // END OF Shit.yml
  }

  public void regAPIS() {
    api = new API(this.customyml);
  }

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    {
      Player p = (Player) sender;

      if (cmd.getName().equalsIgnoreCase("World1-6Ess")) {
        if (args.length == 0) {
          p.sendMessage(Translate.chat("&6Made By Andrew121410 My -> Discord: Andrew121410#2035"));
          return true;
        }
      }
    }
    return true;
  }
}
