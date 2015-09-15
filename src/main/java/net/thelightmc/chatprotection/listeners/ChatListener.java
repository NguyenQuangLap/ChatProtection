package net.thelightmc.chatprotection.listeners;

import com.google.common.collect.ImmutableList;
import net.thelightmc.chatprotection.checks.Check;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author TheLightMC
 */
public final class ChatListener implements Listener {
    private final List<Check> checks;
    private boolean muted;
    private boolean reversed;

    public ChatListener(Check... checks) {
        this.checks = ImmutableList.copyOf(Arrays.asList(checks));
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("chatProtection.bypass")) {
            return;
        }
        if (muted) {
            player.sendMessage(ChatColor.RED + "The chat is currently muted.");
            event.setCancelled(true);
            return;
        }

        Optional<Check> any = checks.stream().filter(c -> !c.checkMessage(player, event.getMessage())).findAny();
        if (any.isPresent()) {
            player.sendMessage(any.get().getErrorMessage());
            event.setCancelled(true);
        }

        if (reversed) {
            event.setMessage(new StringBuilder(event.getMessage()).reverse().toString());
        }
    }

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

    public void setReversed(boolean reversed) {
        this.reversed = reversed;
    }

    public boolean isReversed() {
        return reversed;
    }
}
