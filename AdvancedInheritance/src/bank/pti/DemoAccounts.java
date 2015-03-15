package bank.pti;

public class DemoAccounts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Savings saving =  new Savings(21123, 25000, 5);
		saving.setBalance(46000);
		System.out.println(saving.getAccountInformation());
		
		Checking checking = new Checking(123, 2500);
		checking.setBalance(30000);
		System.out.println(checking.getAccountInformation());

	}

}
