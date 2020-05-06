package letter;

import city.Inhabitant;

/**
 * 
 * @author Gabriel, Tony
 * 
 * This class represents a registered letter that contains an other Letter as Content
 *
 */

public class RegisteredLetter extends DecoratorLetter{

	/**
	 * 
	 * @param sender the sender of the registered letter
	 * @param receiver the receiver of the registered letter
	 * @param content the Letter Content of the registered letter
	 */
	
	public RegisteredLetter(Inhabitant sender, Inhabitant receiver, Letter<?> content) {
		super(sender, receiver, content);
	}

	/**
	 * sends an acknoledgement of receipt to the sender from the receiver
	 * and does the action of the Content Letter
	 */
	
	@Override
	public void action() {
		SimpleLetter letter = new AcknoledgementOfReceipt(receiver, sender);
		receiver.sendLetter(letter);
		super.action();
	}
	
	/**
	 * @return the cost of the registered letter
	 */
	
	public float getCost(){
		return super.getCost() * (float)1.15;
	}
	
	/**
	 * @return the name and the content of the letter
	 */
	
	public String toString(){
		return "Registered letter : "+this.getContent();
	}

}
