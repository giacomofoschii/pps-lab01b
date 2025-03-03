package e1.API;

public interface BankAccount {

    /**
     * Withdraw the amount from the balance of the Bank Account
     *
     * @param amount The amount to withdraw
     */
    void withdraw(int amount);

    /**
     * Deposit the amount into the balance of the Bank Account
     *
     * @param amount The amount to deposit
     */
    void deposit(int amount);

    /**
     * Return the actual balance of the Bank Account
     *
     * @return the balance
     */
    int getBalance();
}
