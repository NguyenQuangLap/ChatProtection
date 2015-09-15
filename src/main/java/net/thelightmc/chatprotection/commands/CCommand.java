package net.thelightmc.chatprotection.commands;

import org.bukkit.command.CommandSender;

public interface CCommand {
    String getPermission();
    String getCommand();
    String getDescription();
    void execute(CommandSender sender,String[] args);
}
