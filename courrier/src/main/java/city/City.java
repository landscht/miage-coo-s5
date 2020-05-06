package city;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import letter.Letter;

/**
 * 
 * @author Gabriel, Tony
 * 
 * This class represents a city with its letters and its inhabitants
 *
 */

public class City {
	
	private String name;
	private List<Inhabitant> inhabitants;
	private List<Letter<?>> letters;
	
	/**
	 * 
	 * @param name the name of the city
	 */
	
	public City(String name){
		this.name=name;
		inhabitants = new ArrayList<>();
		letters = new ArrayList<>();
	}
	
	/**
	 * 
	 * @param name the name of the city
	 * @param inhabitants the inhabitants of the city
	 */
	
	public City(String name, List<Inhabitant> inhabitants){
		this(name);
		this.inhabitants=inhabitants;
	}
	
	/**
	 * 
	 * @return the name of the city
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @return the inhabitants of the city
	 */
	
	public List<Inhabitant> getInhabitants() {
		return inhabitants;
	}
	
	/**
	 * 
	 * @return the letters of the city
	 */
	
	public List<Letter<?>> getLetters(){
		return letters;
	}
	
	/**
	 * Adds a letter to the city
	 * 
	 * @param letter the letter to be added
	 */
	
	public void addLetter(Letter<?> letter){
		letters.add(letter);
	}
	
	/**
	 * 
	 * Distributes all the letters of the city
	 * 
	 */
	
	public void distributeLetters(){
		List<Letter<?>> bag = new ArrayList<>(letters);
		for(Letter<?> l : bag){
			l.getReceiver().receiveLetter(l);
			letters.remove(l);
		}
	}
	
	/**
	 * Adds an inhabitant to the city
	 * 
	 * @param inhabitant the inhabitant to be added
	 */
	
	public void addInhabitant(Inhabitant inhabitant){
		this.inhabitants.add(inhabitant);
	}
	
	/**
	 * Removes an inhabitant of the city
	 * 
	 * @param inhabitant the inhabitant to be removed
	 */
	
	public void removeInhabitant(Inhabitant inhabitant){
		this.inhabitants.remove(inhabitant);
	}
	
	/**
	 * @return a random inhabitant in the city
	 */
	
	public Inhabitant getRandomInhabitant(){
		Random r = new Random();
		if(!inhabitants.isEmpty()){
			int idx = r.nextInt(inhabitants.size());
			return inhabitants.get(idx);
		}
		return null;
	}

}
