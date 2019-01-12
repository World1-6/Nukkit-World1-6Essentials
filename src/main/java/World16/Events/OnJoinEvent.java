package World16.Events;

import World16.Main.Main;
import World16.Utils.API;
import World16.Utils.Translate;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import java.util.HashMap;

public class OnJoinEvent implements Listener {

    public static HashMap<String, String> keydatam = new HashMap<String, String>();
    private Main plugin;

    API api = new API();

    public OnJoinEvent(Main getPlugin) {
        this.plugin = getPlugin;

        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJOIN(PlayerJoinEvent event) {

        Player p = event.getPlayer();

        //REMOVES THE SET JOIN MESSAGE
        event.setJoinMessage("");

        this.plugin.getServer().broadcastMessage(
            World16.Utils.Translate.chat("[&9World1-6&r] &6Welcome Back! " + p.getDisplayName()));
        this.version(p);
    }

    public void version(Player p) {
        p.sendMessage(Translate.chat("&4World1-6Ess Last Time Updated Was " + api.DATE_OF_VERSION));
    }
}