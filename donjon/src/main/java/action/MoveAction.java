package action;

import java.util.List;

import character.Player;
import donjon.AdventureGame;
import room.Direction;

/**
 * @author Gabriel, Tony
 */

public class MoveAction extends ActionAdapter{

	public MoveAction(String name) {
		super(name);
	}
	
	/**
	 * 
	 * The player choose a room and moves in
	 * 
	 */

	@Override
	public void execute(Player player) {
		List<Direction> directions= player.getGame().getCurrentRoom().getDirection();
		Menu<Direction> menu = Menu.INSTANCE;
		menu.setChoices(directions);
		int idx = menu.chooseInList();
		player.getGame().playerMoveTo(directions.get(idx));
	}
	
	/**
	 * 
	 * The player can only move if there is no monster in the room
	 * 
	 */
	
	public boolean isPossible(Player player, AdventureGame game){
		if(game.getCurrentRoom().getMonsters().isEmpty()){
			return true;
		}
		return false;
	}

}
