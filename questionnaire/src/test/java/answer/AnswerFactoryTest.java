package answer;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnswerFactoryTest {

	@Test
	public void buildAnswerTest() {
		String res = "42";
		Answer<?> answer = AnswerFactory.getInstance().buildAnswer("answer.MockAnswer", res);
		assertTrue(answer instanceof MockAnswer);
		assertEquals(res,""+answer.getValue());
	}

}
