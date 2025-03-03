package e1.decorator;

import e1.API.BankAccount;

public class FeeDecorator extends DecoratorBankAccount {

    private final int fee;

    public FeeDecorator(final BankAccount account, final int fee) {
        super(account);
        this.fee = fee;
    }

    @Override
    public void withdraw(int amount) {
        super.withdraw(amount + fee);
    }
}
