package net.thelightmc.chatprotection.listeners;

import com.google.common.collect.ImmutableList;
import net.thelightmc.chatprotection.checks.Check;
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

    public ChatListener(Check... checks) {
        this.checks = ImmutableList.copyOf(Arrays.asList(checks));
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        Optional<Check> any = checks.stream().filter(c -> !c.checkMessage(player, event.getMessage())).findAny();
        if (any.isPresent()) {
            player.sendMessage(any.get().getErrorMessage());
            event.setCancelled(true);
        }
    }
}
