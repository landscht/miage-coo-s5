package action;

import java.util.List;

import character.Player;
import donjon.AdventureGame;
import item.Item;

/**
 * @author Gabriel, Tony
 */

public class UseAction extends ActionAdapter{

	public UseAction(String name) {
		super(name);
	}
	
	/**
	 * 
	 * The player chooses an item and uses it
	 * 
	 */

	public void execute(Player player) {
		List<Item> items = player.getGame().getCurrentRoom().getItems();
		Menu<Item> menu = Menu.INSTANCE;
		menu.setChoices(items);
		int idx = menu.chooseInList();
		items.get(idx).isUsedBy(player);
		
	}
	
	/**
	 * 
	 * The player can only use an item if there is at least one item in the room
	 * 
	 */

	public boolean isPossible(Player player, AdventureGame game) {
		
		if(!game.getCurrentRoom().getItems().isEmpty()){
			return true;
		}
		return false;
	}


}
