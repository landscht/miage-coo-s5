package item;

import character.Player;

/**
 * @author Gabriel, Tony
 * 
 * This class represents the gold item
 */

public class Gold implements Item {
	
	private int effect;
	
	public Gold(int effect) {
		this.effect = effect;
	}
	
	/**
	 * increases by "effect" the player gold coins 
	 */

	@Override
	public void isUsedBy(Player player) {
		player.changeGold(player.getGold()+this.effect);
		player.getGame().getCurrentRoom().removeItem(this);
		System.out.println(this.effect());
	}
	
	public String toString() {
		return this.effect+" gold coins";
	}
	
	/**
	 * 
	 * @return a string which represents the effect of this gold item
	 */
	
	public String effect(){
		return "You won " + this.effect + " gold coins";
	}
}
