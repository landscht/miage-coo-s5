package character;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest extends CharacterTest{

	@Override
	public void die() {
		player.die();
		assertEquals(0,player.getLife());
		assertTrue(player.isDead());
	}

	@Override
	public void attack() {
		player.changeLife(100);
		monster.changeLife(player.getStrength()+10);  //life points of the monster higher than our strength
		int lifeMonster = monster.getLife();
		int lifePlayer = player.getLife();
		player.attack(monster);
		assertEquals(monster.getLife(),lifeMonster-player.getStrength());
		assertEquals(player.getLife(),lifePlayer-monster.getStrength());
		
	}




}
