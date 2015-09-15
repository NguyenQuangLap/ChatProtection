package net.thelightmc.chatprotection.commands.sub;

import net.thelightmc.chatprotection.commands.CCommand;
import net.thelightmc.chatprotection.listeners.ChatListener;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CmdMute implements CCommand {
    private final ChatListener chatListener;

    public CmdMute(ChatListener chatListener) {
        this.chatListener = chatListener;
    }

    @Override
    public String getPermission() {
        return "chatProtection.mute";
    }

    @Override
    public String getCommand() {
        return "mute";
    }

    @Override
    public String getDescription() {
        return "Mute the chat";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(ChatColor.GOLD + "You have muted the chat.");
        this.chatListener.setMuted(chatListener.isMuted());
    }
}
