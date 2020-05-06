package donjon;

import java.util.Scanner;

import character.Monster;
import character.Player;
import item.Gold;
import item.OneArmedBandit;
import room.Direction;
import room.ExitRoom;
import room.Room;

/**
 * @author Gabriel, Tony
 * 
 * This class creates a donjon and tests the game
 */

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println(" _______   ______   .__   __.        __    ______   .__   __. \n" + 
				"|       \\ /  __  \\  |  \\ |  |       |  |  /  __  \\  |  \\ |  | \n" + 
				"|  .--.  |  |  |  | |   \\|  |       |  | |  |  |  | |   \\|  | \n" + 
				"|  |  |  |  |  |  | |  . `  | .--.  |  | |  |  |  | |  . `  | \n" + 
				"|  '--'  |  `--'  | |  |\\   | |  `--'  | |  `--'  | |  |\\   | \n" + 
				"|_______/ \\______/  |__| \\__|  \\______/   \\______/  |__| \\__| \n" + 
				"                                                              ");
		
		AdventureGame game = new AdventureGame(new Room("0"));
		Player player = new Player(100,5,10,getPseudo());
		game.addPlayer(player);
		player.addToGame(game);
		game.generateDonjon(10);
		game.play(player);
	}
	
	/**
	 * 
	 * @return the pseudo that the player chose
	 */
	
	private static String getPseudo() {
		System.out.println("What is your name, adventurer?");
		Scanner sc = new Scanner(System.in);
		String pseudo = sc.nextLine();
		System.out.println("Welcome "+pseudo+" and good luck!\n");
		return pseudo;
	}
 
}
