package e1;

import e1.API.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractBankAccountTest {
    public static final int EMPTY_BALANCE = 0;
    public static final int INITIAL_DEPOSIT = 1000;

    protected BankAccount account;

    @BeforeEach
    void init() {
        this.account = createBankAccount();
    }

    protected abstract BankAccount createBankAccount();

    @Test
    public void testInitiallyEmpty() {
        assertEquals(EMPTY_BALANCE, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(INITIAL_DEPOSIT);
        assertEquals(INITIAL_DEPOSIT, this.account.getBalance());
    }
}
