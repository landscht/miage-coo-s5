package item;

import static org.junit.Assert.*;

import org.junit.Test;

import character.Player;
import item.HealthPotion;
import item.Item;

public class HealthPotionTest extends ItemTest{

	@Override
	protected void effectTest() {
		int value = 10;
		Item life = new HealthPotion(value);
		int lifeBefore = p.getLife();
		life.isUsedBy(p);
		assertEquals(p.getLife(),lifeBefore + value);
		
	}

}
