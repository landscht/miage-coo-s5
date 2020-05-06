package action;

import character.Player;
import donjon.AdventureGame;

/**
 * @author Gabriel, Tony
 */

public abstract class ActionAdapter implements Action {
	
	protected String name;
	
	/**
	 * The name of the action
	 * 
	 * @param name of the action
	 */
	
	public ActionAdapter(String name){
		this.name=name;
	}
	
	public abstract void execute(Player player);
	
	public boolean isPossible(Player player, AdventureGame game){
		return true;
	}
	
	public String toString() {
		return name;
	}
	

}
