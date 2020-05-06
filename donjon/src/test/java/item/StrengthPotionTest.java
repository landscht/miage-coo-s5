package item;

import static org.junit.Assert.*;

import org.junit.Test;

import character.Player;
import item.Item;
import item.StrengthPotion;

public class StrengthPotionTest extends ItemTest{

	@Override
	protected void effectTest() {
		int value = 10;
		Item strength = new StrengthPotion(value);
		int strengthBefore = p.getStrength();
		strength.isUsedBy(p);
		assertEquals(p.getStrength(),strengthBefore + value);
	}

}
