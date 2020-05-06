package donjon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import action.Menu;
import character.Monster;
import character.Player;
import item.Gold;
import item.HealthPotion;
import item.Item;
import item.OneArmedBandit;
import item.StrengthPotion;
import room.Direction;
import room.ExitRoom;
import room.Room;

/**
 * @author Gabriel, Tony
 * 
 * This class represents the game
 */

public class AdventureGame {
	
	private Room currentRoom;
	private Player player;
	
	public AdventureGame(Room startingRoom) {
		this.currentRoom = startingRoom;
	}
	
	/**
	 * 
	 * @return the room in which the player is
	 */
	
	public Room getCurrentRoom(){
		return currentRoom;
	}
	
	/**
	 * 
	 * @return the only player of the game
	 */
	
	public Player getPlayer(){
		return player;
	}
	
	/**
	 * Adds a player into the game
	 * 
	 * @param player current player
	 */
	
	public void addPlayer(Player player) {
		this.player=player;
	}
	
	/**
	 * As long as the player has not played or lost, he chooses an action
	 * 
	 * @param player current player
	 */
	
	public void play(Player player){
		while(!isFinished() && player.getLife() > 0) {
			System.out.println("--------️-------------------------------------");
			System.out.println(this.player.toString());
			System.out.println(this.getCurrentRoom().toString());
			player.act();
		}
		if(player.getLife() > 0) {
			System.out.println("Bien joué, vous avez survécu au donjon !! :)");
		}else {
			System.out.println("Dommage, vous avez perdu !! :(");
		}
	}
	
	/**
	 * Adds a monster into the room
	 * 
	 * @param monster new monster
	 * @param room current room
	 */
	
	public void addMonster(Monster monster, Room room){
		room.addMonster(monster);
	}
	
	/**
	 * Adds an item into the room
	 * 
	 * @param item new item
	 * @param room current room
	 */
	
	public void addItem(Item item, Room room){
		room.addItem(item);
	}
	
	/**
	 * 
	 * @return true if the player has lost or won
	 */
	
	public boolean isFinished(){
		if(player.isDead() || currentRoom.isExit()){
			return true;
		}
		return false;
	}
	
	/**
	 * Moves the player into the room corresponding to the direction
	 * 
	 * @param direction of the movement
	 */
	
	public void playerMoveTo(Direction direction){
		this.currentRoom  = this.currentRoom.getNeighboors().get(direction);
	}
	
	/**
	 * Generates a donjon with nbRoom rooms
	 * 						   between 1 and 3 monsters
	 * 						   between 0 and 2 items 
	 * 
	 * @param nbRoom of the dungeon
	 */
	
	public void generateDonjon(int nbRoom) {
		Direction[] directions = Direction.values();
		Room[] rooms = new Room[nbRoom];
		
		rooms[0] = currentRoom;
		Random r = new Random();
		
		for(int i=0;i<nbRoom-1;i++) {
			Room room;
			if(i==nbRoom-2) {
				room = new ExitRoom("exit");
			}else {
				room = new Room(""+(i+1));
			}
			rooms[i+1] = room;
			Direction direction;
			do {
				direction = directions[r.nextInt(4)]; 
			}while(room.getNeighboors().containsKey(direction));
			
			rooms[i].addRoom(room, direction);
			generateMonsters(rooms[i]);
			generateItems(rooms[i]);
			
		}
	}
	
	private void generateMonsters(Room room){
		Random r = new Random();
		for(int j=0;j<r.nextInt(3)+1;j++) {
			Monster monster = new Monster(r.nextInt(10)+10,10,10,"Monster "+j);
			monster.addToGame(this);
			room.addMonster(monster);
		}
	}
	
	private void generateItems(Room room){
		Item[] items = new Item[4];
		items[0]=new Gold(10);
		items[1]=new StrengthPotion(10);
		items[2]=new HealthPotion(10);
		items[3]=new OneArmedBandit(5);
		Random r = new Random();
		
		for(int k=0;k<r.nextInt(3);k++) {
			room.addItem(items[r.nextInt(4)]);
		}
	}
}
