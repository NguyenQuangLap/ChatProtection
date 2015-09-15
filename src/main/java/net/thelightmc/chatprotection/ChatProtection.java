package net.thelightmc.chatprotection;

import net.thelightmc.chatprotection.checks.AdvertisingCheck;
import net.thelightmc.chatprotection.checks.CapsCheck;
import net.thelightmc.chatprotection.checks.SpeedCheck;
import net.thelightmc.chatprotection.commands.CommandChat;
import net.thelightmc.chatprotection.commands.sub.CmdClear;
import net.thelightmc.chatprotection.commands.sub.CmdMute;
import net.thelightmc.chatprotection.commands.sub.CmdReverse;
import net.thelightmc.chatprotection.listeners.ChatListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author TheLightMC
 */
public final class ChatProtection extends JavaPlugin {
    @Override
    public void onEnable() {
        ChatListener chatListener = new ChatListener(new AdvertisingCheck(this), new CapsCheck(), new SpeedCheck());
        getServer().getPluginManager().registerEvents(chatListener,this);
        getCommand("chat").setExecutor(new CommandChat(
                new CmdClear(), new CmdMute(chatListener),new CmdReverse(chatListener)
        ));
    }
}
