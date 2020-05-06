package room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import character.Monster;
import item.Item;

/**
 * @author Gabriel, Tony
 * 
 * This class represents a room of the donjon
 */

public class Room {

	private List<Monster> monsters;
	private List<Item> items;
	private Map<Direction, Room> neighboors;
	private String name;
	
	public Room(String name) {
		this.monsters = new ArrayList<>();
		this.items = new ArrayList<>();
		this.neighboors = new HashMap<>();
		this.name = name;
	}
	
	/**
	 * Adds a monster into the room
	 * 
	 * @param monster new monster
	 */

	public void addMonster(Monster monster) {
		this.monsters.add(monster);
	}
	
	/**
	 * Adds an item into the room
	 * 
	 * @param item new item
	 */
	
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	/**
	 * Adds a neighboring room in the Direction direction
	 * 
	 * @param room new Room
	 * @param direction associated direction
	 */
	
	public void addRoom(Room room, Direction direction) {
		this.neighboors.put(direction, room);
		room.getNeighboors().put(Direction.opposite(direction), this);
	}
	
	/**
	 * Removes the monster of the room
	 * 
	 * @param monster to remove
	 */
	
	public void removeMonster(Monster monster){
		this.monsters.remove(monster);
	}
	
	/**
	 * Removes the item of the room
	 * 
	 * @param item to remove
	 */
	
	public void removeItem(Item item){
		this.items.remove(item);
	}
	
	/**
	 * 
	 * @return the list of the monster of the room
	 */

	public List<Monster> getMonsters() {
		return monsters;
	}
	
	/**
	 * 
	 * @return the list of the item of the room
	 */

	public List<Item> getItems() {
		return items;
	}
	
	/**
	 * 
	 * @return the list of the neighboring rooms
	 */

	public Map<Direction, Room> getNeighboors() {
		return neighboors;
	}
	
	/**
	 * 
	 * @return the name of the room
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return the directions of the neighboring rooms
	 */
	
	public List<Direction> getDirection() {
		List<Direction> directions = new ArrayList<>();
		for(Direction d : this.neighboors.keySet()) {
			directions.add(d);
		}
		return directions;
	}
	
	/**
	 * 
	 * @return false
	 */
	
	public boolean isExit() {
		return false;
	}
	
	public String toString() {
		return "\n                    ROOM "+this.name+"\n";
	}
}
