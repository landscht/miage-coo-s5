package letter;

import static org.junit.Assert.*;

import org.junit.Test;

import content.Money;

public class UrgentLetterTest extends LetterTest {

	BillOfExchange billOfExchange;

	@Override
	public Letter<?> createLetter() {
		
		billOfExchange = new BillOfExchange(senderLouis,receiverBernard,new Money(20));
		return new UrgentLetter(senderLouis,receiverBernard,billOfExchange);
	}

	@Override
	public void getCostTest() {
		Letter<?> letter = createLetter();
		float price = billOfExchange.getCost()*2;
		assertEquals(price, letter.getCost(), 0.001);
	}

	@Override
	public void actionTest() {
		assertTrue(true);
	}
}
