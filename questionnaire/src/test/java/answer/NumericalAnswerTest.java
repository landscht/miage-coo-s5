package answer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumericalAnswerTest extends AnswerTest{
	
	private NumericalAnswer answer;
	
	@Before
	public void init(){
		answer = (NumericalAnswer)this.createAnswer();
	}

	@Override
	public void acceptTest() {
		assertTrue(answer.accept("687"));
		assertFalse(answer.accept("456854m"));
	}

	@Override
	public Answer<?> createAnswer() {
		return new NumericalAnswer("42");
	}

	

}
