package bank.pti;

/**
 * This is a BankAcount where it has account number and account balance.
 * It also has constructor and the setBalance method to set the new balance
 * It has three abstract method which are not implemented
 * 
 * @author Padma Dangal
 * @version 1.0
 */
public abstract class BankAccount {
	
	//account number of the Bank account
	protected int accountNumber;
	
	//account Balance of the Bank Account
	protected float accountBalance;

	/**
	 * Parameterize constructor
	 * @param accountNumber - New account number of the Bank Account
	 * @param accountBalance - New balance of the Bank Account
	 */
	public BankAccount(int accountNumber, float accountBalance) {
		this.accountNumber = accountNumber;
		
		//setting account balance to 0.0
		this.accountBalance = 0.0f;
	}
/**
 * Mutator of the Balance
 * @param balance - setting new balance of the Bank Account
 */
	public void setBalance(float balance) {
		this.accountBalance = balance;
	}

	/**
	 * Abstract Accessor method of Balance
	 */
	public abstract float getBalance();

	/**
	 * Abstract Accessor method of Account Number
	 */
	public abstract int getAccountNumber();

	/**
	 * Abstract Accessor method of Account Information
	 */
	public abstract String getAccountInformation();
}
