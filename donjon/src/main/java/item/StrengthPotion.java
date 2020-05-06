package item;

import character.Player;

/**
 * @author Gabriel, Tony
 * 
 * This class represents the strength potion item
 */

public class StrengthPotion implements Item {
	
	private int effect;
	
	public StrengthPotion(int effect) {
		this.effect = effect;
	}
	
	/**
	 * increases by "effect" the player strength points 
	 */

	@Override
	public void isUsedBy(Player player) {
		player.changeStrength(player.getStrength()+this.effect);
		player.getGame().getCurrentRoom().removeItem(this);
		System.out.println(this.effect());
	}
	
	public String toString() {
		return this.effect+" strength points";
	}
	
	/**
	 * 
	 * @return a string which represents the effect of this strength potion item
	 */
	
	public String effect(){
		return "You won " + this.effect + " strength points";
	}
}
