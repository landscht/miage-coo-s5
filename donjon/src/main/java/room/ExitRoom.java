package room;

/**
 * @author Gabriel, Tony
 * 
 * This class represents an exit room,
 * if the player reach it, he wins
 */

public class ExitRoom extends Room {

	public ExitRoom(String name) {
		super(name);
	}
	
	/**
	 * @return true
	 */

	public boolean isExit() {
		System.out.println("YOU WON!");
		return true;
	}
}
