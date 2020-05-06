package answer;

import javax.swing.*;
import java.awt.*;

/**
 * Panel swing for yes no answer
 */
public class YesNoAnswerPanel extends AnswerPanel<YesNo> {

    private JRadioButton checkBoxYes;
    private JRadioButton checkBoxNo;
    private ButtonGroup buttonGroup;
    private JLabel jLabelCorrect;
    private JLabel jLabelIncorrect;

    /**
     *
     * @param ans the value of the answer
     */
    public YesNoAnswerPanel(String ans) {
        super(ans);
        this.checkBoxYes = new JRadioButton("oui");
        this.checkBoxNo = new JRadioButton("non");
        this.buttonGroup = new ButtonGroup();
        this.setLayout(new FlowLayout());
        buttonGroup.add(checkBoxYes);
        buttonGroup.add(checkBoxNo);
        this.add(checkBoxYes);
        this.add(checkBoxNo);
        this.jLabelCorrect = new JLabel("correct");
        this.jLabelIncorrect = new JLabel("incorrect");
        this.jLabelCorrect.setVisible(false);
        this.jLabelIncorrect.setVisible(false);
        this.add(jLabelCorrect);
        this.add(jLabelIncorrect);
    }

    /**
     *
     * @return value of button group, yes or no
     */
    @Override
    public YesNo getValue() {
        if(checkBoxNo.isSelected()) {
            return YesNo.non;
        }
        return YesNo.oui;
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
        if(this.getAns().equals("oui")) {
            this.checkBoxYes.setSelected(true);
        }else if(this.getAns().equals("non")) {
            this.checkBoxNo.setSelected(true);
        }
        this.checkBoxYes.setEnabled(false);
        this.checkBoxNo.setEnabled(false);
    }

    @Override
    public void reload() {
        this.buttonGroup.clearSelection();
        this.checkBoxYes.setEnabled(true);
        this.checkBoxNo.setEnabled(true);
        this.jLabelIncorrect.setVisible(false);
        this.jLabelCorrect.setVisible(false);
    }
}
