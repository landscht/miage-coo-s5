package letter;

import city.Inhabitant;

/**
 * 
 * @author Gabriel, Tony
 * 
 * This class is a decorator design pattern, this allows to easily
 * manipulate a letter that has a letter as Content
 *
 */

public abstract class DecoratorLetter extends Letter<Letter<?>>{
	
	/**
	 * 
	 * @param sender the sender of the letter
	 * @param receiver the receiver of the letter
	 * @param content the Letter Content of the letter
	 */

	public DecoratorLetter(Inhabitant sender, Inhabitant receiver, Letter<?> content) {
		super(sender, receiver, content);
	}
	
	/**
	 * Does the action of the Content Letter once received
	 * 
	 */

	@Override
	public void action(){
		content.action();
	}
	
	/**
	 * @return the cost of the Content Letter
	 */

	@Override
	public float getCost() {
		return content.getCost();
	}

}
