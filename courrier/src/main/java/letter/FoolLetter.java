package letter;

import city.Inhabitant;
import content.Content;
import content.ListInhabitants;
import content.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author Gabriel, Tony
 * 
 * This class represents a fool letter, this letter contains a list of 4 inhabitants
 * This letter asks you to : - send 5 euros to each of the inhabitants of the list 
 *                           - delete the first name of the list and put your name in the last position
 *                           - send the letter with the new list to 10 inhabitants
 *
 */

public class FoolLetter extends Letter<ListInhabitants> {

    /**
     * @param sender   the sender of the fool letter
     * @param receiver the receiver of the fool letter
     * @param content  the content of the fool letter
     */
	
    public FoolLetter(Inhabitant sender, Inhabitant receiver, ListInhabitants content) {
        super(sender, receiver, content);
    }
    
    /**
     * - send 5 euros to each of the inhabitants of the list 
     * - delete the first name of the list and put your name in the last position
     * - send the letter with the new list to 10 inhabitants
     */

    @Override
    public void action() {
        Random r = new Random();
        int nb = r.nextInt(100);
        if(/*nb <= 15 &&*/ this.receiver.getBankAccount().getBalance()>=0) {
            sends5Euros();
            changeNames();
            sendFoolLetters();
        }
    }
    
    /**
     * @return the cost of a fool letter
     */

    @Override
    public float getCost() {
        return 2;
    }
    
    /**
     * sends 5 euros to all the inhabitants of the list
     */
    
    private void sends5Euros(){
    	for(int i=0 ; i<content.getList().size() ; i++) {
            Letter<Money> letterChange = new BillOfExchange(this.receiver, content.getList().get(i), new Money(5));
            this.receiver.sendLetter(letterChange);
        }
    }
    
    /**
     * deletes the first name of the list and put your name in the last position
     */
    
    private void changeNames(){
    	this.getContent().getList().remove(0);
        this.getContent().getList().add(this.receiver);
    }
    
    /**
     * sends the fool letters to 10 inhabitants
     */
    
    private void sendFoolLetters(){
    	if(this.receiver.getCity().getInhabitants().size() >= 10) {
	    	List<Inhabitant> inhabitantAdded = new ArrayList<>();
	    	for (int i = 0; i < 10; i++) {
	            Inhabitant inhabitant;
	            do{
	                inhabitant = this.getReceiver().getCity().getRandomInhabitant();
	            }while(inhabitantAdded.contains(inhabitant) || inhabitant.equals(receiver));
	            inhabitantAdded.add(inhabitant);
	            Letter<ListInhabitants> foolLetter = new FoolLetter(this.receiver, inhabitant, this.getContent());
	            this.receiver.sendLetter(foolLetter);
	        }
    	}else{
    		System.out.println("Not enought inhabitants in the city");
    	}
    }
    
    /**
     * @return the name and the content of the content of the letter
     */
    
    public String toString(){
    	return "Fool letter : " +this.content.getList();
    }
}
