package answer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class YesNoAnswerTest extends AnswerTest{
	
	private YesNoAnswer answer;
	
	@Before
	public void init(){
		answer = (YesNoAnswer)this.createAnswer();
	}
	
	@Override
	public void acceptTest() {
		assertTrue(answer.accept("non"));
		assertTrue(answer.accept("oui"));
		assertTrue(answer.accept("oUi"));
		assertTrue(answer.accept("noN"));
		assertFalse(answer.accept("nonn"));
		assertFalse(answer.accept("bonjour monsieur"));
	}

	@Override
	public Answer<?> createAnswer() {
		return new YesNoAnswer("oui");
	}

}
