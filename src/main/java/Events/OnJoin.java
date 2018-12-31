package Events;

import Utils.API;
import Utils.Translate;
import World16.World16.World16.Main;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import java.util.HashMap;

public class OnJoin implements Listener {

    public static HashMap<String, String> keydatam = new HashMap<String, String>();
    private Main plugin;

    API api = new API();

    public OnJoin(World16.World16.World16.Main getPlugin) {
        this.plugin = getPlugin;

        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJOIN(PlayerJoinEvent event) {

        Player p = event.getPlayer();

        //REMOVES THE SET JOIN MESSAGE
        event.setJoinMessage("");

        this.plugin.getServer().broadcastMessage(
            Utils.Translate.chat("[&9World1-6&r] &6Welcome Back! " + p.getDisplayName()));
        this.version(p);
    }

    public void version(Player p) {
        p.sendMessage(Translate.chat("&4World1-6Ess Last Time Updated Was " + api.DATE_OF_VERSION));
    }
}