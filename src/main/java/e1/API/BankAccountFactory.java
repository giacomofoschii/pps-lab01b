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

    /**
     * Creates a BronzeBankAccount
     *
     * @return the BankAccount
     */
    BankAccount createBronzeBankAccount();
}
