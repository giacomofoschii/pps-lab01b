package e1;

import e1.factory.BankAccountFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends AbstractBankAccountTest {
    public static final int FIRST_WITHDRAW = 200;
    public static final int SECOND_WITHDRAW = 1200;
    public static final int THIRD_WITHDRAW = 1600;

    @BeforeEach
    void init() {
        this.account = new BankAccountFactoryImpl().createGoldBankAccount();
    }

    @Test
    void testCanWithdraw() {
        depositAndWithdraw(INITIAL_DEPOSIT, FIRST_WITHDRAW);
        assertEquals(INITIAL_DEPOSIT - FIRST_WITHDRAW, this.account.getBalance());
    }

    @Test
    void testCanWithdrawWithOverdraft(){
        depositAndWithdraw(INITIAL_DEPOSIT, SECOND_WITHDRAW);
        assertEquals(INITIAL_DEPOSIT - SECOND_WITHDRAW, this.account.getBalance());
    }

    @Test
    void testCannotWithdrawMoreThanOverdraft() {
        this.account.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(THIRD_WITHDRAW));
    }
}
