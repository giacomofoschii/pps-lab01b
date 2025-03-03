package e1.factory;

import e1.API.*;
import e1.CoreBankAccount;
import e1.decorator.*;

public class BankAccountFactoryImpl implements BankAccountFactory {

    @Override
    public BankAccount createSilverBankAccount(final int fee) {
        return new FeeDecorator(
                new CanWithdrawDecorator(
                        new DecoratorBankAccount(
                                new CoreBankAccount())), fee);
    }
}
