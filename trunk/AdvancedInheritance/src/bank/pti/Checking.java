package bank.pti;

/**
 * This class is the subclass of the BankAccount
 * It also override the methods of the BankAccount and implement it.
 * 
 * @author Padma Dangal
 *  @version 1.0
 */
public class Checking extends BankAccount {

	/**
	 * Parameterize constructor
	 * @param accountNumber - New account number of the Checking Account
	 * @param accountBalance - New balance of the Checking Account
	 */
	public Checking(int accountNumber, float accountBalance) {
		super(accountNumber, accountBalance);
	}

	/**
	 * Accessor of the Balance
	 * @return accountBalance
	 */
	@Override
	public float getBalance() {
		return accountBalance;
	}

	/**
	 * Accessor of the Account Number
	 * @return accountNumber
	 */
	@Override
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * This method will print all the information the Checking account
	 * @return String representation of the account information
	 */
	@Override
	public String getAccountInformation() {
		return "Checking Account Information:\n" 
		        + "\tAccount Number:" + accountNumber + "\n" +
        		"\tAccount Balance:" + accountBalance;
	}

}
