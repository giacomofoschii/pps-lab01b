package e1;

import e1.factory.BankAccountFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BronzeBankAccountTest extends AbstractBankAccountTest {
    public static final int FIRST_WITHDRAW = 200;
    public static final int SECOND_WITHDRAW = 50;
    public static final int THIRD_WITHDRAW = 1200;
    private static final int EXPECTED_BALANCE = INITIAL_DEPOSIT - FIRST_WITHDRAW - 1;

    @BeforeEach
    void init() {
        this.account = new BankAccountFactoryImpl().createBronzeBankAccount();
    }

    @Test
    void testWithdrawUnderFeeBudgetCap() {
        depositAndWithdraw(INITIAL_DEPOSIT, FIRST_WITHDRAW);
        assertEquals(EXPECTED_BALANCE, this.account.getBalance());
    }

    @Test
    void testWithdrawOverFeeBudgetCap() {
        depositAndWithdraw(INITIAL_DEPOSIT, SECOND_WITHDRAW);
        assertEquals(INITIAL_DEPOSIT - SECOND_WITHDRAW, this.account.getBalance());
    }

    @Test
    void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(THIRD_WITHDRAW));
    }
}