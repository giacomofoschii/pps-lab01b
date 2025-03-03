package e1;

import e1.API.*;
import e1.factory.BankAccountFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SilverBankAccountTest extends AbstractBankAccountTest{
    public static final int FIRST_WITHDRAW = 200;
    public static final int SECOND_WITHDRAW = 1200;
    private static final int EXPECTED_BALANCE = INITIAL_DEPOSIT - FIRST_WITHDRAW - 1;

    @BeforeEach
    void init() {
        this.account = new BankAccountFactoryImpl().createSilverBankAccount();
    }

    @Test
    void testCanWithdraw() {
        depositAndWithdraw(INITIAL_DEPOSIT, FIRST_WITHDRAW);
        assertEquals(EXPECTED_BALANCE, this.account.getBalance());
    }

    @Test
    void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(SECOND_WITHDRAW));
    }

}
