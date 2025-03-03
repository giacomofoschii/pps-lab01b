package e1.decorator;

import e1.API.BankAccount;

public class ConditionalFeeDecorator extends DecoratorBankAccount{

    private final int fee;
    private final int budgetCap;

    public ConditionalFeeDecorator(final int fee, final int budgetCap, final BankAccount account) {
        super(account);
        this.budgetCap = budgetCap;
        this.fee = fee;
    }

    @Override
    public void withdraw(int amount) {
        if (amount >= budgetCap) {
            super.withdraw(amount + fee);
        } else {
            super.withdraw(amount);
        }
    }
}
