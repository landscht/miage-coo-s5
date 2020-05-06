package answer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MultipleChoicesAnswerTest extends AnswerTest{

	private MultipleChoicesAnswer answer;
	
	@Before
	public void init(){
		answer = (MultipleChoicesAnswer)this.createAnswer();
	}

	@Override
	public void acceptTest() {
		assertTrue(answer.accept("rouge"));
		assertTrue(answer.accept("vert"));
		assertTrue(answer.accept("bleu"));
		assertFalse(answer.accept("violet"));
	}

	@Override
	public Answer<?> createAnswer() {
		return new MultipleChoicesAnswer("rouge/bleu/vert");
	}

}
