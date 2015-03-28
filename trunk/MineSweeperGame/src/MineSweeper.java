import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This is a MineSweeper game in which individuals has can click buttons for 20
 * times There are 4 bombs hiding under the cells. If user click on bomb ,
 * he/she will lose the game If user click buttons for 16 times without clicking
 * on bomb tiles, then he/she will win the game. Every time number will display
 * in buttons click by user to show them how many bombs lies around particular
 * tiles.
 * 
 * @author Padam Dangal
 * @version 1.0.0
 * 
 */
public class MineSweeper extends JFrame implements ActionListener {

	private JButton button1, button2, button3, button4, button5, button6,
			button7, button8, button9, button10, button11, button12, button13,
			button14, button15, button16, button17, button18, button19,
			button20;

	// creating the array of the 9 button
	JButton[] buttons = new JButton[20];

	String[] cellText = new String[20];
	
	// creating the bomb array to store the randomly generated bomb
	ArrayList<Integer> bomb = new ArrayList<Integer>();


	int buttonCount;

	// for menu
	private JMenuBar mainMenuBar;

	// references to the top level menus(these appears on the menu bar)
	private JMenu gameMenu;
	private JMenu helpMenu;

	private JMenuItem replay;
	private JMenuItem exit;
	private JMenuItem help;
	private JMenuItem author;

	/**
	 * Main method execute up on running
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {

		MineSweeper frame = new MineSweeper();
		frame.setSize(500, 400);

		// Seting the app so that it cannot be resized
		frame.setResizable(false);

		// let it be seen
		frame.setVisible(true);
	}

	/**
	 * Non parameterize constructor
	 */
	public MineSweeper() {

		mainMenuBar = new JMenuBar();

		// build the jframe
		setTitle("Mine Sweeper");

		// add the behavior to terminate this JFrame when were finished with it
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Now build the menu
		// create the menu bar
		this.setJMenuBar(mainMenuBar);

		// create the top level menu(s) 'File', 'Colors' and Help
		gameMenu = new JMenu("Game");
		helpMenu = new JMenu("Help");

		// more on this layout manager later
		this.setLayout(new GridLayout(4, 5));

		// now create all of the menu items (see running Demo)
		replay = new JMenuItem("RePlay");
		exit = new JMenuItem("Exit");

		help = new JMenuItem("Help");
		author = new JMenuItem("Author");
		author.setMnemonic('A');

		// add menu items to the Game
		gameMenu.add(replay);
		gameMenu.add(exit);

		// add menu items to the Help
		helpMenu.add(help);
		helpMenu.add(author);

		// finally add the top level menus to the menu bar
		mainMenuBar.add(gameMenu);
		mainMenuBar.add(helpMenu);

		// add the menu item action listeners
		replay.addActionListener(this);
		exit.addActionListener(this);
		help.addActionListener(this);
		author.addActionListener(this);

		/*
		 * ======================================================================
		 * ======= Menu bar is created!! Below is the code for the game
		 * ==========
		 * ==================================================================
		 */

		// displaying all the buttons
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			cellText[i] = "";
			buttons[i].setBackground(Color.YELLOW);
			buttons[i].addActionListener(this);
			add(buttons[i]);
		}

		// randomly generating the four bomb
		int firstBomb = randomNumber();
		int secondBomb = randomNumber();
		int thirdBomb = randomNumber();
		int fourthBomb = randomNumber();

		// generating the 2nd bomb until it is not equal to 1st bomb
		while (secondBomb == firstBomb) {
			secondBomb = randomNumber();
		}
		// generating the 3rd bomb until it is not equal to 1st and 2nd bomb
		while (thirdBomb == firstBomb || thirdBomb == secondBomb) {
			thirdBomb = randomNumber();
		}
		// generating the 4nd bomb until it is not equal to 1st bomb, 2nd bomb
		// and 3rd bomb
		while (fourthBomb == firstBomb || fourthBomb == secondBomb
				|| fourthBomb == thirdBomb) {
			fourthBomb = randomNumber();
		}

		// storing bombs in to the bomb array
		bomb.add(firstBomb);
		bomb.add(secondBomb);
		bomb.add(thirdBomb);
		bomb.add(fourthBomb);

		// setting the bomb text on the randomly generated bomb cell
		for (Integer bombPlace : bomb) {
			cellText[bombPlace] = "Bomb";
		}

		int bombAreaCount = 0;

