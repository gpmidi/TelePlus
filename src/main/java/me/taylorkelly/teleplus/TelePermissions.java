package me.taylorkelly.teleplus;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.nijikokun.bukkit.Permissions.Permissions;

public class TelePermissions {
    private static Permissions permissionsPlugin;
    private static boolean permissionsEnabled = false;

    public static void initialize(Server server) {
        Plugin test = server.getPluginManager().getPlugin("Permissions");
        if (test != null) {
            Logger log = Logger.getLogger("Minecraft");
            permissionsPlugin = ((Permissions) test);
            permissionsEnabled = true;
            log.log(Level.INFO, "[TELEPLUS] Permissions enabled.");
        } else {
            Logger log = Logger.getLogger("Minecraft");
            log.log(Level.SEVERE, "[TELEPLUS] Permissions isn't loaded, there are no restrictions.");
        }
    }

    public static boolean isAdmin(Player player) {
        if (permissionsEnabled) {
            return permission(player, "tplus.admin");
        } else {
            return player.isOp();
        }
    }

    private static boolean permission(Player player, String string) {
        return permissionsPlugin.Security.permission(player, string);
    }

    public static boolean jump(Player player) {
        if (permissionsEnabled) {
            return permission(player, "tplus.jump.jump");
        } else {
            return true;
        }
    }

    public static boolean qjump(Player player) {
        if (permissionsEnabled) {
            return permission(player, "tplus.jump.qjump");
        } else {
            return true;
        }
    }

    public static boolean coords(Player player) {
        if (permissionsEnabled) {
            return permission(player, "tplus.tp.coords");
        } else {
            return true;
        }
    }

    public static boolean up(Player player) {
        if (permissionsEnabled) {
            return permission(player, "tplus.jump.up");
        } else {
            return true;
        }
    }

    public static boolean toPlayer(Player player) {
        if (permissionsEnabled) {
            return permission(player, "tplus.tp.to");
        } else {
            return true;
        }
    }

    public static boolean here(Player player) {
        if (permissionsEnabled) {
            return permission(player, "tplus.tp.here");
        } else {
            return true;
        }
    }

    public static boolean toOthers(Player player) {
        if (permissionsEnabled) {
            return permission(player, "tplus.tp.others");
        } else {
            return true;
        }
    }
    
    public static boolean history(Player player) {
        if (permissionsEnabled) {
            return permission(player, "tplus.history");
        } else {
            return true;
        }
    }
}
