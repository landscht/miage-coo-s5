package questionnaire;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import answer.MockAnswer;

public class QuestionTest {
	
	private Question question;
	private static MockAnswer answer;
	private static String sentence;
	private static  int points;
	
	@Before
	public void init(){
		question = QuestionTest.createQuestion();
	}

	@Test
	public void isUserAnswerCorrect(){
		assertEquals(answer.getNbCalledIsCorrect(),0);
		question.isUserAnswerCorrect();
		assertEquals(answer.getNbCalledIsCorrect(),1);
	}
	
	@Test
	public void getPointsTest(){
		assertEquals(question.getPoints(),points);
	}
	
	@Test
	public void getAnswerTest(){
		assertSame(answer,question.getAnswer());
	}
	
	@Test
	public void getQuestionTest(){
		assertEquals(sentence,question.getQuestion());
	}
	
	public static Question createQuestion(){
		Question quest;
		sentence = "Quelle est la réponse de la vie ?";
		points = 10;
		answer = new MockAnswer("quarante-deux");
		quest = new Question(sentence,answer,points);
		return quest;
	}
	
	

}
