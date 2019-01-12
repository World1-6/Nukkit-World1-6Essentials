package World16.Events;

import World16.Main.Main;
import World16.Utils.Translate;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;

public class OnJoinTittleEvent implements Listener {

    private Main plugin;

    public OnJoinTittleEvent(Main getPlugin) {
        this.plugin = getPlugin;

        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler
    public void onJOINTitle(PlayerJoinEvent event) {
        Player p = event.getPlayer();

        p.sendTitle(Translate.chat(this.plugin.getConfig().getString("TittleTOP")
        ), Translate.chat(this.plugin.getConfig().getString("TittleBOTTOM")), 10, 5 * 20, 10);
    }
}