package sanchez.construction;

import java.util.Scanner;

/**
 * This is the main program which will create the array of 5 object and 
 * print all the loan data on console
 * @author Padma Dangal
 * @version 1.0
 */
public class CreateLoans {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {

		//Creating Array of 5 loan
		Loan[] loan = new Loan[5];
		
		//Using scanner class
		Scanner scan = new Scanner(System.in);
		
		//prompting user to enter the interest rate
		System.out.println("Please Enter the current prime interest Rate?");
		
		//assigning the entered interest rate to interest rate
		float interestRate = scan.nextFloat();
		
		//Asking the user to input load data for 5 loan and putting data to the loan array
		for (int i = 0; i < 5; i++) {
			System.out.println("Please Enter 1 for Business load and Enter 2 for Personal Loan.");
			int loanType = scan.nextInt();
			System.out.println("Enter the loan number?");
			int loanNum = scan.nextInt();
			System.out.println("Enter the Last Name of the Customer?");
			String lName = scan.next();
			System.out.println("Enter the loan amount?");
			float loanAmount = scan.nextFloat();
			System.out.println("Enter the term of the time?");
			int term = scan.nextInt();
			
			if(loanType == 1){
			loan[i] = new BusinessLoan(loanNum, lName, loanAmount, term, interestRate);
			}else if(loanType == 2){
				loan[i] = new PersonalLoan(loanNum, lName, loanAmount, term, interestRate);
			}
		}
		
		//Printing the loan data using loop
		for (int i = 0; i < loan.length; i++) {
			System.out.println(loan[i].toString());
		}
	}

}
