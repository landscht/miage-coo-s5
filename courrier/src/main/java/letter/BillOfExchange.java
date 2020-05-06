package letter;

import city.Inhabitant;
import content.Money;
import content.Text;

/**
 * 
 * @author Gabriel, Tony
 * 
 * This class represents a bill of exchange that contains a sum of money
 *
 */

public class BillOfExchange extends Letter<Money> {
	
	/**
	 * 
	 * @param sender the sender of the bill of exchange
	 * @param receiver the receiver of the bill of exchange
	 * @param content the content of the bill of exchange
	 */

    public BillOfExchange(Inhabitant sender, Inhabitant receiver, Money content) {
        super(sender, receiver, content);
    }
    
    /**
     * credits the balance of the receiver of the amount of the Money content
     * credits the balance of the sender of the amount of the Money content
     * sends a thanks letter to the sender from the receiver
     * 
     */

    @Override
    public void action() {
    	SimpleLetter letter = new ThanksLetter(receiver, sender);
        receiver.sendLetter(letter);
        sender.getBankAccount().debit(content.getAmount());
        receiver.getBankAccount().credit(content.getAmount());
    }
    
    /**
     * @return the cost of a bill of exchange
     */

    @Override
    public float getCost() {
        return 1 + content.getAmount()* (float) 0.01;
    }
    
    public String toString(){
    	return "Bill of Exchange : "+this.content;
    }
}
