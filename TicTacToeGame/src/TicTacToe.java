import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


/**
 * This is Game which has nine button, 3 in each line
 * 
 * @author Padma Dangal
 * @version 1.0.0
 *
 */
public class TicTacToe extends JPanel implements ActionListener{
	
	//creating the buttons
	private JButton buttonOne;
	private JButton buttonTwo;
	private JButton buttonThree;
	private JButton buttonFour;
	private JButton buttonFive;
	private JButton buttonSix;
	private JButton buttonSeven;
	private JButton buttonEight;
	private JButton buttonNine;
	
	//creating the array of the 9 button
	JButton[] buttons = new JButton[9];
	
	//creating the player
	private int player = 0;
	
	//count variable count the number of times pressed
	int count = 0;
	
	private boolean winner = false;
	

	/**
	 * Runs the Action button Demo. 
	 * this creates the JFrame, edit it's properties, then show it
	 * @param args not used
	 */
	public static void main(String[] args) {
        
		//Create the java window 
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setSize(250, 275);
		
       //now go and populate 
		frame.setContentPane(new TicTacToe());
		
		//add the behavior to terminate this JFrame when were finished with it
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Seting the app so that it cannot be resized
		frame.setResizable(false);
		
		//let it be seen
		frame.setVisible(true);

	}

	/**
	 * Paratemerless Constructor that adds the pieces of the JButtons into a JFrame
	 */
	public TicTacToe(){
		
		// more on this layout manager later
		this.setLayout(new GridLayout(3,3));
		this.setBackground(Color.WHITE);
		
		//Creating the array of nine buttons and putting the buttons in to the array
		
		buttons[0] = buttonOne;
		buttons[1] = buttonTwo;
		buttons[2] = buttonThree;
		buttons[3] = buttonFour;
		buttons[4] = buttonFive;
		buttons[5] = buttonSix;
		buttons[6] = buttonSeven;
		buttons[7] = buttonEight;
		buttons[8] = buttonNine;
		
		//Adding all the buttons in the JFrame
		for (int i = 0; i < buttons.length; i++) {
			
			//Creating the buttons and setting all the fonts as 'Ariel, Bold and size 48.
			buttons[i] = new JButton();
			buttons[i].setFont(new Font("Arial", Font.BOLD, 48));
			buttons[i].setEnabled(true);
			buttons[i].addActionListener(this);
			
			add(buttons[i]);
		}
	}
	
