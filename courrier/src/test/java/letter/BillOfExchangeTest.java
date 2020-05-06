package letter;

import static org.junit.Assert.*;

import city.Inhabitant;
import content.Text;
import org.junit.Test;

import content.Money;

public class BillOfExchangeTest  extends LetterTest{
	
	private float contentMoney = 20;
	
	@Override
	public Letter<Money> createLetter() {
		
		return new BillOfExchange(senderLouis,receiverBernard,new Money(contentMoney));
	}

	@Override
	public void getCostTest() {
		Letter<Money> letter = this.createLetter();
		float price = 1 + letter.getContent().getAmount()*(float)0.01;
		assertEquals(letter.getCost(),price,0.001);
	}

	@Override
	public void actionTest() {
		Letter<Money> billOfExchangeTest = this.createLetter();
		float accountBeforeSender = senderLouis.getBankAccount().getBalance();
		float accountBeforeReceiver = receiverBernard.getBankAccount().getBalance();
		int callCptSender = receiverBernard.getSenderCptCall();
		billOfExchangeTest.action();
		assertEquals(accountBeforeSender-billOfExchangeTest.getContent().getAmount(), senderLouis.getBankAccount().getBalance(), 0.001);
		assertEquals(accountBeforeReceiver+billOfExchangeTest.getContent().getAmount(), receiverBernard.getBankAccount().getBalance(), 0.001);
		assertEquals(callCptSender+1, receiverBernard.getSenderCptCall());
	}


}
