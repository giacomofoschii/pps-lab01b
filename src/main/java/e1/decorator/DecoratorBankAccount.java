package e1.decorator;

import e1.API.BankAccount;

public class DecoratorBankAccount implements BankAccount {

    private final BankAccount account;

    public DecoratorBankAccount(final BankAccount account) {
        this.account = account;
    }

    @Override
    public void withdraw(int amount) {
        this.account.withdraw(amount);
    }

    @Override
    public void deposit(int amount) {
        this.account.deposit(amount);
    }

    @Override
    public int getBalance() {
        return this.account.getBalance();
    }
}
