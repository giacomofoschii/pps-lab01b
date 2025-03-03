package e1.decorator;

import e1.API.BankAccount;

public class CanWithdrawDecorator extends DecoratorBankAccount {
    private final int overdraft;

    public CanWithdrawDecorator(final int overdraft, BankAccount account) {
        super(account);
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(int amount) {
        if (this.getBalance() + this.overdraft < amount){
            throw new IllegalStateException();
        }
        super.withdraw(amount);
    }
}
