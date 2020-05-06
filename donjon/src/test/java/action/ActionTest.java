package action;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import character.Player;
import donjon.AdventureGame;
import room.Room;

public abstract class ActionTest {
	
	protected Player p;
	
	@Before
	public void init(){
		p = new Player(10, 10, 10, "playerTest");
		Room r1 = new Room("1");
		AdventureGame game = new AdventureGame(r1);
		p.addToGame(game);
	}

	@Test
	public abstract void execute();

}
