package e1;

import e1.API.BankAccount;
import e1.factory.BankAccountFactoryImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest extends AbstractBankAccountTest {
    public static final int FIRST_WITHDRAW = 200;
    public static final int SECOND_WITHDRAW = 1200;
    public static final int THIRD_WITHDRAW = 1600;

    @Override
    protected BankAccount createBankAccount() {
        return this.account = new BankAccountFactoryImpl().createGoldBankAccount();
    }

    @Test
    void testCanWithdraw() {
        this.account.deposit(INITIAL_DEPOSIT);
        this.account.withdraw(FIRST_WITHDRAW);
        assertEquals(INITIAL_DEPOSIT - FIRST_WITHDRAW, this.account.getBalance());
    }

    @Test
    void testCanWithdrawWithOverdraft(){
        this.account.deposit(INITIAL_DEPOSIT);
        this.account.withdraw(SECOND_WITHDRAW);
        assertEquals(INITIAL_DEPOSIT - SECOND_WITHDRAW, this.account.getBalance());
    }

    @Test
    void testCannotWithdrawMoreThanOverdraft() {
        this.account.deposit(INITIAL_DEPOSIT);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(THIRD_WITHDRAW));
    }
}
