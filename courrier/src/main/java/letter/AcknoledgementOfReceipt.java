package letter;

import city.Inhabitant;
import content.Text;

/**
 * 
 * @author Gabriel, Tony
 * 
 * This class represents an acknoledgement of receipt that an inhabitant sends
 * when he receives a registered letter for example
 * Its a simple letter that has a predefined message
 */

public class AcknoledgementOfReceipt extends SimpleLetter{
	
	/**
	 * 
	 * @param sender the sender of the acknoledgement of receipt
	 * @param receiver the receiver of the acknoledgement of receipt
	 */

	public AcknoledgementOfReceipt(Inhabitant sender, Inhabitant receiver) {
		super(sender, receiver, new Text("The letter has been received"));
	}
	
	/**
	 * @return the name and the content of the letter
	 */
	
	public String toString(){
		return "Acknoledgement of receipt : "+this.getContent();
	}

}
