package net.thelightmc.chatprotection.checks;

import com.google.common.io.Files;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author TheLightMC
 */
public class AdvertisingCheck implements Check {
    private static final Pattern HOST_PATTERN = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4]" +
            "[0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
    private final Set<String> tlds;

    public AdvertisingCheck(JavaPlugin plugin) {
        Set<String> temp;
        try {
            plugin.getLogger().info("Now loading TLD's from file.");
            temp = new HashSet<>(Files.readLines(new File("tlds.txt"), Charset.defaultCharset()));
            plugin.getLogger().info("Loaded " + temp.size() + " from the file.");
        } catch (java.io.IOException e) {
            e.printStackTrace();
            temp = new HashSet<>();
        }
        this.tlds = temp;
    }

    @Override
    public boolean checkMessage(Player player, String message) {
        return !HOST_PATTERN.matcher(message).find() || tlds.stream().anyMatch(message::contains);
    }

    @Override
    public String getErrorMessage() {
        return ChatColor.RED + "You are not allowed to advertise.";
    }

    @Override
    public int getViolationLevel() {
        return 1;
    }
}
