package answer;

import javax.swing.*;
import java.awt.*;

/**
 * Panel swing for numerical answer
 */
public class NumericalAnswerPanel extends AnswerPanel<String> {

    private JSpinner spinner;
    private JLabel jLabelCorrect;
    private JLabel jLabelIncorrect;

    /**
     *
     * @param ans the value of the answer
     */
    public NumericalAnswerPanel(String ans) {
        super(ans);
        this.spinner = new JSpinner();
        this.setLayout(new FlowLayout());
        this.add(spinner);
        this.jLabelCorrect = new JLabel("correct");
        this.jLabelIncorrect = new JLabel("incorrect");
        this.jLabelCorrect.setVisible(false);
        this.jLabelIncorrect.setVisible(false);
        this.add(jLabelCorrect);
        this.add(jLabelIncorrect);
    }

    /**
     *
     * @return the value of the spinner
     */
    @Override
    public String getValue() {
        return String.valueOf(spinner.getValue());
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
        this.spinner.setValue(Integer.valueOf(this.getAns()));
        this.spinner.setEnabled(false);
    }

    @Override
    public void reload() {
        this.spinner.setValue(0);
        this.spinner.setEnabled(true);
        this.jLabelIncorrect.setVisible(false);
        this.jLabelCorrect.setVisible(false);
    }


}
