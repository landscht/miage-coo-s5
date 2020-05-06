package letter;

import city.Inhabitant;
import content.Text;

/**
 * 
 * @author Gabriel, Tony
 * 
 * This class represents a thanks letter that an inhabitant sends
 * when he receives a bill of exchange letter for example
 * Its a simple letter that has a predefined message
 */

public class ThanksLetter extends SimpleLetter{

	/**
	 * 
	 * @param sender the sender of the thanks letter
	 * @param receiver the receiver of the thanks letter
	 */
	
	public ThanksLetter(Inhabitant sender, Inhabitant receiver) {
		super(sender, receiver, new Text("Thank you for your bill of exchange!"));
	}
	
	/**
	 * @return the name and the content of the letter
	 */
	
	public String toString(){
		return "Thanks letter : "+this.getContent();
	}

}
