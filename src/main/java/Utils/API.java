package Utils;

import java.util.ArrayList;
import Commands.afk;
import Commands.fly;
import World16.World16.World16.Main;
import cn.nukkit.Player;

public class API {

  ArrayList<String> Afk1 = afk.Afk;
  ArrayList<String> Fly1 = fly.Fly;
  
  //VAR
  public static String PERMISSION_ERROR_MESSAGE = Translate.chat("[&9World1-6&r] &cYou Do Not Have Permission To Use This Command.");
  //END OF VAR

  private static Main plugin = World16.World16.World16.Main.getInstance();

  // FOR MYSQL
  public String HOST = plugin.getConfig().getString("MysqlHOST");
  public String DATABASE = plugin.getConfig().getString("MysqlDATABASE");
  public String USER = plugin.getConfig().getString("MysqlUSER");
  public String PASSWORD = plugin.getConfig().getString("MysqlPASSWORD");
  public String PORT = plugin.getConfig().getString("MysqlPORT");
  // END MYSQL

  // MAIN
  public API() {

  }

  // END MAIN
  // START OF MYSQL
  public String getHOST() {
    return HOST;
  }

  public void setHOST(String hOST) {
    HOST = hOST;
  }

  public String getDATABASE() {
    return DATABASE;
  }

  public void setDATABASE(String dATABASE) {
    DATABASE = dATABASE;
  }

  public String getUSER() {
    return USER;
  }

  public void setUSER(String uSER) {
    USER = uSER;
  }

  public String getPASSWORD() {
    return PASSWORD;
  }

  public void setPASSWORD(String pASSWORD) {
    PASSWORD = pASSWORD;
  }

  public String getPORT() {
    return PORT;
  }

  public void setPORT(String pORT) {
    PORT = pORT;
  }
  // END OF MYSQL

  public boolean isAfk(Player target) {
    if (Afk1.contains(target)) {
      return true;
    }
    // if (Afk1.contains(p.getDisplayName())) { return true; }
    return false;
  }

  public boolean isFlying(Player target) {
    if (Fly1.contains(target.getDisplayName())) {
      return true;
    }
    return false;
  }
  /*
   * public void PermissionErrorMessage(Player p) { p.sendMessage(
   * Translate.chat("[&9World1-6&r] &cYou Do Not Have Permission To Use This Command.")); }
   */
}
