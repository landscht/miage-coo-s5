package letter;

import city.Inhabitant;

/**
 * 
 * @author Gabriel, Tony
 * 
 * This class represents a urgent letter that contains an other letter as content
 *
 */

public class UrgentLetter extends DecoratorLetter{
	
	/**
	 * 
	 * @param sender the sender of the urgent letter
	 * @param receiver the receiver of the urgent letter
	 * @param content the Letter Content of the urgent letter
	 */

	public UrgentLetter(Inhabitant sender, Inhabitant receiver, Letter<?> content) {
		super(sender, receiver, content);
	}
	
	/**
	 * @return the cost of the urgent letter
	 */
	
	public float getCost(){
		return super.getCost()*2;
	}
	
	/**
	 * @return the name and the content of the letter
	 */
	
	public String toString(){
		return "Urgent letter : "+this.getContent();
	}
}

