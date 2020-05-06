package content;

/**
 * 
 * @author Gabriel, Tony
 *
 * This class represents the message that can be in a letter
 */

public class Text implements Content {

    private String text;
    
    /**
     * 
     * @param text the content of the message
     */

    public Text(String text) {
        this.text = text;
    }
    
    /**
     * 
     * @return the content of the message
     */

    public String getText() {
        return this.text;
    }
    
    /**
     * @return the content of the message
     */
    
    public String toString(){
    	return this.text;
    }

}
