package character;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonsterTest extends CharacterTest{

	@Override
	public void die() {
		monster.die();
		assertEquals(0,monster.getLife());
		assertTrue(monster.isDead());
	}

	@Override
	public void attack() {
		monster.changeLife(15);
		int lifePlayer = player.getLife();
		monster.attack(player);
		assertEquals(player.getLife(), lifePlayer-monster.getStrength());
	}


}
