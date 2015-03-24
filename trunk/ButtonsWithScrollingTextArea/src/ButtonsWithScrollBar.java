import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 * This program has open, save and clear button on left side and text Area on right side
 * Open button will open the text file in to the Text Area
 * Save button will save into the text file what ever is written in the Text Area and
 * Clear button will clear all the text of the text area
 * 
 * @author Padma Dangal
 *
 */
public class ButtonsWithScrollBar extends JPanel implements ActionListener {

	private JButton  openButton;
	private JButton  saveButton;
	private JButton  clearButton;
	private JButton spellCheck;
	private JComboBox<String> misspelledWords;
	
	private JTextArea  textArea;
	
	private JScrollPane scrollPlane;
	
	/**
	 * Main Method
	 * @param args not used
	 */
	public static void main(String[] args) {
		
		    JFrame frame = new JFrame("NotePad +-");
			frame.setSize(640, 480);
		    
			frame.setContentPane(new ButtonsWithScrollBar());
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//frame.pack();
			frame.setVisible(true);
	}

	public ButtonsWithScrollBar(){
		
		// Creates the components
		openButton = new JButton("Open");
		openButton.setActionCommand("1");
		openButton.addActionListener(this);
		
		saveButton = new JButton("Save");
		saveButton.setActionCommand("2");
		saveButton.addActionListener(this);
		
		clearButton = new JButton("Clear");
		clearButton.setActionCommand("3");
		clearButton.addActionListener(this);
		
		spellCheck = new JButton("Spell Check");
		spellCheck.setActionCommand("4");
		spellCheck.addActionListener(this);
		
		misspelledWords = new JComboBox<String>();
		
		textArea = new JTextArea();
		
		textArea.setFont(new Font("Serif", Font.PLAIN, 12));
		textArea.setEditable(true);
		
		
		// Add the buttons to a panel
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1));
		panel.add(openButton);
		panel.add(saveButton);
		panel.add(clearButton);
		panel.add(spellCheck);
		panel.add(misspelledWords);


		JPanel jTextAreatPanel  = new JPanel();
		jTextAreatPanel.setLayout(new GridLayout(1,1));

		
		// Add scrolling capabilities to the textArea
		scrollPlane = new JScrollPane(textArea);
		scrollPlane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPlane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPlane.setPreferredSize(new Dimension(200, 100));
		
		// set the main JPanes layout
		setLayout(new BorderLayout());
		add(panel, BorderLayout.WEST);
		add(scrollPlane, BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
     
		switch(e.getActionCommand()){
		case "1":
			 InputStream input = null;
			 try {
					Path file = Paths.get("saveText.txt");

					input = Files.newInputStream(file);

					BufferedReader reader = new BufferedReader(new InputStreamReader(
							input));
					
					String line = null;
					line = reader.readLine();
					
					while(line != null){
						
						textArea.append(line + "\n");
				
						line =  reader.readLine();
					}
					input.close();
					reader.close();

				} catch (IllegalArgumentException iae) {
					System.out
							.println("an invalid combination of options is specified");
				} catch (UnsupportedOperationException uoe) {
					System.out.println("an unsupported option is specified");
				} catch (SecurityException se) {
					System.out
							.println("In the case of the default provider, and a security manager is installed, the checkRead method is invoked to check read access to the file.");
				} catch (IOException ex) {
					System.out.println("an I/O error occurs");
				}
			
			break;
			
		case "2":
			       
			try {
				//Writting the all text to the text file
				File file = new File("saveText.txt");
				
				FileOutputStream  outputStream = new FileOutputStream (file);
				
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
				bw.write(textArea.getText());
				
				bw.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			   
			break;
			
		case "3":
			   
			textArea.setText("");
			break;
		case "4":
			try {
				Path file = Paths.get("dictionary.txt");
				
				for (String inputWord : textArea.getText().split(" "))
				{
					inputWord = inputWord.toLowerCase();
					
					boolean foundWord = false;
					
					input = Files.newInputStream(file);
					BufferedReader reader = new BufferedReader(new InputStreamReader(
							input));
					
					String line = null;
					line = reader.readLine().trim().toLowerCase();
					
					while(line != null)
					{	
						if (line.equals(inputWord))
						{
							foundWord = true;
							break;
						}

						line = reader.readLine();
						
						if (line != null)
							line = line.trim().toLowerCase();
					}
					
					if (!foundWord)
						misspelledWords.addItem(inputWord);
					
					input.close();
					reader.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			break;
	}
  }
} 
