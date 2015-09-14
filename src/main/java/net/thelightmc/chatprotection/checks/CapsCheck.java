package net.thelightmc.chatprotection.checks;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * @author TheLightMC
 */
public class CapsCheck implements Check {
    private static final double ALLOWED_CAPITALS = .3D;

    @Override
    public boolean checkMessage(Player player, String message) {
        double i = 0;
        for (char c : message.toCharArray()) {
            if (Character.isUpperCase(c)) {
                i++;
            }
        }
        return i/message.length() >= ALLOWED_CAPITALS;
    }

    @Override
    public String getErrorMessage() {
        return ChatColor.RED + "Please don't use so many capitals.";
    }

    @Override
    public int getViolationLevel() {
        return 1;
    }
}
