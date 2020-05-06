package answer;

import javax.swing.*;
import java.awt.*;

/**
 * Panel swing for text answer
 */
public class TextAnswerPanel extends AnswerPanel<String> {

    private JTextArea textArea;
    private JLabel jLabelCorrect;
    private JLabel jLabelIncorrect;

    /**
     *
     * @param ans the value of the answer
     */
    public TextAnswerPanel(String ans) {
        super(ans);
        this.textArea = new JTextArea();
        this.textArea.setPreferredSize(new Dimension(130, 20));
        this.setLayout(new FlowLayout());
        this.add(textArea);
        this.jLabelCorrect = new JLabel("correct");
        this.jLabelIncorrect = new JLabel("incorrect");
        this.jLabelCorrect.setVisible(false);
        this.jLabelIncorrect.setVisible(false);
        this.add(jLabelCorrect);
        this.add(jLabelIncorrect);
    }

    /**
     *
     * @return the value of the text field
     */
    @Override
    public String getValue() {
        return this.textArea.getText();
    }

    @Override
    public void setCorrection(boolean isCorrect) {
        if(isCorrect) {
            this.jLabelIncorrect.setVisible(false);
            this.jLabelCorrect.setVisible(true);
        }else{
            this.jLabelCorrect.setVisible(false);
            this.jLabelIncorrect.setVisible(true);
        }
        this.textArea.setText(this.getAns());
        this.textArea.setEnabled(false);
    }

    @Override
    public void reload() {
        this.textArea.setText("");
        this.textArea.setEnabled(true);
        this.jLabelIncorrect.setVisible(false);
        this.jLabelCorrect.setVisible(false);
    }


}
