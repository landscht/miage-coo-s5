package answer;

import javax.swing.*;

/**
 * 
 * @author Gabriel, Tony
 *
 * @param <T> the type of the answer
 * 
 * This class represents an answer of a question
 */

public abstract class Answer<T> {

    protected T value;
    
    /**
     * 
     * @param value the value of the answer
     */

    public Answer(T value) {
        this.value = value;
    }
    
    /**
     * 
     * @return the value of the answer
     */

    public T getValue() {
        return this.value;
    }
    
    /**
     * 
     * @param value the proposed answer
     * @return true if the answer is correct
     */

    public boolean isCorrect(String value) {
        return value.equalsIgnoreCase(""+this.value);
    }
    
    /**
     *
     * @return false if 
     */

    public String toString() {
        return ""+value;
    }
    
    /**
     * 
     * @return the type of the question
     */

    public abstract String instruction();
    
    /**
     * 
     * @param value the proposed answer
     * @return true if the type of the value is accepted
     */

    public abstract boolean accept(String value);
}
