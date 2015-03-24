import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import accounts.*;

/**
 * This class models a generic console based application
 * usage: change both the file name and class name then 
 * just add code.
 *
 * @author Padma Dangal
 * @version 1.0.0
 */
public class BankAccountDriver {

	private static BufferedReader  stdIn =
			new  BufferedReader(new  InputStreamReader(System.in));


		private static PrintWriter  stdOut =
			new  PrintWriter(System.out, true);

		/**
		 * Launching method.
		 *
		 * @param args  array of command line parameters.
		 */
	public static void main(String[] args) {
		
		BankAccount account =  new BankAccount("BankOwner McBankster", 123.0f);
		
		stdOut.println(account.toString());
		
		SavingAccount saving = new SavingAccount("Saver McSaverster", 100.0f, 0.10f);
		
		saving.calculatedInterest();
		stdOut.println(saving.getBalance());
		stdOut.println(saving.toString());
	}

}
