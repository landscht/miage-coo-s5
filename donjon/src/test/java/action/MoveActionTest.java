package action;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import room.Direction;
import room.Room;

public class MoveActionTest extends ActionTest{
	
	@Override
	public void execute() {
		
		Room r1 = p.getGame().getCurrentRoom();
		Room r2 = new Room("r2");
		Room r3 = new Room("r3");
		r1.addRoom(r2,Direction.NORTH);
		r2.addRoom(r3,Direction.WEST);
		
		String simulatedInput = "1\n1\n";
		InputStream mockIn = new ByteArrayInputStream(simulatedInput.getBytes());
		Menu.INSTANCE.setIn(mockIn);
		p.act();
		Menu.INSTANCE.setInToSystemIn();
		assertEquals(p.getGame().getCurrentRoom(),r2);
		
	}

}
