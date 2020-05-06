package answer;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents an answer of a question
 * @param <T> The type of answer
 */
public abstract class AnswerPanel<T> extends JPanel {

    private String ans;

    public AnswerPanel(String ans) {
        super(new FlowLayout());
        this.ans = ans;
    }

    public String getAns() {
        return this.ans;
    }

    public abstract T getValue();

    public abstract void setCorrection(boolean isCorrect);

    public abstract void reload();

}
