package courrier;

import java.util.ArrayList;
import java.util.List;

import city.City;
import city.Inhabitant;
import content.Account;
import content.ListInhabitants;
import letter.FoolLetter;
import letter.Letter;


/**
 * 
 * @author Gabriel, Tony
 * 
 * Self-testing main class, second simulation (Q11)
 *
 */

public class SecondSimulation {
	
	private static int nbletters = 0;
	private static int day = 1;
	
	public static void startSimulation() {
		
		City v = new City("V");
    	createInhabitants(v);
    	Letter<ListInhabitants> foolLetter = createFirstFoolLetter(v);
    	v.addLetter(foolLetter);
    	while(!v.getLetters().isEmpty()){
    		System.out.println("-------------------------------------------------------------");
    		System.out.println("Jour "+(day)+"\n");
    		displayLetters(v);
    		v.distributeLetters();
    		day++;
    	}
    	System.out.println("The richest inhabitant has a fortune of "+getRichestInhabitant(v).getBankAccount().getBalance());
	}
	
	/**
	 * creates the first full letter, with its 4 inhabitants
	 * 
	 * @param v the city of the inhabitants
	 * @return the first fool letter
	 */
	
	private static FoolLetter createFirstFoolLetter(City v){
		Inhabitant initialInhabitant = v.getRandomInhabitant();
    	List<Inhabitant> listInhabitants = new ArrayList<>();
    	for(int i=0;i<4;i++){
    		Inhabitant inhabitant;
    		do{
    			inhabitant = v.getRandomInhabitant();
    		}while(inhabitant.equals(initialInhabitant));
    		listInhabitants.add(inhabitant);
    	}
    	ListInhabitants content = new ListInhabitants(listInhabitants);
    	return new FoolLetter(initialInhabitant, v.getRandomInhabitant(), content);
		
	}
	
	 /**
     * creates the inhabitants of the city
     * 
     * @param v the city of the inhabitants
     */
    
    private static void createInhabitants(City v){
    	for(int i = 0;i<100;i++){
    		v.addInhabitant(new Inhabitant(v,new Account(100)));
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
     * @return the richest inhabitant
     */
    
    private static Inhabitant getRichestInhabitant(City v){
    	List<Inhabitant> inhabitants = v.getInhabitants();
    	Inhabitant richest=inhabitants.get(0);
    	for(int i=1;i<inhabitants.size();i++){
    		if(inhabitants.get(i).getBankAccount().getBalance()>richest.getBankAccount().getBalance()){
    			richest = inhabitants.get(i);
    		}
    	}
    	return richest;
    }

}
