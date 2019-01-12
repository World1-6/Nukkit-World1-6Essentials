package Events;

import World16.World16.World16.Main;
import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.level.Level;
import cn.nukkit.level.Location;
import java.util.LinkedHashMap;

public class OnDeathEvent implements Listener {

  private static Main plugin;
  public static LinkedHashMap<String, Location> backmap = new LinkedHashMap<>();

  public OnDeathEvent(Main getPlugin) {
    this.plugin = getPlugin;

    this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler
  public void OnDeath(PlayerDeathEvent event) {
    Player p = event.getEntity();

    backmap.remove(p.getDisplayName());

    double x = event.getEntity().x;
    double y = event.getEntity().y;
    double z = event.getEntity().z;
    double yaw = event.getEntity().yaw;
    double pitch = event.getEntity().pitch;
    Level world = event.getEntity().getLevel(); //<<-- this might be wrong?

    Location location = new Location(x, y, z, yaw, pitch, world);

    backmap.put(p.getDisplayName(), location);
  }
}
