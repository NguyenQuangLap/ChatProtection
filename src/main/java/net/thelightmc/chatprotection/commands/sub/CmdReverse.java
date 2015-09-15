package net.thelightmc.chatprotection.commands.sub;

import net.thelightmc.chatprotection.commands.CCommand;
import net.thelightmc.chatprotection.listeners.ChatListener;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CmdReverse implements CCommand {
    private final ChatListener chatListener;

    public CmdReverse(ChatListener chatListener) {
        this.chatListener = chatListener;
    }

    @Override
    public String getPermission() {
        return "chatProtection.reverse";
    }

    @Override
    public String getCommand() {
        return "reverse";
    }

    @Override
    public String getDescription() {
        return "Reverse the chat.";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (chatListener.isReversed()) {
            sender.sendMessage(ChatColor.BLUE + "You have un-reversed the chat.");
            chatListener.setReversed(false);
        } else {
            sender.sendMessage(ChatColor.GREEN + "You have reversed the chat.");
            chatListener.setReversed(true);
        }
    }
}