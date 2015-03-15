import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class will asked the user to enter the letter to Guess the correct Password
 * User will given 10 times to entered letter to guess the password the and check it with the
 * Randomly generated password and give the result as per the guessing
 * 
 * @author Padma Dangal
 * @version 1.0
 */
public class GuessPassword {

	/**
	 * This method printing the greeting and information about the game.
	 */
	public static void greetingInfo() {
		System.out.println("Welcome to the **Password Guessing Game**");
		System.out.println("You will given 10 times to enter a letter to Guess a Correct Password before you lose the Game.");
	}

	/**
	 * This method will Randomly generate the number from 0 to 5
	 * @return number - generated number.
	 */
	public int randomInt() {

		int number = (int) (Math.random() * 5 + 0);

		return number;

	}

	/**
	 * This method will remove all the common letter of second ArrayList from the first ArrayList
	 * @param listA - First ArrayList
	 * @param listB - second ArrayList
	 * @return true or false
	 */
	public static boolean check(ArrayList<String> listA, ArrayList<String> listB) {
		listA.removeAll(listB); // listA will contain any letters not common to
								// listB
		if (listA.size() == 0){
			return true;
		}else{
		return false;
		}
	}

	/**
	 * This method will asked the user to Enter 1 to play again and 2 to quit the Game.
	 * 
	 */
	public static void rePlay(){
		Scanner user = new Scanner(System.in);
		System.out.println("Please Enter 1 to play Again Or 2 to Quit the Game.");
		int input = user.nextInt();
		
		if(input == 1){
			playGame();
		}else{
			System.out.println("Thank You for Playing **Password Guessing Game**\nGood Bye");
			System.exit(0);
		}
		
	}
	
	/**
	 * This method is processing every calculation for the Game to make it correct
	 * And displaying the message as per the user input.
	 */
	public static void playGame(){
		
		greetingInfo();

		Scanner scan = new Scanner(System.in);
		GuessPassword pass = new GuessPassword();

		String[] pword = new String[6];

		pword[0] = "Program";
		pword[1] = "Computer";
		pword[2] = "College";
		pword[3] = "Code";
		pword[4] = "Linux";
		pword[5] = "Coding";

		int num = pass.randomInt();
		
		//printing the randomly generated password on the console for testing
		System.out.println("Generated Password : (" + pword[num] + ")\n");

		//splitting the generated password
		String[] splitNow = pword[num].split("(?!^)");  

		ArrayList<String> list = new ArrayList<String>();

		//adding the randomly generated split password in to array list of list
		for (int i = 0; i < splitNow.length; i++) {
			list.add(splitNow[i]);
		}

		ArrayList<String> passW = new ArrayList<String>();

		String password = null;
		int index;
		for (int i = 1; i < 11; i++) {

			//prompting user to guess a letter
			System.out.println(i + ") Please Enter a letter."); 

			//catching the user input
			password = scan.next(); 

			 // adding the user input of each time to the array list of passW
			passW.add(password);

			//calculating the index of the letter in the password
			index = (pword[num].indexOf(password));

			//if the input letter in not exist in the randomly generated Password
			if (index == -1) {
				System.out.println("Your guess is wrong!");
			} else {
				System.out.print("Letter " + password + " is in place ");
			}
			
			//if the input letter is exist in the Password
			//checking recurrence of the input letter in the password
			while (index != -1) {
				System.out.print((index + 1) + " , ");
				System.out.flush();
				
				index = pword[num].indexOf(password, (index + 1)); //calculating the another index of recurrence letter
			}
			//Empty line
			System.out.println();

			//Checking if the input letter matches with the letter of the randomly generated password
			if (check(list, passW)) {

				System.out.println("\n***Congratulation You guess is correct!!***\n");
				rePlay();
			}
		}

		//printing the input letter and the generated password in Array List
		System.out.println("Unmatch letter from Randomly Generated password in Arraylist : "+ list);
		System.out.println("All entered letter in Arraylist: " + passW);

		//Empty line
		System.out.println();

		//If the input letter not matches with the letter of the randomly generated password after 10 input 
		System.out.println("***Sorry !! You have Entered the Wrong Guess***\n");
			rePlay();
		
	}
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {

		playGame();
	}
}
