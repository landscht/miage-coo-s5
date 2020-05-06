package action;

import java.util.List;

import character.Monster;
import character.Player;
import room.Direction;
import room.Room;

/**
 * @author Gabriel, Tony
 */

public class LookAction extends ActionAdapter{

	public LookAction(String name) {
		super(name);
	}

	/**
	 * 
	 * Display a list of the monsters, items and directions of the room
	 * 
	 */
	@Override
	public void execute(Player player) {
		Room current = player.getGame().getCurrentRoom();
		displayDirections(current);
		displayMonsters(current);
		System.out.println("Items : "+current.getItems().toString());
	}
	
	/**
	 *Display the direction(s) of the room
	 * 
	 * @param room the current room
	 */
	
	private void displayDirections(Room room) {
		String s = "Directions : [";
		for(int i=0;i<room.getDirection().size();i++) {
			Direction direction = room.getDirection().get(i);
			s+="Room "+room.getNeighboors().get(direction).getName()+" : "+direction+", ";
		}
		if(!room.getDirection().isEmpty()) {
			s=s.substring(0, s.length()-2);
		}
		System.out.println(s+"]");
	}
	
	/**
	 *Display the monster(s) of the room
	 * 
	 * @param room
	 */
	
	private void displayMonsters(Room room) {
		String s = "Monsters : [";
		for(int i=0;i<room.getMonsters().size();i++) {
			Monster monster = room.getMonsters().get(i);
			s+=monster+"\n            ";
		}
		if(!room.getMonsters().isEmpty()) {
			s=s.substring(0,s.length()-13);
		}
		System.out.println(s+"]");
	}

}
