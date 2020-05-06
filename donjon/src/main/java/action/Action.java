package action;

import character.Player;
import donjon.AdventureGame;

/**
 * @author Gabriel, Tony
 * 
 * This class represents an action like "move", "attack", "look" and "use"
 */

public interface Action {
	
	/**
	 * Execute the action
	 * 
	 * @param player The player of the game
	 */
	
	public void execute(Player player);
	
	/**
	 * @param player The player of the game
	 * @param game The only instance game
	 * @return true if the action is possible
	 */
	
	public boolean isPossible(Player player, AdventureGame game);

}
