package letter;

import static org.junit.Assert.*;

import org.junit.Test;

import content.Text;

public class SimpleLetterTest extends LetterTest {

	@Override
	public Letter<Text> createLetter(){
		
		return new SimpleLetter(senderLouis,receiverBernard,new Text("Hey"));
	}

	@Override
	public void getCostTest() {
		Letter<Text> letter = createLetter();
		assertEquals(2, letter.getCost(), 0.001);
	}

	@Override
	public void actionTest() {
		assertTrue(true);
	}

}
