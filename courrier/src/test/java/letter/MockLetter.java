package letter;

import city.Inhabitant;
import content.Content;
import content.Text;

/**
 * 
 * @author Gabriel, Tony
 *
 */

public class MockLetter extends Letter<Text> {

    private int cptCallAction;

    /**
     * @param sender   the sender of the letter
     * @param receiver the receiver of the letter
     * @param content  the content of the letter
     */
    public MockLetter(Inhabitant sender, Inhabitant receiver, Text content) {
        super(sender, receiver, content);
        this.cptCallAction = 0;
    }

    @Override
    public void action() {
        this.cptCallAction++;
    }

    @Override
    public float getCost() {
        return 1;
    }
    
    /**
     * 
     * @return the number of called of action
     */

    public int getCptCallAction() {
        return this.cptCallAction;
    }

}
