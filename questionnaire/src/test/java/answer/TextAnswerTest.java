package answer;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextAnswerTest extends AnswerTest{

	@Override
	public void acceptTest() {
		assertTrue(true);
	}

	@Override
	public Answer<?> createAnswer() {
		return new TextAnswer("quarante-deux");
	}

}
