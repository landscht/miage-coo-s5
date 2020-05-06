package content;

/**
 * 
 * @author Gabriel, Tony
 *
 * This class represents the account of an inhabitant with his balance
 */

public class Account {
	
	private float balance;
	
	/**
	 * 
	 * @param balance the initial balance
	 */
	
	public Account(float balance){
		this.balance=balance;
	}
	
	/**
	 * 
	 * @return the current balance of an inhabitant
	 */
	
	public float getBalance() {
		return balance;
	}
	
	/**
	 * credits the balance of an inhabitant of "amount"
	 * 
	 * @param amount the amount to be credited
	 */
	
	public void credit(float amount){
		balance+=amount;
	}
	
	/**
	 * debits the balance of an inhabitant of "amount"
	 * 
	 * @param amount the amount to be debited
	 */
	
	public void debit(float amount){
		balance-=amount;
	}

}
