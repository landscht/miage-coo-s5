package character;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import character.Monster;
import character.Player;
import donjon.AdventureGame;
import room.Room;

public abstract class CharacterTest {
	
	protected Player player;
	protected Monster monster;
	
	@Before
	public void init(){
		AdventureGame game = new AdventureGame(new Room("1"));
		player = new Player(100,10,10,"Tony");
		monster = new Monster(15,10,10,"Monster");
		player.addToGame(game);
		monster.addToGame(game);
		game.addPlayer(player);
	}
	
	@Test
	public abstract void die();
	
	@Test
	public abstract void attack();

	@Test
	public void changeStrenghTest(){
		int newStrenght = 5;
		player.changeStrength(newStrenght);
		assertEquals(player.getStrength(),newStrenght);
	}
	
	@Test
	public void changeLifeTest(){
		int newLife = 5;
		player.changeLife(newLife);
		assertEquals(player.getLife(),newLife);
	}

	@Test
	public void changeGoldTest(){
		int newGold = 5;
		player.changeGold(newGold);
		assertEquals(player.getGold(),newGold);
	}



}
