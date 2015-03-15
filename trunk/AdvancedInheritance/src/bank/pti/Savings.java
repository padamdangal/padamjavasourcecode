package bank.pti;

/**
 * This class is the subclass of the BankAccount which has additional interest rate variable
 * It also override the methods of the BankAccount and implement it.
 * 
 * @author Padma Dangal
 *  @version 1.0
 */
public class Savings extends BankAccount {

	//Interest rate of the savings account
	protected float interestRate;

	/**
	 * Parameterize constructor
	 * @param accountNumber - New account number of the Savings Account
	 * @param accountBalance - New balance of the Savings Account
	 * @param interestRate - New interest rate of the saving account.
	 */
	public Savings(int accountNumber, float accountBalance, float interestRate) {
		super(accountNumber, accountBalance);
		this.interestRate = interestRate;
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
	 * This method will print all the information the savings account
	 * @return String representation of the account information
	 */
	@Override
	public String getAccountInformation() {

		return "Savings Account Information:\n" 
		        + "\tAccount Number:" + accountNumber + "\n" +
		          "\tAccount Balance:" + accountBalance + "\n" +
		          "\tInterest Rate:" + interestRate;
	}

}
