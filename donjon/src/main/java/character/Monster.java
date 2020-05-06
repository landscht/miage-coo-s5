package character;

import item.Gold;

/**
 * @author Gabriel, Tony
 * 
 * This class represents a monster of a room
 */

public class Monster extends Character{

	public Monster(int life, int gold, int strenght, String name) {
		super(life, gold, strenght, name);
	}
	
	/**
	 * sets the life points of the player to 0 and drop all of its gold
	 * 
	 */
	
	public void die(){
		super.die();
		this.game.getCurrentRoom().addItem(new Gold(this.getGold()));
		this.game.getCurrentRoom().removeMonster(this);
	}

}

