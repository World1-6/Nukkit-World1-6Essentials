package World16.Events;

import World16.Main.Main;
import World16.Utils.API;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerQuitEvent;

public class OnLeaveEvent implements Listener {

    private Main plugin;
    API api = new API();

    public OnLeaveEvent(Main getPlugin) {
        this.plugin = getPlugin;

        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler
    public void OnLEAVE(PlayerQuitEvent event) {

        Player p = event.getPlayer();

        //SET THE DEFAULT QUIT MESSAGE TO NOTHING.
        event.setQuitMessage("");

        this.plugin.getServer().broadcastMessage(
            World16.Utils.Translate.chat("[&cWorld1-6&r] &5Bye Bye, " + p.getDisplayName()));
    }
}
