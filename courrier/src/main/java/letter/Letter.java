package letter;

import city.Inhabitant;
import content.Content;

/**
 * 
 * @author Gabriel, Tony
 *
 * @param <T> the type of the Content
 * 
 * This class represents a letter with its receiver, its sender and its content
 * 
 */

public abstract class Letter<T extends Content> implements Content {

    protected Inhabitant sender;
    protected Inhabitant receiver;
    protected T content;
    
    /**
     * 
	 * @param sender the sender of the letter
	 * @param receiver the receiver of the letter
	 * @param content the content of the letter
     */

    public Letter(Inhabitant sender, Inhabitant receiver, T content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }
    
    /**
     * 
     * @return the sender of the letter
     */

    public Inhabitant getSender() {
        return this.sender;
    }
    
    /**
     * 
     * @return the receiver of the letter
     */

    public Inhabitant getReceiver() {
        return this.receiver;
    }
    
    /**
     * 
     * @return the content of the letter
     */

    public T getContent() {
        return this.content;
    }
   
    /**
     * Does the action of the letter once received
     */

    public abstract void action();
    
    /**
     * 
     * @return the cost of the letter
     */
    
    public abstract float getCost();

}
