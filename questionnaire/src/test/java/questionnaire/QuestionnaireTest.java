package questionnaire;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuestionnaireTest {
	
	private Questionnaire questionnaire;

	@Before
	public void init(){
		questionnaire = new Questionnaire();
	}

	@Test
	public void AddQuestionTest() {
		int nbQuestionsBefore = questionnaire.getQuestions().size();
		questionnaire.addQuestion(QuestionTest.createQuestion());
		assertEquals(nbQuestionsBefore+1,questionnaire.getQuestions().size());
	}
}
