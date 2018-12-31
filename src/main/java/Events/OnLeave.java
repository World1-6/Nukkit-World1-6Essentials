package Events;

import Utils.API;
import World16.World16.World16.Main;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerQuitEvent;

public class OnLeave implements Listener {

    private Main plugin;
    API api = new API();

    public OnLeave(World16.World16.World16.Main getPlugin) {
        this.plugin = getPlugin;

        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler
    public void OnLEAVE(PlayerQuitEvent event) {

        Player p = event.getPlayer();

        //Clear

        //SET THE DEFAULT QUIT MESSAGE TO NOTHING.
        event.setQuitMessage("");

        this.plugin.getServer().broadcastMessage(Utils.Translate.chat("[&cWorld1-6&r] &5Bye Bye, " + p.getDisplayName()));
    }
}
