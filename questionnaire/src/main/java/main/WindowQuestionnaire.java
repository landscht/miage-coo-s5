package main;

import questionnaire.Question;
import questionnaire.Questionnaire;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Interface UI swing for the questionnaire
 */
public class WindowQuestionnaire extends JFrame {

    private Questionnaire questionnaire;
    private JButton buttonValidate;
    private JButton buttonReset;

    /**
     *
     * @param questionnaire to be displayed
     */
    public WindowQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
        this.setContentPane(buildWindow());
        this.pack();
        this.setVisible(true);
    }

    /**
     *
     * @return the window build with the questionnaire
     */
    private JPanel buildWindow() {
        JPanel body = new JPanel();
        body.setLayout(new GridLayout(0,1));
        for(Question q: questionnaire.getQuestions()) {
            body.add(q.createPanel());
        }
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new FlowLayout());
        JScrollPane jScrollPane = new JScrollPane(body);
        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        jScrollPane.setPreferredSize(new Dimension((int)dimension.getWidth(), (int)dimension.getHeight()-100));
        panelMain.add(jScrollPane);
        buttonValidate = new JButton("Validate");
        buttonReset = new JButton("Rejouer");
        buttonReset.setVisible(false);
        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reload();
            }
        });
        buttonValidate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getCorrection();
            }
        });
        body.add(buttonValidate);
        body.add(buttonReset);
        return panelMain;
    }

    public void getCorrection() {
        buttonValidate.setEnabled(false);
        buttonReset.setVisible(true);
        int nbPoint = 0;
        for(Question q : questionnaire.getQuestions()) {
            String answer = String.valueOf(q.getAnswerPanel().getValue());
            q.setUserAnswer(answer);
            if(q.isUserAnswerCorrect()) {
                nbPoint += q.getPoints();
                q.getAnswerPanel().setCorrection(true);
            }else{
                q.getAnswerPanel().setCorrection(false);
            }
        }
        JOptionPane.showMessageDialog(this, "Vous avez obtenu " + nbPoint + " points");
    }

    public void reload() {
        for(Question q : questionnaire.getQuestions()) {
            q.getAnswerPanel().reload();
        }
        this.buttonValidate.setEnabled(true);
        this.buttonReset.setVisible(false);
    }
}
