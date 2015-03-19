import java.awt.GridLayout;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

/**
 * This is the Kiosk Application which will allow the customer to 
 * select the size of the pizza, allow them to add toppings, check the total price
 * with taxes and summit the order.
 * 
 * @author padma dangal
 * @version 1.0.0
 */
public class KioskApplication extends JPanel implements ActionListener, ItemListener{
	
	//selection message label
	private JLabel selectPizza;
	
	//radio buttons of the sizes of the pizza
	private JRadioButton smallPizza;
	private JRadioButton mediumPizza;
	private JRadioButton largePizza;
	
	//add toppings message label
	private JLabel addToppings;
	
	// check boxes of the toppings
	private JCheckBox extraCheese;
	private JCheckBox pepperoni;
	private JCheckBox sausage; 
	private JCheckBox greenPepers;
	private JCheckBox onions;
	private JCheckBox mushrooms;
	private JCheckBox pineapple;
	private JCheckBox ham;
	private JCheckBox anchovies;
	
	//message label shows the prices of toppings depending on size of the pizza
	private JLabel noteForToppings;
	private JLabel toppingPrices;
	
	//Price display message label
	private JLabel priceDisplay;
	
	//price display textfield
	private JTextField calculatedTotalPrice;
	
	//button to order submission
	private JButton orderButton;
	
	//assigning price of the Pizza
	final int SMALL_PIZZA_PRICE = 5;
	final int MEDIUM_PIZZA_PRICE = 6;
	final int LARGE_PIZZA_PRICE = 7;
	
	//Assigning the price of the toppings depending on size of the pizza
	final double SMALL_TOPPINGS_PRICE = 0.75;
	final double MEDIUM_TOPPINGS_PRICE = 1.00;
	final double LARGE_TOPPINGS_PRICE = 1.25;

	final double STATE_TAX = 0.07;   //7% tax
	double totalPrice;
	
	
	String pizzaSize;
	String toppingNames = "";
	
	public KioskApplication(){
		
		//mainpanel with 7, 1 grid layout
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(7, 1));
		
		//setBackground(Color.GREEN);
		
		//selectPizzaPanel with 1, 1 grid layout
		JPanel selectPizzaPanel = new JPanel();
		selectPizzaPanel.setLayout(new GridLayout(1, 1));
		
		selectPizza = new JLabel("Select the size of pizza to would like to buy");
		selectPizzaPanel.add(selectPizza);                                                // Panel 1
		
		//RadioButtonPanel with 1, 3 grid layout
		JPanel RadioButtonPanel = new JPanel();
		RadioButtonPanel.setLayout(new GridLayout(1, 3));
		
		// creating radio button for the radiobutton panel
		smallPizza = new JRadioButton("Small $" + SMALL_PIZZA_PRICE);
		smallPizza.setActionCommand("1");
		smallPizza.addActionListener(this);
		
		mediumPizza = new JRadioButton("Medium $" + MEDIUM_PIZZA_PRICE);
		mediumPizza.setActionCommand("2");
		mediumPizza.addActionListener(this);
		
		largePizza = new JRadioButton("Large $" + LARGE_PIZZA_PRICE , true);
		largePizza.setActionCommand("3");
		largePizza.addActionListener(this);
		
		//add to the button group
		ButtonGroup group = new ButtonGroup();
		group.add(smallPizza);
		group.add(mediumPizza);
		group.add(largePizza);
		
		// adding Radio buttons to the RadioButtonPanel
		RadioButtonPanel.add(smallPizza);
		RadioButtonPanel.add(mediumPizza);                                               // Panel 2
		RadioButtonPanel.add(largePizza);
				
		//addToppingsPanel with 1, 1 grid layout
		JPanel addToppingsPanel = new JPanel();
		addToppingsPanel.setLayout(new GridLayout(1, 1));
		
		addToppings = new JLabel("Add Toppings to your pizza");
		addToppingsPanel.add(addToppings);                                              // panel 3
		
		//checkBoxPanel with 3, 3 grid layout
		JPanel checkBoxPanel = new JPanel();
		checkBoxPanel.setLayout(new GridLayout(3, 3));
		
