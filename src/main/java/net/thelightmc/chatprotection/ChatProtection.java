package net.thelightmc.chatprotection;

import net.thelightmc.chatprotection.checks.AdvertisingCheck;
import net.thelightmc.chatprotection.checks.CapsCheck;
import net.thelightmc.chatprotection.checks.SpeedCheck;
import net.thelightmc.chatprotection.listeners.ChatListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author TheLightMC
 */
public final class ChatProtection extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new ChatListener(new AdvertisingCheck(this)
                , new CapsCheck(), new SpeedCheck()),this);
    }
}
