package answer;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnswerPanelFactoryTest {

	@Test
	public void buildAnswerTest() {
		String res = "42";
		AnswerPanel<?> answerPanel = AnswerPanelFactory.getInstance().buildAnswerPanel("answer.MockAnswer", res);
		assertTrue(answerPanel instanceof MockAnswerPanel);
	}

}
