package item;

import static org.junit.Assert.*;

import org.junit.Test;

import character.Player;
import item.Gold;
import item.Item;

public class GoldTest extends ItemTest{

	@Override
	protected void effectTest() {
		int value = 10;
		Item gold = new Gold(value);
		int goldBefore = p.getGold();
		gold.isUsedBy(p);
		assertEquals(p.getGold(),goldBefore + value);
	}

}
