package e1.factory;

import e1.API.*;
import e1.CoreBankAccount;
import e1.decorator.*;

public class BankAccountFactoryImpl implements BankAccountFactory {
    public static final int SILVER_FEE = 1;
    public static final int GOLD_FEE = 0;
    public static final int NO_OVERDRAFT = 0;
    public static final int GOLD_OVERDRAFT = 500;

    @Override
    public BankAccount createSilverBankAccount() {
        return new FeeDecorator(SILVER_FEE,
                new CanWithdrawDecorator(
                        NO_OVERDRAFT, new DecoratorBankAccount(
                                new CoreBankAccount())));
    }

    @Override
    public BankAccount createGoldBankAccount() {
        return new FeeDecorator(GOLD_FEE,
                new CanWithdrawDecorator(GOLD_OVERDRAFT,
                        new DecoratorBankAccount(
                                new CoreBankAccount())));
    }
}
