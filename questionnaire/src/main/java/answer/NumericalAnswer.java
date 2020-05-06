package answer;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author Gabriel, Tony
 *
 * This class represents the numerical answers
 */

public class NumericalAnswer extends Answer<String> {
	
	/**
	 * 
	 * @param value the value of the answer
	 */

    public NumericalAnswer(String value) {
        super(value);
    }

    @Override
    public String instruction() {
        return "(numerique) ";
    }

    @Override
    public boolean accept(String value) {
    	return value.matches("[0-9]+");
    }
}
