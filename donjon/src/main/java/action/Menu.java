package action;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Gabriel, Tony
 */

public class Menu<T> {
	
	private List<T> choices;
	private static Scanner scanner = new Scanner(System.in);
	
	private Menu() {
		this.setInToSystemIn();
	}
	
	/** SINGLETON instance */
	public static final Menu INSTANCE = new Menu();
	
	/**
	 * Sets the list of choices
	 * 
	 * @param choices the list of choices
	 */
	
	public void setChoices(List<T> choices) {
		this.choices=choices;
	}
	
	/**
	 * @return the player's choice
	 */
	
	public int chooseInList() {
		String message="Select an action :\n";
		for(int i=0;i<choices.size();i++) {
			message+=i+1+" - "+choices.get(i)+"\n";
		}
		System.out.println(message);
		return Menu.readInt(this.choices.size());
	}
	
	/**
	 * 
	 * @param n the index chosen
	 * @return the player's choice
	 */
	
	public static int readInt(int n) {
		int input = -1;
		while (input < 1 || input > n) {
			System.out.print("your choice (1-" + (n) + ") ? ");
			try {
				input = scanner.nextInt();
				System.out.println();
			} catch (InputMismatchException	 e){
				// consume the input (that is not an integer)
				scanner.skip(".*");
			}
		} 
		return input-1;
	}
	
	public void setIn(InputStream input) {
		scanner = new Scanner(input);
	}
	
	public void setInToSystemIn() {
		this.setIn(System.in);
	}

}
