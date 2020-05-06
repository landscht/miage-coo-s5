package courrier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import city.City;
import city.Inhabitant;
import content.Account;
import content.Money;
import content.Text;
import letter.BillOfExchange;
import letter.Letter;
import letter.RegisteredLetter;
import letter.SimpleLetter;
import letter.UrgentLetter;

/**
 * 
 * @author Gabriel, Tony
 * 
 * Self-testing main class, first simulation (Q10)
 *
 */

public class FirstSimulation {
	
	private static int nbletters = 0;
	
	public static void startSimulation() {
		
    	City v = new City("V");
    	createInhabitants(v);
    	int nbDays = 14;
    	for(int k=0;k<nbDays;k++){
    		System.out.println("-------------------------------------------------------------");
    		System.out.println("Jour "+(k+1)+"\n");
    		createLetters(v);
    		displayLetters(v);
    		v.distributeLetters();
    	}
    }
    
    /**
     * creates the inhabitants of the city
     * 
     * @param v the city of the inhabitants
     */
    
    private static void createInhabitants(City v){
    	for(int i = 0;i<100;i++){
    		v.addInhabitant(new Inhabitant(v,new Account(500)));
    	}
    }
    
    /**
     * creates the letters during one day
     * 
     * @param v the city of the inhabitants
     */
    
    private static void createLetters(City v){
    	Random r = new Random();
		int nbLetters = r.nextInt(11);
    	for(int n=0;n<nbLetters;n++){
    		List<Letter<?>> letters = getTypeOfLetters(v);
			int idx = r.nextInt(letters.size());
			v.addLetter(letters.get(idx));
		}
    }
    
    /**
     * displays the letters of the city
     * 
     * @param v the city of the inhabitants
     */
    
    private static void displayLetters(City v){
    	for(int j=0;j<v.getLetters().size();j++){
    		Letter<?> letter = v.getLetters().get(j);
			System.out.println(">>> hab"+v.getInhabitants().indexOf(letter.getSender())+" envoie courrier"+nbletters+" "+letter+" (cout:"+letter.getCost()+") à "+"hab"+v.getInhabitants().indexOf(letter.getReceiver()));
			nbletters++;
		}
    }
    
    /**
     * 
     * @param v the city of the inhabitants
     * @return a list of the different possible letters
     */
    
    private static List<Letter<?>> getTypeOfLetters(City v){
    	List<Letter<?>> letters = new ArrayList<>();
    	Inhabitant sender = v.getRandomInhabitant();
    	Inhabitant receiver = v.getRandomInhabitant();
    	Letter<Text> simpleLetter = new SimpleLetter(sender,receiver,new Text("Hey"));
    	Letter<Money> billOfExchange = new BillOfExchange(sender,receiver,new Money(50));
    	Letter<Letter<?>> registeredLetter = new RegisteredLetter(sender,receiver,simpleLetter);
    	Letter<Letter<?>> urgentLetter = new UrgentLetter(sender,receiver,billOfExchange);
    	letters.add(simpleLetter);
    	letters.add(billOfExchange);
    	letters.add(registeredLetter);
    	letters.add(urgentLetter);
    	return letters;
    }

}
