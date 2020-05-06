package character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import action.ActionAdapter;
import action.AttackAction;
import action.LookAction;
import action.Menu;
import action.MoveAction;
import action.UseAction;

/**
 * @author Gabriel, Tony
 * 
 * This class represents the only player of the game
 */

public class Player extends Character{
	
	List<ActionAdapter> actions;

	public Player(int life, int gold, int strenght, String name) {
		super(life, gold, strenght, name);
		ActionAdapter move = new MoveAction("move");
		ActionAdapter look = new LookAction("look");
		ActionAdapter use = new UseAction("use");
		ActionAdapter attack = new AttackAction("attack");
		actions = new ArrayList<>(Arrays.asList(move,look,use,attack));
	}
	
	/**
	 * The player chooses an action and executes it
	 * 
	 */
	
	public void act(){
		List<ActionAdapter> possibleActions = new ArrayList<>();
		
		for(int i=0;i<actions.size();i++) {
			if(actions.get(i).isPossible(this, this.getGame())) {
				possibleActions.add(actions.get(i));
			}
		}
		Menu<ActionAdapter> menu = Menu.INSTANCE;
		menu.setChoices(possibleActions);
		int idx  = menu.chooseInList();
		possibleActions.get(idx).execute(this);
	}
	
	/**
	 * removes as much life from the target as the player's strength points
	 * if the target is not dead, the target attacks back
	 * 
	 */
	
	public void attack(Character target){
		super.attack(target);
		if(target.isDead()){
			target.die();
		}else{
			target.attack(this);
		}
	}
	
	/**
	 * sets the life points of the player to 0 and displays
	 * that the player lost
	 * 
	 */
	
	public void die() {
		super.die();
		System.out.println("YOU LOSE");
	}
	

}
