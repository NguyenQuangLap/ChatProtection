package net.thelightmc.chatprotection.commands.sub;

import net.thelightmc.chatprotection.commands.CCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CmdClear implements CCommand {
    @Override
    public String getPermission() {
        return "chatProtection.clear";
    }

    @Override
    public String getCommand() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "Clears chat";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        for (int i = 0; i < 100; i++) {
            Bukkit.broadcastMessage(" ");
        }
        Bukkit.broadcastMessage(ChatColor.GRAY + sender.getName() + " has cleared the chat.");
    }
}
