package content;

/**
 * 
 * @author Gabriel, Tony
 *
 * This class represents the money that can be in a letter
 */

public class Money implements Content{

    private float amount;
    
    /**
     * 
     * @param amount the value of the sum of money
     */

    public Money(float amount) {
        this.amount = amount;
    }
    
    /**
     * 
     * @return the sum of money
     */

    public float getAmount() {
        return this.amount;
    }
    
    /**
     * @return the sum of money in the form of string
     */
    
    public String toString(){
    	return ""+amount;
    }

}
