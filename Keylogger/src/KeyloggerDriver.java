import java.util.*;
import java.io.*;

/**
 * This class will read the user input and write it on a file.
 * 
 * @author Padma Dangal
 * @version 1.0.0
 */
public class KeyloggerDriver {

	private static BufferedReader stdIn = new BufferedReader(
			new InputStreamReader(System.in));

	private static PrintWriter stdOut = new PrintWriter(System.out, true);

	/**
	 * Launching method.
	 * 
	 * @param args array of command line parameters.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		FileWriter outputStream = null;
		
		outputStream = new FileWriter("characteroutput.txt");
		
		for (int i = 0; i < 25; i++) {
			int character = stdIn.read();
			stdOut.write(character);
			outputStream.write(character);
		}
		outputStream.close();
	}

}
