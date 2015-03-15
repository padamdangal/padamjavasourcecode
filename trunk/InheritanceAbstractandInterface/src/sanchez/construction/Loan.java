package sanchez.construction;

/**
 * This program implements the interface LoanConstant and will display the all loan data.
 * @author Padma Dangal
 * @version 1.0
 */
public abstract class Loan implements LoanConstant {

	//Data of the person or the company
	private int loanNumber;
	private String customerLastName;
	private float amountOfLoan;
	protected double interestRate;
	private int term;
	
	/**
	 * Parameterize constructor
	 * @param loanNumber - New loan number of the Loan
	 * @param customerLastName - New last name of the person who is taking loan
	 * @param amountOfLoan - New amount of the loan taken
	 * @param term - new time period of the loan
	 */
	public Loan(int loanNumber, String customerLastName, float amountOfLoan,
			int term) 
	{
		this.loanNumber = loanNumber;
		this.customerLastName = customerLastName;
		this.amountOfLoan = amountOfLoan;
		this.term = term;
		
		//checking the loan is less than the max limit and assigning it to max amount if it is greater than max limit.
		if(amountOfLoan > MAX_LOAN_AMOUNT){
			amountOfLoan = MAX_LOAN_AMOUNT;
		}
			
		//forcing the loan term to short term is it is not equal to define term
		if(term != SHORT_TERM && term != MID_TERM && term != LONG_TERM){
			this.term = SHORT_TERM;
		}
	}

/**
 * This method will print all the data of the loan
 *  @return A string representation of this Loan.
 */
	@Override
	public String toString() {
		return "loanNumber=" + loanNumber + ", customerLastName="
				+ customerLastName + ", amountOfLoan=" + amountOfLoan
				+ ", interestRate=" + interestRate + ", term=" + term;
	}
}