package questionnaire;

import answer.Answer;
import answer.AnswerPanel;

import javax.swing.*;
import java.awt.*;

/**
 * 
 * @author Gabriel, Tony
 * 
 * This class represents a question
 *
 */

public class Question {
	
	private String question;
	private Answer<?> answer;
	private String userAnswer;
	private int points;
	private AnswerPanel<?> answerPanel;
	
	/**
	 * 
	 * @param question the formulated question
	 * @param answer the answer of this question
	 * @param points the number of points that you win if you answer correctly
	 * @param answerPanel the panel of the question
	 */
	
	public Question(String question, Answer<?> answer, int points, AnswerPanel<?> answerPanel) {
		this.question = question;
		this.answer = answer;
		this.points = points;
		this.answerPanel = answerPanel;
	}
	
	/**
	 * 
	 * @param question the formulated question
	 * @param answer the answer of this question
	 * @param points the number of points that you win if you answer correctly
	 */
	
	public Question(String question, Answer<?> answer, int points) {
		this.question = question;
		this.answer = answer;
		this.points = points;
	}
	
	/**
	 * 
	 * @return the formulated question
	 */

	public String getQuestion() {
		return question;
	}
	
	/**
	 * 
	 * @return the answer
	 */

	public Answer<?> getAnswer() {
		return answer;
	}

	/**
	 *
	 * @return the panel of the question
	 */
	public AnswerPanel getAnswerPanel() {
		return answerPanel;
	}
	
	/**
	 * 
	 * @param answer the new answer
	 */

	public void setAnswer(Answer<?> answer) {
		this.answer = answer;
	}
	
	/**
	 * 
	 * @param userAnswer the user answer of the question
	 */
	
	public void setUserAnswer(String userAnswer){
		this.userAnswer=userAnswer;
	}
	
	public boolean isUserAnswerCorrect(){
		return answer.isCorrect(userAnswer);
	}
	
	/**
	 * 
	 * @return the number of points that you win if you answer correctly
	 */

	public int getPoints() {
		return points;
	}

	public JPanel createPanel() {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new FlowLayout());
		JLabel label = new JLabel();
		label.setText(this.getQuestion());
		jPanel.add(label);
		jPanel.add(answerPanel);
		return jPanel;
	}

}
