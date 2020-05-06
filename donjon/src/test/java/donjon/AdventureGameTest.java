package donjon;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import character.Player;
import donjon.AdventureGame;
import room.Direction;
import room.ExitRoom;
import room.Room;

public class AdventureGameTest {
	
	AdventureGame game;
	Player p;

	@Before
	public void init() {
		p = new Player(10, 10, 10, "playerTest");
		Room r1 = new Room("1");
		game = new AdventureGame(r1);
		p.addToGame(game);
		game.addPlayer(p);
	}
	
	@Test
	public void playerWonTest() {
		Room exit = new ExitRoom("exit");
		game.getCurrentRoom().addRoom(exit, Direction.NORTH);
		game.playerMoveTo(Direction.NORTH);
		assertTrue(game.isFinished());
		assertTrue(game.getCurrentRoom().isExit());
		assertFalse(p.isDead());
	}
	
	@Test
	public void playerLoseTest() {
		p.changeLife(0);
		assertTrue(game.isFinished());
		assertTrue(p.isDead());
		assertFalse(game.getCurrentRoom().isExit());
	}
	
	@Test
	public void playerMoveTo() {
		Room r1 = p.getGame().getCurrentRoom();
		Room r2 = new Room("r2");
		Room r3 = new Room("r3");
		r1.addRoom(r2,Direction.NORTH);
		r2.addRoom(r3,Direction.WEST);
		p.getGame().playerMoveTo(Direction.NORTH);
		assertEquals(p.getGame().getCurrentRoom(),r2);
		p.getGame().playerMoveTo(Direction.WEST);
		assertEquals(p.getGame().getCurrentRoom(),r3);
	}

}
