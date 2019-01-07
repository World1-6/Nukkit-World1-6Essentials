package Utils;

import World16.World16.World16.Main;
import cc.summermc.bukkitYaml.file.FileConfiguration;
import cc.summermc.bukkitYaml.file.YamlConfiguration;
import cn.nukkit.Player;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import java.io.File;
import java.io.IOException;

public class CustomYmlManger {

  private Main plugin = Main.getInstance();
  private Main Bukkit = this.plugin; //<-- LAZY lol
  private API api = new API();

  // Files & File Configs Here.
  public FileConfiguration shitcfg;
  public File shitfile;

  // --------------------------------------------------------------------------------------------------------
  public void setupshit() {
    if (!plugin.getDataFolder().exists()) {
      plugin.getDataFolder().mkdir();
    }
    shitfile = new File(plugin.getDataFolder(), "shit.yml");

    if (!shitfile.exists()) {
      try {
        shitfile.createNewFile();
        Bukkit.getServer().getConsoleSender()
            .sendMessage(Translate.chat(api.USELESS + " The shit.yml has been created."));
      } catch (IOException e) {
        Bukkit.getServer().getConsoleSender()
            .sendMessage(Translate
                .chat(api.USELESS + " The shit.yml could not make for some reason."));
      }
    }

    shitcfg = YamlConfiguration.loadConfiguration(shitfile);
  }

  public FileConfiguration getshit() {
    return shitcfg;
  }

  public void saveshit() {
    try {
      shitcfg.save(shitfile);
      Bukkit.getServer().getConsoleSender()
          .sendMessage(Translate.chat(api.USELESS + " &aThe shit.yml has been saved."));
    } catch (IOException e) {
      Bukkit.getServer().getConsoleSender()
          .sendMessage(Translate.chat(api.USELESS + " &cThe shit.yml has been NOT SAVED.."));
    }
  }

  public void reloadshit() {
    shitcfg = YamlConfiguration.loadConfiguration(shitfile);
    Bukkit.getServer().getConsoleSender()
        .sendMessage(Translate.chat(api.USELESS + " &6The shit.yml has been reloaded."));
//        // END OF SHIT YML
//        // ****************************************************************************************************
  }

  //API FOR SPAWN
  public Location apiGetSpawn(String spawnname) {
    double x = this.getshit().getInt("Spawn." + spawnname + ".Data.X");
    double y = this.getshit().getInt("Spawn." + spawnname + ".Data.Y");
    double z = this.getshit().getInt("Spawn." + spawnname + ".Data.Z");
    float yaw = (float) this.getshit().getInt("Spawn." + spawnname + ".Data.Yaw");
    float pitch = (float) this.getshit().getInt("Spawn." + spawnname + ".Data.Pitch");
    Level world = Bukkit.getServer()
        .getLevelByName(this.getshit().getString("Spawn." + spawnname + ".Data.World"));

    Location spawn = new Location(x, y, z, yaw, pitch, world);
    return spawn;
  }

  public void apiSetSpawn(Player p, double x, double y, double z, double yaw, double pitch,
      String worldname, String spawnname) {
    this.getshit().set("Spawn." + spawnname + ".Data.X", x);
    this.getshit().set("Spawn." + spawnname + ".Data.Y", y);
    this.getshit().set("Spawn." + spawnname + ".Data.Z", z);
    this.getshit().set("Spawn." + spawnname + ".Data.Yaw", yaw);
    this.getshit().set("Spawn." + spawnname + ".Data.Pitch", pitch);
    this.getshit().set("Spawn." + spawnname + ".Data.World", worldname);
    this.getshit().set("Spawn." + spawnname + ".Player.Data.NAME", p.getDisplayName());
    this.getshit().set("Spawn." + spawnname + ".Player.Data.UUID", p.getUniqueId().toString());
    this.saveshit();
  }
}