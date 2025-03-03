package e1.factory;

import e1.API.*;
import e1.CoreBankAccount;
import e1.decorator.*;

public class BankAccountFactoryImpl implements BankAccountFactory {
    public static final int SILVER_FEE = 1;

    @Override
    public BankAccount createSilverBankAccount() {
        return new FeeDecorator(SILVER_FEE,
                new CanWithdrawDecorator(
                        new DecoratorBankAccount(
                                new CoreBankAccount())));
    }
}
