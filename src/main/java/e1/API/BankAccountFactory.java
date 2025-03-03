package e1.API;

public interface BankAccountFactory {

    /**
     * Creates a SilverBankAccount
     *
     * @return the BankAccount
     */
    BankAccount createSilverBankAccount();

    /**
     * Creates a GoldBankAccount
     *
     * @return the BankAccount
     */
    BankAccount createGoldBankAccount();
}
