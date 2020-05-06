package item;

import character.Player;

/**
 * @author Gabriel, Tony
 * 
 * This class represents the health potion item
 */

public class HealthPotion implements Item {
	
	private int effect;
	
	public HealthPotion(int effect) {
		this.effect = effect;
	}
	
	/**
	 * increases by "effect" the player life points 
	 */

	@Override
	public void isUsedBy(Player player) {
		// à modifier la valeur de life
		player.changeLife(player.getLife()+this.effect);
		player.getGame().getCurrentRoom().removeItem(this);
		System.out.println(this.effect());
	}
	
	public String toString() {
		return this.effect+ " life points";
	}
	
	/**
	 * 
	 * @return a string which represents the effect of this health potion item
	 */
	
	public String effect(){
		return "You won " + this.effect + " life points";
	}
}
