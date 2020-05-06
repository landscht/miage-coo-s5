package answer;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class AnswerTest {
	
	@Test
	public abstract void acceptTest();
	
	public abstract Answer<?> createAnswer();
	
	@Test
	public void isCorrectTest(){
		String res = "quarante-deux";
		String resMaj = "QuArAnTe-DeuX";
		Answer<String> answer = new MockAnswer(res);
		assertTrue(answer.isCorrect(res));
		assertTrue(answer.isCorrect(resMaj));
	}
}
