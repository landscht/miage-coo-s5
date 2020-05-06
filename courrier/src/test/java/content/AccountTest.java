package content;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    private Account account;

    @Before
    public void init() {
        this.account = new Account(100);
    }

    @Test
    public void credit() {
        float sommeCredit = 50;
        float accountBefore = account.getBalance();
        account.credit(sommeCredit);
        assertEquals(account.getBalance(), accountBefore+sommeCredit,0.001);
    }

    @Test
    public void debit() {
        float sommeDebit = 50;
        float accountBefore = account.getBalance();
        account.debit(sommeDebit);
        assertEquals(account.getBalance(), accountBefore-sommeDebit,0.001);
    }
}