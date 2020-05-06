package item;

import java.util.Random;

import character.Player;

/**
 * @author Gabriel, Tony
 * 
 * This class represents the one armed bandit item
 */

public class OneArmedBandit implements Item{
	
	private Item item;
	private int nbGold;
	
	public OneArmedBandit(int nbGold) {
		this.nbGold = nbGold;
	}
	
	/**
	 * chooses an item randomly and uses it 
	 */

	@Override
	public void isUsedBy(Player player) {
		if(player.getGold()>=this.nbGold){
			player.changeGold(player.getGold()-this.nbGold);
			Item[] items = new Item[3];
			items[0] = new Gold(15);
			items[1] = new StrengthPotion(15);
			items[2] = new HealthPotion(15);
			Random r = new Random();
			item = items[r.nextInt(3)];
			item.isUsedBy(player);
		}
		player.getGame().getCurrentRoom().removeItem(this);
		System.out.println(this.effect());
	}
	
	/**
	 * 
	 * @return the random item chosen by the one armed bandit item
	 */
	
	public Item getItem(){
		return item;
	}
	
	public String toString() {
		return "One armed bandit";
	}
	
	/**
	 * 
	 * @return a string which represents the effect of this one armed bandit item
	 */
	
	public String effect(){
		return "One armed bandit disapperead";
	}
}
