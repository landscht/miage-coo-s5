package questionnaire;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import answer.AnswerFactory;
import answer.AnswerPanelFactory;
import main.WindowQuestionnaire;

import javax.swing.*;

/**
 * 
 * @author Gabriel, Tony
 * 
 * This class is a factory design pattern to easily create Questionnaire Object 
 *
 */

public class QuestionnaireFactory {
	
	private static QuestionnaireFactory questionnaireFactory = null;

    private QuestionnaireFactory() {}
    
    /**
     * Singleton design pattern
     * 
     * @return the only instance of the factory
     */

    public static QuestionnaireFactory getInstance() {
        if(questionnaireFactory == null)
            questionnaireFactory = new QuestionnaireFactory();
        return questionnaireFactory;
    }
    
    /**
     * 
     * @param text the formulated question
     * @param answer the answer of the question
     * @param points the number of points that you win if you answer correctly
	 * @param className name of type class answer
     * @return the created question
     * @throws IOException if the format is not respected
     */
    
    public Question createQuestion(String text, String answer, String points, String className) throws IOException{
    	try {
			int nbPoints = Integer.parseInt(points);
			return new Question(text, AnswerFactory.getInstance().buildAnswer(className,answer),nbPoints, AnswerPanelFactory.getInstance().buildAnswerPanel(className,answer));
		} catch (NumberFormatException e) {
			throw new IOException("bad format");
		}
    	
    }
    
    /**
     * 
     * @param fileName the name of the file that contains the questions
     * @return the created questionnaire
     * @throws IOException if the format is not respected
     */
    
    public Questionnaire createQuestionnaire(String fileName) throws IOException {
    	Questionnaire questionnaire = new Questionnaire();

		File source = new File(fileName);
    	BufferedReader in = null;
    	try {
			in = new BufferedReader(new FileReader(source));
			String text;
			while((text=in.readLine())!=null){
				String answer = in.readLine();
				int i;
				for(i=0;answer.charAt(i)!=' ';i++){}
				String className = "answer."+answer.substring(0,i);
				answer = answer.substring(i+1,answer.length());
				String nbPoints = in.readLine();
				if(answer == null || nbPoints == null){
					throw new IOException("bad format");
				}
				Question question = this.createQuestion(text, answer, nbPoints, className);
				questionnaire.addQuestion(question);
			}
		} catch (FileNotFoundException e) {
			throw new IOException("e");
		}
    	finally{
    		in.close();
    	}
    	return questionnaire;
    }

}
