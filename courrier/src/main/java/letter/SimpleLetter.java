package letter;

import city.Inhabitant;
import content.Text;

/**
 * 
 * @author Gabriel, Tony
 * 
 * This class represents a simple letter, that is a letter that contains a Text Content
 *
 */

public class SimpleLetter extends Letter<Text> {

	/**
	 * 
	 * @param sender the sender of the simple letter
	 * @param receiver the receiver of the simple letter
	 * @param content the content of the simple letter
	 */
	
    public SimpleLetter(Inhabitant sender, Inhabitant receiver, Text content) {
        super(sender, receiver, content);
    }

    /**
     * Does nothing
     */
    
    @Override
    public void action() {}

    /**
     * @return the cost of a simple letter
     */
    
    @Override
    public float getCost() {
        return 2;
    }
    
    /**
	 * @return the name and the content of the letter
	 */
	
	public String toString(){
		return "Simple letter : "+this.getContent();
	}
}