	/**
	 * Action of the button.
	 * This increase the count in each press
	 * set the button set the even turn to 'X' with green background color and odd turns to 'O' with yellow background color
	 * It disable the pressed button
	 * @param e(Object of ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
	//increasing the count in each press
	count++;	
		
	//using for loop to assign text 'X' for even count and 'O' for odd count
	 for (int i = 0; i < buttons.length; i++) {
		
		 if(buttons[i] == e.getSource()){
			 
			 if(player % 2 == 0){
				 buttons[i].setText("X");
				 buttons[i].setBackground(Color.GREEN);
				 buttons[i].setEnabled(false);
			 }else{
				 buttons[i].setText("O");
				 buttons[i].setBackground(Color.YELLOW);
				 buttons[i].setEnabled(false);
			 }
		   }
	     }
	 
	 //assigning checkForWinner boolean value to winner
	      winner = checkForWinner();
	      
	      //if winner is true
	     if(winner == true){
	    	 
	    	 
	    	for (int i = 0; i < buttons.length; i++) {
				 buttons[i].setEnabled(false);
			}
	    	 JOptionPane.showMessageDialog(null, " WINS!");
	    	 
	    	 } 
	     
	      //checking if the count is greater and equal to 9 (Count - number of pressed) and winner is false
	    	 else if(count == 9 && winner == false){
			
			JOptionPane.showMessageDialog(null, "Its a tie, Play Again");
			
			//setting the buttons to empty value, and background color to white and enabling them
			for (int i = 0; i < buttons.length; i++) {
				 buttons[i].setText("");
				 buttons[i].setBackground(Color.WHITE);
				 buttons[i].setEnabled(true);
			}
			
			count = 0;
			player = 0;
		}
		player++;	
		}
	
	public boolean checkForWinner(){
		
		//Checking rows 
		if(buttons[0].getText().equals(buttons[1].getText()) && (buttons[1].getText().equals(buttons[2].getText())) && (!buttons[0].getText().equals(""))){
			 
			 buttons[0].setText(buttons[0].getText()) ;
	    	 buttons[0].setBackground(buttons[0].getBackground());
	    	 buttons[1].setText(buttons[1].getText()) ;
	    	 buttons[1].setBackground(buttons[1].getBackground());
	    	 buttons[2].setText(buttons[2].getText()) ;
	    	 buttons[2].setBackground(buttons[2].getBackground());
	    	 
	    	 buttons[3].setText("");
	    	 buttons[3].setBackground(Color.WHITE);
	    	 buttons[4].setText("");
	    	 buttons[4].setBackground(Color.WHITE);
	    	 buttons[5].setText("");
	    	 buttons[5].setBackground(Color.WHITE);
	    	 buttons[6].setText("");
	    	 buttons[6].setBackground(Color.WHITE);
	    	 buttons[7].setText("");
	    	 buttons[7].setBackground(Color.WHITE);
	    	 buttons[8].setText("");
	    	 buttons[8].setBackground(Color.WHITE);
	    	 
			return true;
		}
		else if(buttons[3].getText().equals(buttons[4].getText()) && (buttons[4].getText().equals(buttons[5].getText())) && (!buttons[3].getText().equals(""))){
			
			 buttons[3].setText(buttons[3].getText()) ;
	    	 buttons[3].setBackground(buttons[3].getBackground());
	    	 buttons[4].setText(buttons[4].getText()) ;
	    	 buttons[4].setBackground(buttons[4].getBackground());
	    	 buttons[5].setText(buttons[5].getText()) ;
	    	 buttons[5].setBackground(buttons[5].getBackground());
	    	 
	    	 buttons[0].setText("");
	    	 buttons[0].setBackground(Color.WHITE);
	    	 buttons[1].setText("");
	    	 buttons[1].setBackground(Color.WHITE);
	    	 buttons[2].setText("");
	    	 buttons[2].setBackground(Color.WHITE);
	    	 buttons[6].setText("");
	    	 buttons[6].setBackground(Color.WHITE);
	    	 buttons[7].setText("");
	    	 buttons[7].setBackground(Color.WHITE);
	    	 buttons[8].setText("");
	    	 buttons[8].setBackground(Color.WHITE);
	    	 
			return true;
		}
		else if(buttons[6].getText().equals(buttons[7].getText()) && (buttons[7].getText().equals(buttons[8].getText())) && (!buttons[6].getText().equals(""))){
			
			
			//Assigning the text to the winning path
			 buttons[6].setText(buttons[6].getText()) ;
	    	 buttons[6].setBackground(buttons[6].getBackground());
	    	 buttons[7].setText(buttons[7].getText()) ;
	    	 buttons[7].setBackground(buttons[7].getBackground());
	    	 buttons[8].setText(buttons[8].getText()) ;
	    	 buttons[8].setBackground(buttons[8].getBackground());
	    	 
	    	 //Making all other paths to Empty and background color to white
	    	 buttons[0].setText("");
	    	 buttons[0].setBackground(Color.WHITE);
	    	 buttons[1].setText("");
	    	 buttons[1].setBackground(Color.WHITE);
	    	 buttons[2].setText("");
	    	 buttons[2].setBackground(Color.WHITE);
	    	 buttons[3].setText("");
	    	 buttons[3].setBackground(Color.WHITE);
	    	 buttons[4].setText("");
	    	 buttons[4].setBackground(Color.WHITE);
	    	 buttons[5].setText("");
	    	 buttons[5].setBackground(Color.WHITE);
	    	 
			return true;
		}
		
		//checking columns 
		else if(buttons[0].getText().equals(buttons[3].getText()) && (buttons[3].getText().equals(buttons[6].getText())) && (!buttons[0].getText().equals(""))){
			
			//Assigning the text to the winning path
			 buttons[0].setText(buttons[0].getText()) ;
	    	 buttons[0].setBackground(buttons[0].getBackground());
	    	 buttons[3].setText(buttons[3].getText()) ;
	    	 buttons[3].setBackground(buttons[3].getBackground());
	    	 buttons[6].setText(buttons[6].getText()) ;
	    	 buttons[6].setBackground(buttons[6].getBackground());
	    	 
	    	 //Making all other paths to Empty and background color to white
	    	 buttons[1].setText("");
	    	 buttons[1].setBackground(Color.WHITE);
	    	 buttons[2].setText("");
	    	 buttons[2].setBackground(Color.WHITE);
	    	 buttons[4].setText("");
	    	 buttons[4].setBackground(Color.WHITE);
	    	 buttons[5].setText("");
	    	 buttons[5].setBackground(Color.WHITE);
	    	 buttons[7].setText("");
	    	 buttons[7].setBackground(Color.WHITE);
	    	 buttons[8].setText("");
	    	 buttons[8].setBackground(Color.WHITE);
	    	 
			return true;
		}
		else if(buttons[1].getText().equals(buttons[4].getText()) && (buttons[4].getText().equals(buttons[7].getText())) && (!buttons[1].getText().equals(""))){
			
			//Assigning the text to the winning path
			 buttons[1].setText(buttons[1].getText()) ;
	    	 buttons[1].setBackground(buttons[1].getBackground());
	    	 buttons[4].setText(buttons[4].getText()) ;
	    	 buttons[4].setBackground(buttons[4].getBackground());
	    	 buttons[7].setText(buttons[7].getText()) ;
	    	 buttons[7].setBackground(buttons[7].getBackground());
	    	 
	    	 //Making all other paths to Empty and background color to white
	    	 buttons[0].setText("");
	    	 buttons[0].setBackground(Color.WHITE);
	    	 buttons[2].setText("");
	    	 buttons[2].setBackground(Color.WHITE);
	    	 buttons[3].setText("");
	    	 buttons[3].setBackground(Color.WHITE);
	    	 buttons[5].setText("");
	    	 buttons[5].setBackground(Color.WHITE);
	    	 buttons[6].setText("");
	    	 buttons[6].setBackground(Color.WHITE);
	    	 buttons[8].setText("");
	    	 buttons[8].setBackground(Color.WHITE);
	    	 
			return true;
		}else if(buttons[2].getText().equals(buttons[5].getText()) && (buttons[5].getText().equals(buttons[8].getText())) && (!buttons[2].getText().equals(""))){
			
			//Assigning the text to the winning path
			 buttons[2].setText(buttons[2].getText()) ;
	    	 buttons[2].setBackground(buttons[2].getBackground());
	    	 buttons[5].setText(buttons[5].getText()) ;
	    	 buttons[5].setBackground(buttons[5].getBackground());
	    	 buttons[8].setText(buttons[8].getText()) ;
	    	 buttons[8].setBackground(buttons[8].getBackground());
	    	 
	    	 //Making all other paths to Empty and background color to white
	    	 buttons[0].setText("");
	    	 buttons[0].setBackground(Color.WHITE);
	    	 buttons[1].setText("");
	    	 buttons[1].setBackground(Color.WHITE);
	    	 buttons[3].setText("");
	    	 buttons[3].setBackground(Color.WHITE);
	    	 buttons[4].setText("");
	    	 buttons[4].setBackground(Color.WHITE);
	    	 buttons[6].setText("");
	    	 buttons[6].setBackground(Color.WHITE);
	    	 buttons[7].setText("");
	    	 buttons[7].setBackground(Color.WHITE);
	    	 
			return true;
		}
		
		//checking diagonals
		else if(buttons[0].getText().equals(buttons[4].getText()) && (buttons[4].getText().equals(buttons[8].getText())) && (!buttons[0].getText().equals(""))){
			
			//Assigning the text to the winning path
			 buttons[0].setText(buttons[0].getText()) ;
	    	 buttons[0].setBackground(buttons[0].getBackground());
	    	 buttons[4].setText(buttons[4].getText()) ;
	    	 buttons[4].setBackground(buttons[4].getBackground());
	    	 buttons[8].setText(buttons[8].getText()) ;
	    	 buttons[8].setBackground(buttons[8].getBackground());
	    	 
	    	 //Making all other paths to Empty and background color to white
	    	 buttons[1].setText("");
	    	 buttons[1].setBackground(Color.WHITE);
	    	 buttons[2].setText("");
	    	 buttons[2].setBackground(Color.WHITE);
	    	 buttons[3].setText("");
	    	 buttons[3].setBackground(Color.WHITE);
	    	 buttons[5].setText("");
	    	 buttons[5].setBackground(Color.WHITE);
	    	 buttons[6].setText("");
	    	 buttons[6].setBackground(Color.WHITE);
	    	 buttons[7].setText("");
	    	 buttons[7].setBackground(Color.WHITE);
	    	 
			return true;
	    }else if(buttons[2].getText().equals(buttons[4].getText()) && (buttons[4].getText().equals(buttons[6].getText())) && (!buttons[2].getText().equals(""))){
	    	
	    	//Assigning the text to the winning path
	    	 buttons[2].setText(buttons[2].getText()) ;
	    	 buttons[2].setBackground(buttons[2].getBackground());
	    	 buttons[4].setText(buttons[4].getText()) ;
	    	 buttons[4].setBackground(buttons[4].getBackground());
	    	 buttons[6].setText(buttons[6].getText()) ;
	    	 buttons[6].setBackground(buttons[6].getBackground());
	    	 
	    	 //Making all other paths to Empty and background color to white
	    	 buttons[0].setText("");
	    	 buttons[0].setBackground(Color.WHITE);
	    	 buttons[1].setText("");
	    	 buttons[1].setBackground(Color.WHITE);
	    	 buttons[3].setText("");
	    	 buttons[3].setBackground(Color.WHITE);
	    	 buttons[5].setText("");
	    	 buttons[5].setBackground(Color.WHITE);
	    	 buttons[7].setText("");
	    	 buttons[7].setBackground(Color.WHITE);
	    	 buttons[8].setText("");
	    	 buttons[8].setBackground(Color.WHITE);
	    	 
	    	return true;
        }else{
        	
        	return false;
        }
	}
}
