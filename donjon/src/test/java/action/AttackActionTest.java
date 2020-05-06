package action;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import character.Monster;
import item.Gold;
import room.Room;

public class AttackActionTest extends ActionTest{
	
	Monster m1;

	@Override
	public void execute() {
		
		m1 = new Monster(10,10,10,"Antoine");
		Room currentRoom = p.getGame().getCurrentRoom();
		m1.addToGame(p.getGame());
		currentRoom.addMonster(m1);
		assertTrue(currentRoom.getItems().isEmpty());
		
		String simulatedInput = "2\n1\n";
		InputStream mockIn = new ByteArrayInputStream(simulatedInput.getBytes());
		Menu.INSTANCE.setIn(mockIn);
		p.act();
		Menu.INSTANCE.setInToSystemIn();
		
		assertTrue(m1.isDead());
		assertEquals(new Gold(10).toString(),currentRoom.getItems().get(0).toString());
	
	}

}
