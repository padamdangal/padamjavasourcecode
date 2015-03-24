package accounts;

public class BankAccount {

	//The account owner's name
	protected String name;
	
	//The balance in hs/her account
	protected float balance;

	public BankAccount(String name, float balance) {
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return this.balance;
	}

	public boolean setBalance(float balance) {
		
		if(balance < 0){
		return false;
		}
		
		this.balance = balance;
		return true;
	}

	@Override
	public String toString() {
		return this.getName() + " " + this.getBalance() ;
	}
	
	
	
}
