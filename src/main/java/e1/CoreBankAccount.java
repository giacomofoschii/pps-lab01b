package e1;

import e1.API.BankAccount;

public class CoreBankAccount implements BankAccount {

    private int balance;

    public CoreBankAccount() {
        this.balance = 0;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

    @Override
    public void deposit(int amount) {
        this.balance = this.balance + amount;
    }

    @Override
    public void withdraw(int amount) {
        this.balance = this.balance - amount;
    }
}
