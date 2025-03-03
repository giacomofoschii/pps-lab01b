package e1;

import e1.decorator.CanWithdrawDecorator;
import e1.decorator.DecoratorBankAccount;
import e1.decorator.FeeDecorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {
    public static final int EMPTY_BALANCE = 0;
    public static final int SILVER_FEE = 1;
    public static final int INITIAL_DEPOSIT = 1000;
    public static final int FIRST_WITHDRAW = 200;
    public static final int SECOND_WITHDRAW = 1200;
    private DecoratorBankAccount account;

    @BeforeEach
    void init() {
        this.account = new FeeDecorator(
                new CanWithdrawDecorator(
                        new DecoratorBankAccount(
                                new CoreBankAccount())), SILVER_FEE);

    }

    @Test
    public void testInitiallyEmpty() {
        assertEquals(EMPTY_BALANCE, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        this.account.deposit(INITIAL_DEPOSIT);
        assertEquals(INITIAL_DEPOSIT, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        this.account.deposit(INITIAL_DEPOSIT);
        this.account.withdraw(FIRST_WITHDRAW);
        assertEquals(799, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(SECOND_WITHDRAW));
    }

}
