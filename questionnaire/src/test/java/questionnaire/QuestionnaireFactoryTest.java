package questionnaire;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class QuestionnaireFactoryTest {

	@Test
	public void createQuestionTest() throws IOException {
		String text = "ouais ouais ?";
		String answer = "ouais ouais!";
		String points = "10";
		Question question = QuestionnaireFactory.getInstance().createQuestion(text, answer, points, "answer.MockAnswer");
		assertEquals(question.getPoints(),Integer.parseInt(points));
		assertEquals(question.getQuestion(),text);
	}
}
