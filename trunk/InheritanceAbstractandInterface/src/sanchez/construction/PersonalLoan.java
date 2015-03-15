package sanchez.construction;

/**
 * This program extends the Loan and increase the interest rate by 2
 * @author Padma Dangal
 *  @version 1.0
 *
 */
public class PersonalLoan extends Loan {

	/**
	 * parameterize constructor
	 * @param loanNumber - New loan number of the Loan
	 * @param customerLastName - New last name of the person who is taking loan
	 * @param amountOfLoan - New amount of the loan taken
	 * @param term - new time period of the loan
	 * @param primeInterestRate - new prime interest rate
	 */
	public PersonalLoan(int loanNumber, String customerLastName,
			float amountOfLoan, int term, double primeInterestRate) {
		super(loanNumber, customerLastName, amountOfLoan, term);

		//adding 2% to the prime interest rate
		interestRate = primeInterestRate + 0.02;
	}

}
