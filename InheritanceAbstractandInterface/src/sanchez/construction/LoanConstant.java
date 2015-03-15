package sanchez.construction;

/**
 * This Interface has final variables of Company name,
 *  maximum limit of the loan and the time period of the loan.
 * @author Padma Dangal
 * @version 1.0
 *
 */
public interface LoanConstant {

	//initialization of the short term
	final int SHORT_TERM = 1;
	
	//initialization of the mid term
	final int MID_TERM = 3;
	
	//initialization of the long term
	final int LONG_TERM = 5;
	
	//Name of the company
	String COMPANY_NAME ="SANCHEZ CONSTRUCTION LOAN CO.";
	
	//Maximum limit of the amount
	float MAX_LOAN_AMOUNT = 100000;
	
}
