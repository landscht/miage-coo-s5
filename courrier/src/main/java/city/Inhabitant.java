package city;

import content.Account;
import letter.Letter;

/**
 * 
 * @author Gabriel, Tony
 * 
 * This class represents an inhabitant of a city
 *
 */

public class Inhabitant {
	
	protected City city;
	protected Account bankAccount;
	
	/**
	 * 
	 * @param city the city of the inhabitant
	 * @param bankAccount the bank account of the inhabitant
	 */
	
	public Inhabitant(City city, Account bankAccount){
		this.city=city;
		this.bankAccount=bankAccount;
	}

	public City getCity() {
		return this.city;
	}
	
	/**
	 * The inhabitant sends a letter
	 * 
	 * @param letter the letter that the inhabitant wants to send
	 */
	
	public void sendLetter(Letter<?> letter){
		this.bankAccount.debit(letter.getCost());
		this.city.addLetter(letter);
	}
	
	/**
	 * The inhabitant receives a letter
	 * 
	 * @param letter the letter that the inhabitant receives
	 */
	
	public void receiveLetter(Letter<?> letter){
		letter.action();
	}
	
	/**
	 * 
	 * @return  the bank account of the inhabitant
	 */

	public Account getBankAccount() {
		return this.bankAccount;
	}
	
	/**
	 * @return a description of the inhabitant
	 */
	
	public String toString(){
		return city.getName()+", "+bankAccount.getBalance();
	}

}
