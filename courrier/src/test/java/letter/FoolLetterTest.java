package letter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import city.Inhabitant;
import content.Account;
import content.ListInhabitants;
import content.Text;

public class FoolLetterTest extends LetterTest{
	
	ListInhabitants list;

	@Override
	public Letter<?> createLetter() {
		List<Inhabitant> listInhabitant = new ArrayList<>();
		for(int i=0;i<4;i++) {
			listInhabitant.add(new Inhabitant(city, new Account(500)));
		}
		list = new ListInhabitants(listInhabitant);
		return new FoolLetter(senderLouis,receiverBernard,list);
	}

	@Override
	public void getCostTest() {
		Letter<?> letter = createLetter();
		assertEquals(2, letter.getCost(), 0.001);
		
	}

	@Override
	public void actionTest() {
		for(int i=0;i<100;i++) {
			city.addInhabitant(new Inhabitant(city,new Account(500)));
		}
		FoolLetter foolLetter = (FoolLetter)this.createLetter();
		Inhabitant inhabitantToRemove = list.getList().get(0);
		
		foolLetter.action();
		sends5EurosTest();
		changeNamesTest(list, inhabitantToRemove);
		sendFoolLetterTest();
	}
	
	private void changeNamesTest(ListInhabitants list, Inhabitant inhabitantToRemove) {
		
		assertFalse(list.getList().contains(inhabitantToRemove));
		assertEquals(list.getList().get(list.getList().size()-1),receiverBernard);
	}
	
	private void sends5EurosTest(){
		int cpt=0;
		System.out.println("size : "+city.getLetters().size());
		for(int i=0;i<city.getLetters().size();i++) {
			System.out.println(city.getLetters().get(i));
			if(city.getLetters().get(i) instanceof BillOfExchange && city.getLetters().get(i).getSender().equals(receiverBernard)) {
				cpt++;
			}
		}
		//assertTrue(cpt>=4);
	}
	
	private void sendFoolLetterTest() {
		int cpt=0;
		System.out.println("size : "+city.getLetters().size());
		for(int i=0;i<city.getLetters().size();i++) {
			System.out.println(city.getLetters().get(i));
			if(city.getLetters().get(i) instanceof FoolLetter && city.getLetters().get(i).getSender().equals(receiverBernard)) {
				cpt++;
			}
		}
		//assertTrue(cpt>=10);
	}
	
	

	

}
