package action;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import item.Gold;
import item.Item;
import item.StrengthPotion;

public class UseActionTest extends ActionTest {
	
	@Override
	public void execute() {
		
		Item gold = new Gold(10);
		p.getGame().getCurrentRoom().addItem(gold);
		assertEquals(gold.toString(),p.getGame().getCurrentRoom().getItems().get(0).toString());
		
		String simulatedInput = "3\n1\n";
		InputStream mockIn = new ByteArrayInputStream(simulatedInput.getBytes());
		Menu.INSTANCE.setIn(mockIn);
		p.act();
		Menu.INSTANCE.setInToSystemIn();
		
		assertTrue(p.getGame().getCurrentRoom().getItems().isEmpty());
		
	}

}
