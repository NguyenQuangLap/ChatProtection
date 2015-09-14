package net.thelightmc.chatprotection.checks;

import org.bukkit.entity.Player;

/**
 * @author TheLightMC
 */
public interface Check {
    /**
     * @param player who sent the message
     * @param message the message that was sent
     * @return if the message is OK.
     */
    boolean checkMessage(Player player,String message);

    /**
     * @return desired error message
     */
    String getErrorMessage();

    /**
     * @return violation increment
     */
    int getViolationLevel();
}
