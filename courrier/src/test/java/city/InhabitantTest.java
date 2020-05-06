package city;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import content.Account;
import content.Money;
import content.Text;
import letter.BillOfExchange;
import letter.Letter;
import letter.MockLetter;
import letter.SimpleLetter;

public class InhabitantTest {
	
	private Inhabitant louis;
	private Inhabitant bernard;
	
	@Before
	public void init() {
		City city = new City("Lille");
		Account bankAccount = new Account(500);
		Account bankAccount2 = new Account(1000);
		louis = new Inhabitant(city,bankAccount);
		bernard = new Inhabitant(city,bankAccount2);
		city.addInhabitant(bernard);
		city.addInhabitant(louis);
	}

	@Test
	public void receiveLettertest() {
		
		MockLetter mockLetter = new MockLetter(louis, bernard, new Text("test"));
		louis.receiveLetter(mockLetter);
		assertEquals(1,mockLetter.getCptCallAction());
		
	}
	
	@Test
	public void sendLetterTest() {
		float louisAccountBefore = louis.getBankAccount().getBalance();
		Letter<Text> simpleLetter = new SimpleLetter(louis,bernard,new Text("hi"));
		louis.sendLetter(simpleLetter);
		assertEquals(louis.getBankAccount().getBalance(),louisAccountBefore-simpleLetter.getCost(),0.001);	
	}
	

	
	
	
	

}
