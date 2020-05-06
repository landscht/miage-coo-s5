package answer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Panel swing for multiple choices answer
 */
public class MultipleChoicesAnswerPanel extends AnswerPanel<String> {

    private List<String> list;

    private List<JRadioButton> jRadioButtons;
    private ButtonGroup buttonGroup;
    private JLabel jLabelCorrect;
    private JLabel jLabelIncorrect;

    /**
     *
     * @param value the value of the answer
     */
    public MultipleChoicesAnswerPanel(String value) {
        super((value.split("/"))[0]);
        jRadioButtons = new ArrayList<>();
        buttonGroup = new ButtonGroup();
        list = new ArrayList<>();
                String[] ansTab = value.split("/");
        list = Arrays.asList(ansTab);
        this.setLayout(new FlowLayout());
        for(String s : list) {
            JRadioButton jRadioButton = new JRadioButton(s);
            jRadioButtons.add(jRadioButton);
            this.buttonGroup.add(jRadioButton);
            this.add(jRadioButton);
        }
        this.jLabelCorrect = new JLabel("correct");
        this.jLabelIncorrect = new JLabel("incorrect");
        this.jLabelCorrect.setVisible(false);
        this.jLabelIncorrect.setVisible(false);
        this.add(jLabelCorrect);
        this.add(jLabelIncorrect);
    }

    /**
     *
     * @return the value of the jradiobutton selected
     */
    @Override
    public String getValue() {
        for(JRadioButton j : jRadioButtons) {
            if(j.isSelected()) {
                return j.getText();
            }
        }
        return "";
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
        jRadioButtons.get(0).setSelected(true);
        for(JRadioButton j : jRadioButtons) {
            j.setEnabled(false);
        }
    }

    @Override
    public void reload() {
        this.buttonGroup.clearSelection();
        for(JRadioButton j : jRadioButtons) {
            j.setEnabled(true);
        }
        this.jLabelIncorrect.setVisible(false);
        this.jLabelCorrect.setVisible(false);
    }
}
