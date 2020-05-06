package city;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import content.Account;
import content.Text;
import letter.Letter;
import letter.SimpleLetter;

public class CityTest {

	private City city;
	private Inhabitant louis;
	private Inhabitant bernard;
	
	@Before
	public void init() {
		city = new City("Lille");
		Account bankAccount = new Account(500);
		Account bankAccount2 = new Account(1000);
		louis = new Inhabitant(city,bankAccount);
		bernard = new Inhabitant(city,bankAccount2);
		city.addInhabitant(bernard);
		city.addInhabitant(louis);
	}
	
	@Test 
	public void addInhabitantTest() {
		int nbInhabitantBefore = city.getInhabitants().size();
		Account bankAccount = new Account(500);
		Inhabitant clement = new Inhabitant(city,bankAccount);
		city.addInhabitant(clement);
		assertEquals(city.getInhabitants().size(),nbInhabitantBefore+1);
		assertTrue(city.getInhabitants().contains(clement));
	}
	
	@Test
	public void addLetterTest() {
		int nbLettersBefore = city.getLetters().size();
		Letter<Text> letter = new SimpleLetter(louis,bernard,new Text("Hey bernard"));
		city.addLetter(letter);
		assertEquals(city.getLetters().size(),nbLettersBefore+1);
		assertTrue(city.getLetters().contains(letter));
	}
	
	@Test
	public void removeInhabitantTest() {
		Account bankAccount = new Account(500);
		Inhabitant clement = new Inhabitant(city,bankAccount);
		city.addInhabitant(clement);
		int nbInhabitantBefore = city.getInhabitants().size();
		city.removeInhabitant(clement);
		assertEquals(city.getInhabitants().size(),nbInhabitantBefore-1);
		assertFalse(city.getInhabitants().contains(clement));
	}
	
	@Test
	public void distributeLettersTest() {
		Letter<Text> letter = new SimpleLetter(louis,bernard,new Text("Hi bernard"));
		Letter<Text> letter2 = new SimpleLetter(bernard,louis,new Text("Hi louis"));
		Letter<Text> letter3 = new SimpleLetter(louis,bernard,new Text("How are you?"));
		Letter<Text> letter4 = new SimpleLetter(bernard,louis,new Text("Fine"));
		city.addLetter(letter);
		city.addLetter(letter2);
		city.addLetter(letter3);
		city.addLetter(letter4);
		city.distributeLetters();
		assertTrue(city.getLetters().isEmpty());
	}
	
	@Test
	public void getRandomInhabitantWhenNoInhabitantTest(){
		City city = new City("Lyon");
		Inhabitant random = city.getRandomInhabitant();
		assertNull(random);
		assertTrue(city.getInhabitants().isEmpty());
	}
	
	@Test
	public void getRandomInhabitantTest(){
		Inhabitant random = city.getRandomInhabitant();
		assertTrue(city.getInhabitants().contains(random));
	}

}
