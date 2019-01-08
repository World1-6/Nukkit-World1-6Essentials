package Utils;

import Commands.afk;
import Commands.fly;
import World16.World16.World16.Main;
import cn.nukkit.Player;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class API {

    //    HashMap<String, String> keyDataM = OnJoin.keyDataM;
    ArrayList<String> Afk1 = afk.Afk;
    ArrayList<String> Fly1 = fly.Fly;

    private static Main plugin = Main.getInstance();

    //finals
    public static final Integer VERSION = 1;
    public static final String DATE_OF_VERSION = "1/7/2019";
    public static final String PREFIX = "[&9World1-6Ess&r]";
    public static final String USELESS = "" + PREFIX + "->[&bUSELESS&r]";
    public static final String TOO_DAMN_OLD = "Your mc version is too damn old 1.11 up too 1.13.2 please.";
    public static final String SOMETHING_WENT_WRONG = "Something went wrong.";
    public static final String PERMISSION_ERROR_MESSAGE = Translate.chat(PREFIX + " &cYou Do Not Have Permission To Use This Command.");

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
        if (this.HOST != null) {
            return this.HOST;
        } else {
            return null;
        }
    }

    public String getDATABASE() {
        if (this.DATABASE != null) {
            return this.DATABASE;
        } else {
            return null;
        }
    }

    public String getUSER() {
        if (this.USER != null) {
            return this.USER;
        } else {
            return null;
        }
    }

    public String getPASSWORD() {
        if (this.PASSWORD != null) {
            return this.PASSWORD;
        } else {
            return null;
        }
    }

    public String getPORT() {
        if (this.PORT != null) {
            return this.PORT;
        } else {
            return null;
        }
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
        if (Fly1.contains(p.getDisplayName()) /**|| p.isFlying()**/) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> getAfkArrayList() {
        return Afk1;
    }

    public void clearArrayListandHashMapsWithName(Player p) {
//        keyDataM.remove(p.getDisplayName());
//        this.plugin.getServer().getConsoleSender().sendMessage(Translate.chat(this.USELESS
//            + " Class: Utils.API has cleared the HashMap of Events.OnJoin.keyDataM For Player: " + p
//            .getDisplayName()));
        Afk1.remove(p.getDisplayName());
        this.plugin.getServer().getConsoleSender().sendMessage(Translate.chat(this.USELESS
            + " Class: Utils.API has cleared the ArrayList of Commands.afk.Afk For Player: " + p
            .getDisplayName()));
        Fly1.remove(p.getDisplayName());
        this.plugin.getServer().getConsoleSender().sendMessage(Translate.chat(this.USELESS
            + " Class: Utils.API has cleared the ArrayList of Commands.fly.Fly For Player: " + p
            .getDisplayName()));
    }

    public void clearArrayListandHashMaps() {
//        keyDataM.clear();
//        this.plugin.getServer().getConsoleSender().sendMessage(Translate.chat(this.USELESS
//            + " Class: Utils.API has cleared the HashMap of Events.OnJoin.keyDataM For EVERY PLAYER"));
        Afk1.clear();
        this.plugin.getServer().getConsoleSender().sendMessage(Translate.chat(this.USELESS
            + " Class: Utils.API has cleared the ArrayList of Commands.afk.Afk For EVERY PLAYER"));
        Fly1.clear();
        this.plugin.getServer().getConsoleSender().sendMessage(Translate.chat(this.USELESS
            + " Class: Utils.API has cleared the ArrayList of Commands.fly.Fly For EVERY PLAYER"));
    }

    public void clearAllHahsMapsWithName(Player p) {
//        keyDataM.remove(p.getDisplayName());
//        this.plugin.getServer().getConsoleSender().sendMessage(Translate.chat(this.USELESS
//            + " Class: Utils.API has cleared the HashMap of Events.OnJoin.keyDataM For Player: " + p
//            .getDisplayName()));
    }

    public void clearAllArrayLists() {
        Afk1.clear();
        this.plugin.getServer().getConsoleSender().sendMessage(Translate.chat(this.USELESS
            + " Class: Utils.API has cleared the ArrayList of Commands.afk.Afk For EVERY PLAYER"));
        Fly1.clear();
        this.plugin.getServer().getConsoleSender().sendMessage(Translate.chat(this.USELESS
            + " Class: Utils.API has cleared the ArrayList of Commands.fly.Fly For EVERY PLAYER"));
    }

    public void clearAllHashMaps() {
//        keyDataM.clear();
//        this.plugin.getServer().getConsoleSender().sendMessage(Translate.chat(this.USELESS
//            + " Class: Utils.API has cleared the HashMap of Events.OnJoin.keyDataM For EVERY PLAYER"));
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