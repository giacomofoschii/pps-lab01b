package e1.factory;

import e1.API.*;
import e1.CoreBankAccount;
import e1.decorator.*;

public class BankAccountFactoryImpl implements BankAccountFactory {
    public static final int SILVER_FEE = 1;
    public static final int GOLD_FEE = 0;
    public static final int BRONZE_FEE = 1;
    public static final int NO_OVERDRAFT = 0;
    public static final int GOLD_OVERDRAFT = 500;
    public static final int BRONZE_BUDGET_CAP = 100;

    @Override
    public BankAccount createSilverBankAccount() {
        return new WithdrawOverdraftDecorator(NO_OVERDRAFT,
                new MandatoryFeeDecorator(SILVER_FEE,
                        new DecoratorBankAccount(
                                new CoreBankAccount())));
    }

    @Override
    public BankAccount createGoldBankAccount() {
        return new WithdrawOverdraftDecorator(GOLD_OVERDRAFT,
                new MandatoryFeeDecorator(GOLD_FEE,
                        new DecoratorBankAccount(
                                new CoreBankAccount())));
    }

    @Override
    public BankAccount createBronzeBankAccount() {
        return new WithdrawOverdraftDecorator(NO_OVERDRAFT,
                new ConditionalFeeDecorator(BRONZE_FEE, BRONZE_BUDGET_CAP,
                        new DecoratorBankAccount(
                                new CoreBankAccount())));
    }
}
