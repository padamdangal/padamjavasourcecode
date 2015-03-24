package accounts;

public class SavingAccount extends BankAccount {
	
	
	
	private float interestRate;

	public SavingAccount(String name, float balance, float interestRate) {
		super(name, balance);
		this.interestRate = interestRate;
	}

	
	
	public void calculatedInterest(){
		
		setBalance(getBalance() + getBalance() * interestRate);
		
	}



	@Override
	public String toString() {
		return super.toString() + " " + interestRate;
	}
	
	
}
