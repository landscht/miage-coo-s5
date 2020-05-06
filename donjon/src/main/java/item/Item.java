package item;

import character.Player;

/**
 * @author Gabriel, Tony
 * 
 * This class represents an item of the room
 */

public interface Item {
	
	/**
	 * Uses the current item
	 * 
	 * @param player the player of the game
	 */

	public void isUsedBy(Player player);
	
}