		for (int i = 0; i < buttons.length; i++) {

			if (!cellText[i].equals("Bomb")) {

				// checking the top row 3 buttons
				if (i == 1 || i == 2 || i == 3) {

					if (cellText[i - 1].equals("Bomb")) {
						++bombAreaCount;
					}
					if (cellText[i + 1].equals("Bomb")) {
						++bombAreaCount;
					}
					if (cellText[i + 4].equals("Bomb")) {
						++bombAreaCount;
					}
					if (cellText[i + 5].equals("Bomb")) {
						++bombAreaCount;
					}
					if (cellText[i + 6].equals("Bomb")) {
						++bombAreaCount;
					}

					cellText[i] = bombAreaCount + "";
					bombAreaCount = 0;
				}

				// checking the middle two rows row 6 buttons
				else if (i == 6 || i == 7 || i == 8 || i == 11 || i == 12
						|| i == 13) {
					if (cellText[i - 1].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i + 1].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i + 4].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i - 4].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i + 5].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i + 6].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i - 6].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i - 5].equals("Bomb"))
						++bombAreaCount;

					cellText[i] = bombAreaCount + "";
					bombAreaCount = 0;
				}

				// checking the bottom row 3 buttons
				else if (i == 16 || i == 17 || i == 18) {
					if (cellText[i - 1].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i + 1].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i - 4].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i - 5].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i - 6].equals("Bomb"))
						++bombAreaCount;

					cellText[i] = bombAreaCount + "";
					bombAreaCount = 0;
				}

				// checking left column 2 buttons
				else if (i == 5 || i == 10) {
					if (cellText[i + 1].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i - 4].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i - 5].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i + 5].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i + 6].equals("Bomb"))
						++bombAreaCount;

					cellText[i] = bombAreaCount + "";
					bombAreaCount = 0;
				}

				// checking right column 2 buttons
				else if (i == 9 || i == 14) {
					if (cellText[i - 1].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i + 4].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i + 5].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i - 5].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i - 6].equals("Bomb"))
						++bombAreaCount;

					cellText[i] = bombAreaCount + "";
					bombAreaCount = 0;
				}

				// checking top left corner
				else if (i == 0) {
					if (cellText[i + 1].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i + 5].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i + 6].equals("Bomb"))
						++bombAreaCount;

					cellText[i] = bombAreaCount + "";
					bombAreaCount = 0;
				}

				// checking top right corner
				else if (i == 4) {
					if (cellText[i - 1].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i + 4].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i + 5].equals("Bomb"))
						++bombAreaCount;

					cellText[i] = bombAreaCount + "";
					bombAreaCount = 0;
				}

				// checking bottom left corner
				else if (i == 15) {
					if (cellText[i + 1].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i - 4].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i - 5].equals("Bomb"))
						++bombAreaCount;

					cellText[i] = bombAreaCount + "";
					bombAreaCount = 0;
				}

				// checking bottom right corner
				else if (i == 19) {
					if (cellText[i - 1].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i - 5].equals("Bomb"))
						++bombAreaCount;
					if (cellText[i - 6].equals("Bomb"))
						++bombAreaCount;

					cellText[i] = bombAreaCount + "";
					bombAreaCount = 0;
				}
			}

			// Setting the remaining buttons to 0.
			if (buttons[i].equals("")) {
				cellText[i] = "0";
			}
		}

	}

	/**
	 * This method will perform the action on click of the button This method
	 * will display the text of the button after user click on it.
	 */
	@Override
	public void actionPerformed(ActionEvent event) {

		boolean bombFound = false;
		Object source = event.getSource();

		for (int i = 0; i < 20; ++i) {

			// if user click on button
			if (source == buttons[i]) {

				// if the button click by user contain Bomb
				if (cellText[i].equals("Bomb")) {
					buttons[i].setText(cellText[i]);
					buttons[i].setBackground(Color.RED);
					buttons[i].setFont(new Font("Arial", Font.ITALIC, 18));
					JOptionPane.showMessageDialog(null,
							"Sorry!!\nYou click on Bomb, Try Again Later");

					bombFound = true;
				} else {
					buttons[i].setText(cellText[i]);
					buttons[i].setEnabled(false);

					bombFound = false;

					buttonCount++;
				}
			}
		}

		for (int i = 0; i < buttons.length; i++) {
			// if user click on bomb then display message and uncover all the
			// text on the cell
			if (bombFound == true) {

				if (cellText[i].equals("Bomb")) {
					buttons[i].setText(cellText[i]);
					buttons[i].setBackground(Color.RED);
					buttons[i].setFont(new Font("Arial", Font.ITALIC, 18));
				}
				buttons[i].setText(cellText[i]);

				buttons[i].setEnabled(false);
			}
		}

		// if players did not click on bomb for 16 times then he/she win the
		// game
		if (buttonCount == 16) {
			JOptionPane.showMessageDialog(null, "Congrats You won!");
			buttonCount = 0;
			for (int i = 0; i < 20; ++i) {
				buttons[i].setEnabled(false);
			}
		}

		// **************Below is the code of Action for Menu
		// Bar***********************//

		// depending on 'who-done-it', color label
		if (exit == source) {
			System.exit(0);
		} else if (replay == source) {

			// setting the buttons to empty value, and background color to white
			// and enabling them
			for (int i = 0; i < buttons.length; i++) {
				buttons[i].setText("");
				buttons[i].setBackground(Color.YELLOW);
				buttons[i].setEnabled(true);
			}

			// setting the bomb text on the randomly generated bomb cell
			for (Integer bombPlace : bomb) {
				cellText[bombPlace] = "Bomb";
			}
			
			buttonCount = 0;
			bombFound = false;

		} else if (help == source) {
			JOptionPane
					.showMessageDialog(
							null,
							"You need to click on the avilable buttons to Play.\nThe number that show up upon playing define the number of bombs next to it.\nThere are four bombs exist in total buttons.\nYou need to click on buttons that don't have bomb to win the game.");
		} else if (author == source) {
			JOptionPane.showMessageDialog(null,
					"Author : Padam Dangal\nVersion : 1.0.0");
		}
	}

	public static int randomNumber() {

		Random random = new Random();

		int randomInt = random.nextInt(19);

		return randomInt;
	}
}