		//creating check box for checkbox panel
		 extraCheese = new JCheckBox("Extra Cheese");
		 pepperoni = new JCheckBox("Pepperoni");
		 sausage = new JCheckBox("Sausage"); 
		 greenPepers = new JCheckBox("Green Peppers");
		 onions = new JCheckBox("Onions");
		 mushrooms = new JCheckBox("Mushrooms");
		 pineapple = new JCheckBox("Pineapple");
		 ham = new JCheckBox("Ham");
		 anchovies = new JCheckBox("Anchovies");
		
		
		 //Adding check box to the checkBoxPanel
		 checkBoxPanel.add(extraCheese);
		 checkBoxPanel.add(pepperoni);
		 checkBoxPanel.add(sausage);
		 checkBoxPanel.add(greenPepers);
		 checkBoxPanel.add(onions);                                                      // Panel 4
		 checkBoxPanel.add(mushrooms);
		 checkBoxPanel.add(pineapple);
		 checkBoxPanel.add(ham);
		 checkBoxPanel.add(anchovies);
		
		//noteForToppingsPanel with 2, 1 grid layout
		 JPanel noteForToppingsPanel = new JPanel();
		 noteForToppingsPanel.setLayout(new GridLayout(2, 1));
		 
		noteForToppings = new JLabel("Note: Topping is based on size of the pizza");
		toppingPrices = new JLabel("Small $" + SMALL_TOPPINGS_PRICE + "       Medium $" + MEDIUM_TOPPINGS_PRICE + "       Large $" + LARGE_TOPPINGS_PRICE);
		
		noteForToppingsPanel.add(noteForToppings);                                       
		noteForToppingsPanel.add(toppingPrices);                                         //Panel 5
		
		//priceDisplayPanel  with 1, 2 grid layout
		JPanel priceDisplayPanel = new JPanel();
		priceDisplayPanel.setLayout(new GridLayout(1, 2));
		
		//creating label of the price display
		priceDisplay = new JLabel("Your Total Price with Tax: ");
		//creating text field of the total price
		calculatedTotalPrice = new JTextField(5);
		
		priceDisplayPanel.add(priceDisplay);
		priceDisplayPanel.add(calculatedTotalPrice);                                      // Panel 6
		
		//orderButtonPanel  with 1, 1 grid layout
		JPanel orderButtonPanel = new JPanel();
		orderButtonPanel.setLayout(new GridLayout(1, 1));
		
		orderButton = new JButton("Order Now");
		orderButton.setActionCommand("4");
		orderButton.addActionListener(this);
	    //orderButton.setMaximumSize(5);
		
		orderButtonPanel.add(orderButton);                                               // Panel 7
		
		//Adding all panels to the main panel
		mainPanel.add(selectPizzaPanel);         // panel 1
		mainPanel.add(RadioButtonPanel);         // panel 2
		mainPanel.add(addToppingsPanel);         // panel 3
		mainPanel.add(checkBoxPanel);            // panel 4
		mainPanel.add(noteForToppingsPanel);     // panel 5
		mainPanel.add(priceDisplayPanel);        // panel 6
		mainPanel.add(orderButtonPanel);         // panel 7
		
		//Adding main panel to the frame
		this.add(mainPanel);
		
