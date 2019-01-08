package Utils;

import World16.World16.World16.Main;
import cn.nukkit.Player;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import cn.nukkit.utils.Config;
import java.io.File;
import java.io.IOException;

public class CustomYmlManger {

  private Main plugin = Main.getInstance();
  private Main Bukkit = this.plugin; //<-- LAZY lol
  private API api = new API();

  // Files & File Configs Here.
  public Config shitcfg;
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

    shitcfg = new Config(shitfile);
  }

  public Config getshit() {
    return shitcfg;
  }

  public void saveshit() {
    shitcfg.save(shitfile);
    Bukkit.getServer().getConsoleSender()
        .sendMessage(Translate.chat(api.USELESS + " &aThe shit.yml has been saved."));
  }

  public void reloadshit() {
    shitcfg.reload();
    Bukkit.getServer().getConsoleSender()
        .sendMessage(Translate.chat(api.USELESS + " &6The shit.yml has been reloaded."));
//        // END OF SHIT YML
//        // ****************************************************************************************************
  }

  private String spawnname;
  private String spawnname1;
  //API FOR SPAWN
  public Location apiGetSpawn(String spawnname) {
    this.spawnname = spawnname.toLowerCase();
    double x = this.getshit().getInt("Spawn." + this.spawnname + ".Data.X");
    double y = this.getshit().getInt("Spawn." + this.spawnname + ".Data.Y");
    double z = this.getshit().getInt("Spawn." + this.spawnname + ".Data.Z");
    float yaw = (float) this.getshit().getInt("Spawn." + this.spawnname + ".Data.Yaw");
    float pitch = (float) this.getshit().getInt("Spawn." + this.spawnname + ".Data.Pitch");
    Level world = Bukkit.getServer()
        .getLevelByName(this.getshit().getString("Spawn." + this.spawnname + ".Data.World"));

    Location spawn = new Location(x, y, z, yaw, pitch, world);
    return spawn;
  }

  public void apiSetSpawn(Player p, double x, double y, double z, double yaw, double pitch,
      String worldname, String spawnname) {
    this.spawnname1 = spawnname.toLowerCase();
    this.getshit().set("Spawn." + this.spawnname1 + ".Data.X", x);
    this.getshit().set("Spawn." + this.spawnname1 + ".Data.Y", y);
    this.getshit().set("Spawn." + this.spawnname1 + ".Data.Z", z);
    this.getshit().set("Spawn." + this.spawnname1 + ".Data.Yaw", yaw);
    this.getshit().set("Spawn." + this.spawnname1 + ".Data.Pitch", pitch);
    this.getshit().set("Spawn." + this.spawnname1 + ".Data.World", worldname);
    this.getshit().set("Spawn." + this.spawnname1 + ".Player.Data.NAME", p.getDisplayName());
    this.getshit()
        .set("Spawn." + this.spawnname1 + ".Player.Data.UUID", p.getUniqueId().toString());
    this.saveshit();
  }
}