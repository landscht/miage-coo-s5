package city;

import content.Account;
import letter.Letter;

public class MockInhabitant extends Inhabitant {

    private int senderCptCall;

    /**
     * @param city        the city of the inhabitant
     * @param bankAccount the bank account of the inhabitant
     */
    public MockInhabitant(City city, Account bankAccount) {
        super(city, bankAccount);
        this.senderCptCall = 0;
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
        this.senderCptCall++;
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

    public int getSenderCptCall() {
        return this.senderCptCall;
    }

    /**
     * @return a description of the inhabitant
     */

    public String toString(){
        return city.getName()+", "+bankAccount.getBalance();
    }
}
