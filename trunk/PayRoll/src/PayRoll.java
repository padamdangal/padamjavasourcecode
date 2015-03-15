import javax.swing.JOptionPane;


public class PayRoll {

	private static int selectNum;

	public static void main(String[] args) {
		
	
	// define programmer defined variables
			int menu1;
			String inputData;
			int hoursWorked = 0;
			int hourlyPayRate = 0;
					
			int totalRevenue = 0;
			int costGoodsSold = 0;
			int operatingExpense = 0;
			int interestExpense = 0;
			double salesTax = 0;
					
			int grossIncome = 0;
			int allExpense = 0;
			
			int grossPay1 = 0;
			int netProfit1 = 0;
			int netPrice1 = 0;
			int summation1 = 0;
			int average1 = 0;
			int variance1 = 0;
			int standardDeviation1 = 0;
			int simpleInterest1 = 0;
			int compoundInterest1 = 0;
			//double allTogether = 0;
			
			int principle = 0;
			int rate = 0;
			int time = 0;
			
			int annualInterest = 0;
			int numOfCompPeriods = 0;
			
			
			
			
				String menu = JOptionPane.showInputDialog(null,
						"Enter number of program: " + 
					        "\n " +
						"\n Business Functions" +
		                                "\n 1 - Calculate Gross Pay" +			           
						"\n 2 - Calculate Net Profit" +
					        "\n 3 - Calculate Net Price" +
						"\n " +
			                        "\n Statistical Functions" +
						"\n 4 - Calculate the Summation" +
					        "\n 5 - Calculate the Average" +
						"\n 6 - Calculate the Variance " +
						"\n 7 - Calculate the Standard Deviation " +
						"\n " +
						"\n Interest Function " +
						"\n 8 - Calculate Simple Interest" +
						"\n 9 - Calculate Compound Interst" +
						"\n 10 - Exit");	
				
				selectNum = Integer.parseInt(menu);
				
				if(selectNum == 1) 
				{
					inputData = JOptionPane.showInputDialog(null, "Enter the hours you have worked. ");
					hoursWorked = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter your houly pay rate. ");
					hourlyPayRate = Integer.parseInt(inputData);
				}
				else if (selectNum == 2)
				{
					inputData = JOptionPane.showInputDialog(null, "Enter the total revenue. ");
					totalRevenue = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the cost of goods sold. ");
					costGoodsSold = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the operating expense. ");
					operatingExpense = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the interest expense. ");
					interestExpense = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the sales tax. ");
					salesTax = Double.parseDouble(inputData);
				}
				else if (selectNum == 3)
				{
					inputData = JOptionPane.showInputDialog(null, "Enter the total revenue. ");
					totalRevenue = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the gross income. ");
					grossIncome = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter all expenses. ");
					allExpense = Integer.parseInt(inputData);
				}	
				else if (selectNum == 4)
				{
					inputData = JOptionPane.showInputDialog(null, "Enter the gross pay. ");
					grossPay1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the net profit. ");
					netProfit1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the netPrice. ");
					netPrice1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the average. ");
					average1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the variance. ");
					variance1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the standard deviation. ");
					standardDeviation1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter simple interest. ");
					simpleInterest1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter compounded interest. ");
					compoundInterest1 = Integer.parseInt(inputData);
				}
				else if (selectNum == 5)
				{
					inputData = JOptionPane.showInputDialog(null, "Enter the gross pay. ");
					grossPay1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the net profit. ");
					netProfit1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the netPrice. ");
					netPrice1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the summation. ");
					summation1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the variance. ");
					variance1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the standard deviation. ");
					standardDeviation1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter simple interest. ");
					simpleInterest1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter compounded interest. ");
					compoundInterest1 = Integer.parseInt(inputData);
				}
				else if (selectNum == 6)
				{
					inputData = JOptionPane.showInputDialog(null, "Enter the gross pay. ");
					grossPay1 =Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the net profit. ");
					netProfit1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the netPrice. ");
					netPrice1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the summation. ");
					summation1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the average. ");
					average1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the standard deviation. ");
					standardDeviation1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter simple interest. ");
					simpleInterest1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter compounded interest. ");
					compoundInterest1 = Integer.parseInt(inputData);
				}
				else if (selectNum == 7)
				{
					inputData = JOptionPane.showInputDialog(null, "Enter the gross pay. ");
					grossPay1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the net profit. ");
					netProfit1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the netPrice. ");
					netPrice1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the summation. ");
					summation1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the average. ");
					average1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the standard deviation. ");
					standardDeviation1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter simple interest. ");
					simpleInterest1 = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter compounded interest. ");
					compoundInterest1 = Integer.parseInt(inputData);

				}
				else if (selectNum == 8)
				{
					inputData = JOptionPane.showInputDialog(null, "Enter the principle amount. ");
					principle = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the time. ");
					time = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter all rate. ");
					rate = Integer.parseInt(inputData);
				}	
				else if (selectNum == 9)
				{
					inputData = JOptionPane.showInputDialog(null, "Enter the principle amount. ");
					principle = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the annual interest in decimal format. ");
					annualInterest = Integer.parseInt(inputData);
					inputData = JOptionPane.showInputDialog(null, "Enter the number of compounded periods. ");
					numOfCompPeriods = Integer.parseInt(inputData);
				}	
				else
				{
					JOptionPane.showMessageDialog(null, "Good Bye!");
				}
				
				
				
				switch(selectNum) {
				
					case 1:
						double grossPay = (hourlyPayRate*hoursWorked);
						JOptionPane.showMessageDialog(null, "The gross pay is: "+ grossPay);
						System.exit(0);
						break;
						
					case 2:
						double netProfit = (totalRevenue - grossIncome - operatingExpense - interestExpense - salesTax);
						JOptionPane.showMessageDialog(null, "The net profit is: "+ netProfit);
						System.exit(0);
						break;
						
					case 3:
						double netPrice = (totalRevenue - grossIncome - allExpense);
						JOptionPane.showMessageDialog(null, "The net price is: "+ netPrice);
						System.exit(0);
						break;
						
					case 4: 
						double summation = (grossPay1 + netProfit1 + netPrice1 + average1 + variance1 +
						standardDeviation1 + simpleInterest1 + compoundInterest1);
						JOptionPane.showMessageDialog(null, "The summation is: "+ summation);
						System.exit(0);
						break;
						
					case 5: 
						double average = (grossPay1 + netProfit1 + netPrice1 + summation1 + variance1 +
						standardDeviation1 + simpleInterest1 + compoundInterest1)/2;
						JOptionPane.showMessageDialog(null, "The average is: "+ average);
						System.exit(0);
						break;
					
					case 6:
						double variance = ((grossPay1*grossPay1) + (netProfit1*netProfit1) + (netPrice1*netPrice1)
						+ (summation1*summation1) + (standardDeviation1*standardDeviation1) + (average1*average1)
						+ (simpleInterest1*simpleInterest1) + (compoundInterest1*compoundInterest1))/9;
						JOptionPane.showMessageDialog(null, "The variance is: "+ variance);
						System.exit(0);
						break;
						
					case 7: 
						double standaradDeviation = (grossPay1 + netProfit1 + netPrice1+ summation1 + 
						standardDeviation1 + average1 + simpleInterest1 + compoundInterest1);
						JOptionPane.showMessageDialog(null, "The variance is: "+ standaradDeviation);
						System.exit(0);
						break;
						
					case 8:
						double simpleInterest = (principle*rate*time)/100;
						JOptionPane.showMessageDialog(null, "The simple interest is: "+ simpleInterest);
						System.exit(0);
						break;
						
					case 9:
						double compoundInterest = (principle*Math.pow(1 + annualInterest, numOfCompPeriods));
						JOptionPane.showMessageDialog(null, "The compounded interest is: "+ compoundInterest);
						System.exit(0);
						break;
						       
				}
				}
			
			}
			
	      

		

	



