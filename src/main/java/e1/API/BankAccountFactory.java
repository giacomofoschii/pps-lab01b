package e1.API;

public interface BankAccountFactory {

    /**
     * Creates a SilverBankAccount with the relative fee
     *
     * @return the SilverBankAccount
     */
    BankAccount createSilverBankAccount();
}
