package room;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import character.Monster;
import character.Player;
import donjon.AdventureGame;
import item.Gold;
import item.Item;
import room.Direction;
import room.Room;

public class RoomTest {
	
	Room room;
	Room roomNeighboor;
	Direction direction;
	Direction directionOpposite;
	
	@Before
	public void init() {
		this.room = new Room("roomTest");
		this.roomNeighboor = new Room("roomNeighboor");
		this.direction = Direction.NORTH;
		this.directionOpposite = Direction.opposite(this.direction);
	}
	
	@Test
	public void neightboorsRoomTest() {
		room.addRoom(roomNeighboor, direction);
		assertTrue(room.getNeighboors().containsValue(roomNeighboor));
		assertEquals(room.getNeighboors().get(direction),roomNeighboor);
		
		assertTrue(roomNeighboor.getNeighboors().containsValue(room));
		assertEquals(roomNeighboor.getNeighboors().get(directionOpposite),room);
	}
	
	@Test
	public void addMonsterTest() {
		Monster monster = new Monster(100, 10, 10, "monsterTest");
		assertEquals(0, room.getMonsters().size());
		room.addMonster(monster);
		assertEquals(1, room.getMonsters().size());
		assertEquals(monster, room.getMonsters().get(0));
	}
	
	@Test
	public void addItemTest() {
		Item item = new Gold(10);
		assertEquals(0, room.getItems().size());
		room.addItem(item);
		assertEquals(1, room.getItems().size());
		assertEquals(item, room.getItems().get(0));
	}
	
	@Test
	public void removeItemTest(){
		Item item = new Gold(10);
		room.addItem(item);
		room.removeItem(item);
		assertEquals(0, room.getItems().size());
	}
	
	@Test
	public void removeMonsterTest(){
		Monster monster = new Monster(100,10,10,"monsterTest");
		room.addMonster(monster);
		room.removeMonster(monster);
		assertEquals(0, room.getMonsters().size());
	}

}
