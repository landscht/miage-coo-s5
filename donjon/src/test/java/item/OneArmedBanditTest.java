package item;

import static org.junit.Assert.*;

import org.junit.Test;

import character.Player;
import item.Gold;
import item.OneArmedBandit;

public class OneArmedBanditTest extends ItemTest{
	
	@Override
	protected void effectTest() {
		int value = 5;
		OneArmedBandit bandit = new OneArmedBandit(value);
		int goldBefore = p.getGold();
		bandit.isUsedBy(p);
		int tmp=0;
		if(bandit.getItem() instanceof Gold){
			tmp=15;
		}
		assertNotNull(bandit.getItem());
		assertEquals(goldBefore-value+tmp,p.getGold());
	}
	
	@Test
	public void effectTestWhenNotEnoughtGold(){
		int value = 9999;
		OneArmedBandit bandit = new OneArmedBandit(value);
		int goldBefore = p.getGold();
		bandit.isUsedBy(p);
		assertEquals(goldBefore,p.getGold());
		assertNull(bandit.getItem());
	}

}
