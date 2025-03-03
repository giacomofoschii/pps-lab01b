package e1.decorator;

import e1.API.BankAccount;

public class MandatoryFeeDecorator extends DecoratorBankAccount {

    private final int fee;

    public MandatoryFeeDecorator(final int fee, final BankAccount account) {
        super(account);
        this.fee = fee;
    }

    @Override
    public void withdraw(int amount) {
        super.withdraw(amount + fee);
    }
}
