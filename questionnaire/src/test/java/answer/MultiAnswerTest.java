package answer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MultiAnswerTest extends AnswerTest{
	
	private MultiAnswer answer;
	
	@Before
	public void init(){
		answer = (MultiAnswer)this.createAnswer();
	}
	
	@Override
	public void acceptTest() {
		assertTrue(true);
	}
	
	@Test
	public void isCorrectTest(){
		assertTrue(answer.isCorrect("rouge"));
		assertTrue(answer.isCorrect("vert"));
		assertTrue(answer.isCorrect("bleu"));
		assertFalse(answer.isCorrect("violet"));
	}

	@Override
	public Answer<?> createAnswer() {
		return new MultiAnswer("rouge;bleu;vert");
	}




}
