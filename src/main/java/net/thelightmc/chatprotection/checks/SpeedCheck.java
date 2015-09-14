package net.thelightmc.chatprotection.checks;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SpeedCheck implements Check {
    private static final long MINIMUM_TIME = 1500;
    private final Map<UUID,Long> chatTimes;

    public SpeedCheck() {
        chatTimes = new HashMap<>();
    }

    public boolean checkMessage(Player player, String message) {
        return chatTimes.getOrDefault(player.getUniqueId(),0l).equals(null);
    }
}
