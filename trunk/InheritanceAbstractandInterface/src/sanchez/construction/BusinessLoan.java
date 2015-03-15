package sanchez.construction;

/**
 * This program extends the Loan and increase the interest rate by 1
 * @author Padma Dangal
 *  @version 1.0
 *
 */
public class BusinessLoan extends Loan {

	/**
	 * parameterize constructor
	* @param loanNumber - New loan number of the Loan
	 * @param customerLastName - New last name of the person who is taking loan
	 * @param amountOfLoan - New amount of the loan taken
	 * @param term - new time period of the loan
	 * @param primeInterestRate - new prime interest rate
	 */
	public BusinessLoan(int loanNumber, String customerLastName,
			float amountOfLoan, int term, double primeInterestRate) {
		super(loanNumber, customerLastName, amountOfLoan, term);
		
		//adding 1% to the prime interest rate
		interestRate = primeInterestRate + 0.01;
	}

}
