package net.thelightmc.chatprotection.checks;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author TheLightMC
 */
public class SpeedCheck implements Check {
    private static final long MINIMUM_TIME = 1500L;
    private final Map<UUID,Long> chatTimes;

    public SpeedCheck() {
        chatTimes = new HashMap<>();
    }

    public boolean checkMessage(Player player, String message) {
        long time = System.currentTimeMillis();
        return chatTimes.getOrDefault(player.getUniqueId(), 0L)+MINIMUM_TIME < time;
    }

    @Override
    public String getErrorMessage() {
        return ChatColor.RED + "Slow down your messages.";
    }

    @Override
    public int getViolationLevel() {
        return 1;
    }
}
