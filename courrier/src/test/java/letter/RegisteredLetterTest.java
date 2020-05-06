package letter;

import static org.junit.Assert.*;

import org.junit.Test;

import content.Text;

public class RegisteredLetterTest extends LetterTest{

	private SimpleLetter simpleLetter;
	
	@Override
	public Letter<?> createLetter() {
		simpleLetter = new SimpleLetter(senderLouis,receiverBernard,new Text("Hi"));
		return new RegisteredLetter(senderLouis,receiverBernard,simpleLetter);
	}

	@Override
	public void getCostTest() {
		Letter<?> letter = this.createLetter();
		float price = (float)1.15 * simpleLetter.getCost();
		assertEquals(price,letter.getCost(),0.001);
	}

	@Override
	public void actionTest() {
		MockLetter mockLetter = new MockLetter(senderLouis, receiverBernard, new Text("test"));
		Letter<?> registeredLetterTest = new RegisteredLetter(senderLouis, receiverBernard, mockLetter);
		int cptCallSender = receiverBernard.getSenderCptCall();
		int cptCallAction = mockLetter.getCptCallAction();
		registeredLetterTest.action();
		assertEquals(cptCallSender+1, receiverBernard.getSenderCptCall());
		assertEquals(cptCallAction+1, mockLetter.getCptCallAction());
	}


}
