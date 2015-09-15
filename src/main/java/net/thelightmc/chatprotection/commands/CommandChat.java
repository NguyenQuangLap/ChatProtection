package net.thelightmc.chatprotection.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandChat implements CommandExecutor {
    private final List<CCommand> commandList;

    public CommandChat(CCommand... commands) {
        this.commandList = new ArrayList<>(Arrays.asList(commands));
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length >= 0) {
            for (CCommand cCommand : commandList) {
                if (strings[0].equalsIgnoreCase(cCommand.getCommand())) {
                    if (!commandSender.hasPermission(cCommand.getPermission())) {
                        commandSender.sendMessage(ChatColor.RED + "No permission.");
                        return true;
                    }
                    cCommand.execute(commandSender, Arrays.copyOfRange(strings, 1, strings.length));
                    return true;
                }
            }
            commandSender.sendMessage(ChatColor.RED + "No sub-commands found.");
            return true;
        }
        for (CCommand cCommand : commandList) {
            commandSender.sendMessage(ChatColor.GREEN + "/" + cCommand.getCommand() + ChatColor
                    .DARK_GRAY + " - " + cCommand.getDescription());
        }
        return true;
    }
}
