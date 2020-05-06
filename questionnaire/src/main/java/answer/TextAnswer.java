package answer;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author Gabriel, Tony
 * 
 * This class represents the text answers
 *
 */

public class TextAnswer extends Answer<String> {
	
	/**
	 * 
	 * @param text the value of the answer
	 */

    public TextAnswer(String text) {
        super(text);
    }

    @Override
    public String instruction() {
        return "(symbolique) ";
    }

    @Override
    public boolean accept(String value) {
        return true;
    }
}
