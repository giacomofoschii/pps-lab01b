package e1.API;

public interface BankAccountFactory {

    /**
     * Creates a SilverBankAccount with the relative fee
     *
     * @param fee the fee associated with the BankAccount
     * @return the SilverBankAccount
     */
    BankAccount createSilverBankAccount(int fee);
}