		//adding item listener
		 extraCheese.addItemListener(this);
		 pepperoni.addItemListener(this);
		 sausage.addItemListener(this);
		 greenPepers.addItemListener(this);
		 onions.addItemListener(this);
		 mushrooms.addItemListener(this);
		 pineapple.addItemListener(this);
		 ham.addItemListener(this);
		 anchovies.addItemListener(this);
	}
	/**
	 * Main method Launch
	 * @param args not used
	 */
	public static void main(String[] args) {
		
	    JFrame frame = new JFrame("Kiosk Point of Sale Application");
		frame.setSize(400, 550);
	    
		frame.setContentPane(new KioskApplication());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//frame.pack();
		frame.setVisible(true);

	}
	/**
	 * This method will check if small, medium or large pizza is selected
	 * it will also check the toppings added to the pizza and keep adding those toppings to write in the text later
	 * Also increases the price as per the selected toppings and pizza
	 * 
	 * @param event - action applied on the method
	 */
	@Override
	public void itemStateChanged(ItemEvent event)
	   {
	      Object source = event.getSource();
	      int select = event.getStateChange();  
	      
	      double pizzaPrice;
	       
	      
	      //if small pizza radio button is selected
	     if(smallPizza.isSelected()){
	    	 pizzaPrice = SMALL_TOPPINGS_PRICE;
	     }
	     //if medium pizza radio button is selected
	     else if(mediumPizza.isSelected()){
	    	 pizzaPrice = MEDIUM_TOPPINGS_PRICE;
	    	
	     }
	     //if large pizza radio button is selected
	     else{
	    	 pizzaPrice = LARGE_TOPPINGS_PRICE;
	     }
	    	 
	    	
	   // Checking the check box selected and adding selected check box one by one 	 
	     //Also increasing the price as per the selected toppings
	      if(source == extraCheese){
	    	  
	           if(select == ItemEvent.SELECTED){
	        	   totalPrice += pizzaPrice;
	        	   toppingNames += " Extra Cheese";
	           }
	           else{
	        	   totalPrice -= pizzaPrice;
	           }
	      }
	      else if(source == pepperoni){
	    	  
	    	  if(select == ItemEvent.SELECTED){
	        	   totalPrice += pizzaPrice;
	        	   toppingNames += " Pepperoni";
	           }
	           else{
	        	   totalPrice -= pizzaPrice;
	           }
	      }
	      else if(source == sausage){
	    	  
	    	  if(select == ItemEvent.SELECTED){
	    		  totalPrice += pizzaPrice;
	    		  toppingNames += " Sausage";
	    	  }
	    	  else{
	    		  totalPrice -= pizzaPrice;
	    	  }
	      }
	      else if(source == greenPepers){
	    	  
	    	  if(select == ItemEvent.SELECTED){
	    		  totalPrice += pizzaPrice;
	    		  toppingNames += " Green Pepers";
	    	  }
	    	  else{
	    		  totalPrice -= pizzaPrice;
	    	  }
	      }
	      else if(source == onions){
	    	  
	    	  if(select == ItemEvent.SELECTED){
	    		  totalPrice += pizzaPrice;
	    		  toppingNames += " Onions";
	    	  }
	    	  else{
	    		  totalPrice -= pizzaPrice;
	    	  }
	      }
	      else if(source == mushrooms){
	    	  
	    	  if(select == ItemEvent.SELECTED){
	    		  totalPrice += pizzaPrice;
	    		  toppingNames += " Mushrooms";
	    	  }
	    	  else{
	    		  totalPrice -= pizzaPrice;
	    	  }
	      }
	      else if(source == pineapple){
	    	  
	    	  if(select == ItemEvent.SELECTED){
	    		  totalPrice += pizzaPrice;
	    		  toppingNames += " Pineapple";
	    	  }
	    	  else{
	    		  totalPrice -= pizzaPrice;
	    	  }
	      }
	      else if(source == ham){
	    	  
	    	  if(select == ItemEvent.SELECTED){
	    		  totalPrice += pizzaPrice;
	    		  toppingNames += " Ham";
	    	  }
	    	  else{
	    		  totalPrice -= pizzaPrice;
	    	  }
	      }
	      else if(source == anchovies){
	    	  
	    	  if(select == ItemEvent.SELECTED){
	    		  totalPrice += pizzaPrice;
	    		  toppingNames += " Anchovies";
	    	  }
	    	  else{
	    		  totalPrice -= pizzaPrice;
	    	  }
	      }
	      calculatedTotalPrice.setText("$" + (totalPrice + totalPrice * STATE_TAX));
	  }
	
	/**
	 * This method will perform action
	 * It will check which Pizza size is selected and assign the price according to their size.
	 * It will also write everything selected in the text file with the total price if order now button get hit.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		switch(e.getActionCommand()){
		case "1":
			totalPrice = SMALL_PIZZA_PRICE;
			pizzaSize = "SMALL";
			break;
			
		case "2":
			totalPrice = MEDIUM_PIZZA_PRICE;
			pizzaSize = "MEDIUM";
			break;
			
		case "3":
			totalPrice = LARGE_PIZZA_PRICE;
			pizzaSize = "LARGE";
			break;
		case "4":
			
			try {
				//Writting the all text to the text file
				File file = new File("orderList.txt");
				
				FileOutputStream  outputStream = new FileOutputStream (file);
				
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
				
				bw.write("Order Request");
				bw.newLine();
				bw.write("Pizza size:" + pizzaSize);
				bw.newLine();
				
				if(!toppingNames.equals(null) || toppingNames.equals("")){
				bw.write("Toppings: " + toppingNames);
				}
				bw.newLine();
				bw.write("Total Price: $" + (totalPrice + totalPrice * STATE_TAX));
				
				bw.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
			 largePizza.setSelected(true);
			
			 extraCheese.setSelected(false);
			 pepperoni.setSelected(false);
			 sausage.setSelected(false);
			 greenPepers.setSelected(false);
			 onions.setSelected(false);
			 mushrooms.setSelected(false);
			 pineapple.setSelected(false);
			 ham.setSelected(false);
			 anchovies.setSelected(false);
			 calculatedTotalPrice.setText("$" + (totalPrice + totalPrice * STATE_TAX));
			
			break;
		}
		calculatedTotalPrice.setText("$" + (totalPrice + totalPrice * STATE_TAX));
	}
}
