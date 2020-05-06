package character;

import donjon.AdventureGame;

/**
 * @author Gabriel, Tony
 * 
 * This class represents a character like a player or a monster
 */

public class Character {
	
	protected int life;
	protected int strength;
	protected int gold;
	protected String name;
	protected AdventureGame game;
	
	public Character (int life, int gold, int strenght, String name){
		this.life=life;
		this.strength=strenght;
		this.gold=gold;
		this.name=name;
	}
	
	/**
	 * Add a character into the game
	 * 
	 * @param game the only instance of the game
	 */
	
	public void addToGame(AdventureGame game){
		this.game=game;
	}
	
	/**
	 * 
	 * @return the single instance of the AdventureGame
	 */
	
	public AdventureGame getGame(){
		return this.game;
	}
	
	/**
	 * 
	 * @return the strength points of the character
	 */
	
	public int getStrength(){
		return this.strength;
	}
	
	/**
	 * 
	 * @return the life points of the character
	 */
	
	public int getLife(){
		return this.life;
	}
	
	/**
	 * 
	 *@return the number of gold coin of the character
	 */
	
	public int getGold(){
		return this.gold;
	}
	
	/**
	 * 
	 * @return the name of the character
	 */
	
	public String getName(){
		return this.name;
	}
	
	/**
	 * changes the strength points of the character
	 * 
	 * @param strength new value
	 */
	
	public void changeStrength(int strength){
		this.strength=strength;
	}
	
	/**
	 * changes the life points of the character
	 * 
	 * @param life new value
	 */
	
	public void changeLife(int life){
		this.life=life;
	}
	
	/**
	 * changes the number of gold coin of the character
	 * 
	 * @param gold new value
	 */
	
	public void changeGold(int gold){
		this.gold=gold;
	}
	
	/**
	 * 
	 * @return true if the player is dead
	 */
	
	public boolean isDead(){
		return this.getLife()<=0;
	}
	
	/**
	 * sets the life points of the player to 0
	 * 
	 */
	
	public void die(){
		this.life=0;
		System.out.println(this.getName()+" is dead!");
	}
	
	/**
	 * removes as much life from the target as the player's strength points
	 * 
	 * @param target of the attack
	 */
	
	public void attack(Character target){
		
		target.changeLife(target.getLife()-this.getStrength());
		System.out.println(this.getName()+" attacks "+target.getName()+"!");
		System.out.println(target.getName()+" lose "+this.getStrength()+" life points!\n");

	}
	
	public String toString() {
		return this.name+"\t❤️ "+this.life+"\t💰 "+this.gold+"\t🗡 "+this.strength;
	}
	
	
	

}
