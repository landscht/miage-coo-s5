package answer;

import javax.swing.*;
import java.awt.*;

/**
 * Panel swing for multi answer
 */
public class MultiAnswerPanel extends AnswerPanel<String> {

    private JTextArea jTextArea;
    private JLabel jLabelCorrect;
    private JLabel jLabelIncorrect;

    /**
     *
     * @param ans the value of the answer
     */
    public MultiAnswerPanel(String ans) {
        super(ans);
        this.jTextArea = new JTextArea();
        this.jTextArea.setPreferredSize(new Dimension(130, 20));
        this.setLayout(new FlowLayout());
        this.add(jTextArea);
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
        return this.jTextArea.getText();
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
        this.jTextArea.setText(this.getAns());
        this.jTextArea.setEnabled(false);

    }

    @Override
    public void reload() {
        this.jTextArea.setText("");
        this.jTextArea.setEnabled(true);
        this.jLabelIncorrect.setVisible(false);
        this.jLabelCorrect.setVisible(false);
    }
}
