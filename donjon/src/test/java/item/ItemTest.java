package item;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import character.Player;
import donjon.AdventureGame;
import room.Room;

public abstract class ItemTest {
	
	protected Player p;
	
	@Before
	public void init(){
		p = new Player(10, 10, 10, "playerTest");
		Room r1 = new Room("1");
		AdventureGame game = new AdventureGame(r1);
		p.addToGame(game);
	}

	@Test
	public void isUsedByTest() {
		
		this.effectTest();
	}
	
	protected abstract void effectTest();
	

}
