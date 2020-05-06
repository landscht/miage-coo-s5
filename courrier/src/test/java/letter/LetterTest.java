package letter;

import static org.junit.Assert.*;

import city.MockInhabitant;
import org.junit.Before;
import org.junit.Test;

import city.City;
import city.Inhabitant;
import content.Account;

public abstract class LetterTest {
	
	protected City city;
	protected MockInhabitant senderLouis;
	protected MockInhabitant receiverBernard;
	
	@Before
	public void init() {
		city = new City("Lille");
		Account bankAccount = new Account(500);
		Account bankAccount2 = new Account(1000);
		senderLouis = new MockInhabitant(city,bankAccount);
		receiverBernard = new MockInhabitant(city,bankAccount2);
		city.addInhabitant(receiverBernard);
		city.addInhabitant(senderLouis);
	}
	
	public abstract Letter<?> createLetter();
	
	@Test
	public abstract void getCostTest();

	@Test
	public abstract void actionTest();
	
	@Test
	public void getSenderReceiverTest() {
		Letter<?> letter = this.createLetter();
		assertEquals(letter.getReceiver(),receiverBernard);
		assertEquals(letter.getSender(),senderLouis);
	}

	

}
