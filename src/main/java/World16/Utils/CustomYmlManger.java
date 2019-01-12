package World16.Utils;

import World16.Main.Main;
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
}