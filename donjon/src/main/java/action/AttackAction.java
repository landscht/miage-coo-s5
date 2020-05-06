package action;

import java.util.List;

import character.Monster;
import character.Player;
import donjon.AdventureGame;

/**
 * @author Gabriel, Tony
 */

public class AttackAction extends ActionAdapter {

	public AttackAction(String name) {
		super(name);
	}
	
	/**
	 * 
	 * The player chooses a monster and attack it
	 * 
	 */

	@Override
	public void execute(Player player) {
		List<Monster> monsters = player.getGame().getCurrentRoom().getMonsters();
		Menu<Monster> menu = Menu.INSTANCE;
		menu.setChoices(monsters);
		int idx=menu.chooseInList();
		player.attack(monsters.get(idx));	
	}
	
	/**
	 * 
	 * The play can only attack only if there is at least one monster
	 * 
	 */
	
	public boolean isPossible(Player player, AdventureGame game){
		if(!game.getCurrentRoom().getMonsters().isEmpty()){
			return true;
		}
		return false;
	}
}
