package Commands;

import Events.OnJoin;
import Utils.API;
import Utils.Translate;
import World16.World16.World16.Main;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.ConsoleCommandSender;

import java.util.HashMap;

public class debug extends Command {

    private static Main plugin = Main.getInstance();
    API api = new API();
    HashMap<String, String> keydataM = OnJoin.keydatam;

    public debug(String name) {
        super(name);
        this.setPermission("world16." + name + "." + "permission");
        this.plugin.getServer().getCommandMap().register("debug1-6", this);
    }

    public boolean execute(CommandSender commandSender, String s, String[] args) {
        Player p = (Player) commandSender;

        // IF THE PLAYER IS THE CONSOLE OR COMMAND BLOCk
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Only Players Can Use This Command.");
            return true;
        }
        if (args.length == 0) {
            if (!p.hasPermission("command.debug.permission")) { // Permission
                api.PermissionErrorMessage(p);
                return true;
            }
            p.sendMessage(Translate.chat("&aHow to use /debug1-6"));
            p.sendMessage(Translate.chat("&aFor Oping Staff Use /debug1-6 op"));
            p.sendMessage(Translate.chat("&aFor The Default Tab And Title Use /debug1-6 defaultstuff"));
            p.sendMessage(Translate.chat("&aToo see what's stored in the hashmaps of you do /debug1-6 checkhashmaps"));
            p.sendMessage(
                    Translate.chat("&aFor Using Mysql/sql commands do /debug1-6 sql <CommandGoesHere>"));
            return true;
        } else if (args.length >= 1) {

            //OP
            if (args[0].equalsIgnoreCase("op")) {
                if (!p.hasPermission("command.debugop.permission")) { // Permission
                    api.PermissionErrorMessage(p);
                    return true;
                }
                p.sendMessage(Translate.chat("&4Debug working oping andrew and tyler and richard"));
                // Ops Andrew
                ConsoleCommandSender console = this.plugin.getServer().getConsoleSender();
                String command = "op andrew121410";
                this.plugin.getServer().dispatchCommand(console, command);
                String command1 = "op AlphaGibbon43";
                this.plugin.getServer().dispatchCommand(console, command1);
                String command3 = "op Robobros3";
                this.plugin.getServer().dispatchCommand(console, command3);
                p.sendMessage(Translate.chat("&4There."));
                return true;

                //DEFAULT STUFF
            } else if (args.length == 1 && (args[0].equalsIgnoreCase("defaultstuff"))) {
                if (!p.hasPermission("command.debugdefaultstuff.permission")) { // Permission
                    api.PermissionErrorMessage(p);
                    return true;
                }
                this.plugin.getConfig().set("TittleTOP", "&f&l[&4World 1-6&f&l]");
                this.plugin.getConfig().set("TittleBOTTOM", "&9&oHome Of Minecraft Fire Alarms.");
                this.plugin.getConfig().set("TablistTOP", "&f&l[&4World 1-6&f&l]");
                this.plugin.getConfig().set("TablistBOTTOM", "&9&oHome Of Minecraft Fire Alarms.");
                this.plugin.saveConfig();
                this.plugin.reloadConfig();
                p.sendMessage(Translate.chat("&bOK..."));
                return true;

                //CHECK HASHMAPS
            } else if (args.length >= 1 && (args[0].equalsIgnoreCase("checkhashmaps"))) {
                if (args.length == 1) {
                    p.sendMessage(Translate.chat("[&3/debug1-6 checkhashmaps &5checkmine&r] &9<-- show's what is stored in the HashMap of you."));
                    p.sendMessage(Translate.chat("[&3/debug1-6 checkhashmaps &c@all&r] &9<-- Show's everything in the HashMap"));
                    return true;
                } else {
                    if (args.length >= 1) {
                        if (args[1].equalsIgnoreCase("@all")) {
                            for (String t2 : keydataM.keySet()) {
                                p.sendMessage(Translate.chat("Key: " + t2 + " Values: " + keydataM.get(t2)));
                                return true;
                            }
                        } else if (args[1].equalsIgnoreCase("checkmine")) {
                            p.sendMessage(Translate.chat("Here's the HashMap for Events.OnJoin.keyDatam: " + keydataM.get(p.getDisplayName())));

                        }
                    }
                }

                //CLEAR ALL ARRAYLIST
            } else if (args.length == 1 && (args[0].equalsIgnoreCase("clearallarraylists"))) {
                if (!p.hasPermission("command.debugcheckhashmaps.permission")) { // Permission
                    api.PermissionErrorMessage(p);
                    return true;
                }
                api.clearAllArrayLists();
                p.sendMessage(Translate.chat("&bOK..."));
                return true;

                //CLEAR ALL HASHMAPS
            } else if (args.length == 1 && (args[0].equalsIgnoreCase("clearallhashmaps"))) {
                if (!p.hasPermission("command.debugclearallhashmaps.permission")) { // Permission
                    api.PermissionErrorMessage(p);
                    return true;
                }
                api.clearAllHashMaps();
                p.sendMessage(Translate.chat("&bOK..."));
                return true;

                //CLEAR ALL HASHMAPS WITH THE NAME.
            } else if (args.length == 1 && (args[0].equalsIgnoreCase("clearallhashmapswithname"))) {
                if (!p.hasPermission("command.debugclearallhashmapswithname.permission")) { // Permission
                    api.PermissionErrorMessage(p);
                    return true;
                }
                api.clearAllHahsMapsWithName(p);
                return true;
            }
        }
        return true;
    }
}