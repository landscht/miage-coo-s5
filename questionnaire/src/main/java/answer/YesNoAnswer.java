package answer;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author Gabriel, Tony
 * 
 * This class represents the yes/no answers
 *
 */

public class YesNoAnswer extends Answer<YesNo> {

	/**
	 * 
	 * @param value the value of the answer
	 */	
	
    public YesNoAnswer(String value) {
        super(YesNo.valueOf(value));
    }

    @Override
    public String instruction() {
        return "(oui/non) ";
    }

    @Override
    public boolean accept(String value) {
        return value.equalsIgnoreCase("oui") || value.equalsIgnoreCase("non");
    }

}
