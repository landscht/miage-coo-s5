package questionnaire;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Gabriel, Congin
 * 
 * This class represents a questionnaire with a list of questions
 *
 */

public class Questionnaire {
	
	private List<Question> questions;
	
	public Questionnaire(){
		this.questions = new ArrayList<>();
	}
	
	/**
	 * 
	 * @param q the new question that has to be added
	 */
	
	public void addQuestion(Question q){
		questions.add(q);
	}

	/**
	 *
	 * @return the list of question
	 */
	public List<Question> getQuestions() {
		return this.questions;
	}
	
	/**
	 * asks the user about the questionnaire
	 */
	
	public void askAll(){
		int nbPoints = 0;
		Scanner sc = new Scanner(System.in);
		
		for(Question q : questions){
			System.out.println(q.getQuestion());
			System.out.print(q.getAnswer().instruction());
			String answer = sc.nextLine();
			while(!q.getAnswer().accept(answer)){
				System.out.println("Incorrect type");
				answer = sc.nextLine();
			}
			q.setUserAnswer(answer);
			if(q.isUserAnswerCorrect()){
				nbPoints+=q.getPoints();
				System.out.println("Good answer!\n+"+q.getPoints()+" points!\n");
			}else{
				System.out.println("Incorrect, the good answer was "+q.getAnswer()+"\n");
			}
		}
		sc.close();
		System.out.println("Your score is "+nbPoints+" points!");
	}

}
