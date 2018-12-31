package Utils;

import Commands.afk;
import Commands.fly;
import World16.World16.World16.Main;
import cn.nukkit.Player;
import cn.nukkit.plugin.Plugin;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class API {

    ArrayList<String> Afk1 = afk.Afk;
    ArrayList<String> Fly1 = fly.Fly;

    private static Plugin plugin = Main.plugin;

    //finals
    public static final Integer VERSION = 1;
    public static final String DATE_OF_VERSION = "12/29/2018";
    public static final String PREFIX = "[&9World1-6Ess&r]";
    public static final String USELESS = "" + PREFIX + "->[&bUSELESS&r]";

    // FOR MYSQL
    private String HOST = plugin.getConfig().getString("MysqlHOST");
    private String DATABASE = plugin.getConfig().getString("MysqlDATABASE");
    private String USER = plugin.getConfig().getString("MysqlUSER");
    private String PASSWORD = plugin.getConfig().getString("MysqlPASSWORD");
    private String PORT = plugin.getConfig().getString("MysqlPORT");
    // END MYSQL

    // MAIN
    public API() {

    }

    // END MAIN
    // START OF MYSQL

    public String getHOST() {
        return this.HOST;
    }

    public String getDATABASE() {
        return this.DATABASE;
    }

    public String getUSER() {
        return this.USER;
    }

    public String getPASSWORD() {
        return this.PASSWORD;
    }

    public String getPORT() {
        return this.PORT;
    }
    // END OF MYSQL

    public boolean isAfk(Player p) {
        if (Afk1.contains(p.getDisplayName())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFlying(Player p) {
        if (Fly1.contains(p.getDisplayName())) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> getAfkArrayList() {
        return Afk1;
    }

    public String FormatTime(LocalDateTime time) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String formattedDate = time.format(myFormatObj);

        return formattedDate;
    }

    public String Time() {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        String formattedDate = time.format(myFormatObj);

        return formattedDate;
    }

    public void PermissionErrorMessage(Player p) {
        p.sendMessage(
            Translate.chat(this.PREFIX + " &cYou Do Not Have Permission To Use This Command."));
    }
}