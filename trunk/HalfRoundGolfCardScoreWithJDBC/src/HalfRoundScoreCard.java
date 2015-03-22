import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * This program hold the scores of 1 to 4 players calculating and holding the scores for the front 9 plus the total. 
 * The data base does not have to exist prior to executing this app
 * @author Padam Dangal
 *
 */
public class HalfRoundScoreCard {
	
	static Scanner scan = new Scanner(System.in);

	//The connection URL syntax of the derby data base
	private static String dbURL = "jdbc:derby:dangalDB;";		//jdbc:derby:dangalDB
	
	//Connection created between client and server
	 private static Connection connection = null;
	 
	 //SQL statement for the data base
	 private static Statement statement = null;
	 
	 //creation attribute for 'connection' object which will create the connection if the data base is already exist
	 private static String creationAttribute = "create=true;";	
	 
	// the name of the table in the dataBase
	 private static String tableName = "players";
	 
	
	/**
	 * This method look for the driver and create the connection to the data base
	 * It will check the table in the database and if it is not exist then it will create a new table 
	 * @param dbURL
	 * @param creationAttribute
	 * 
	 * @throws ClassNotFoundException
     * @throws ExceptionInInitializerError
     * @throws SQLException
     * 
	 * @return connection
	 */
	public static Connection createConnection(String dbURL, String creationAttribute ){
		
		 try {
			 //loading the driver 
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			 
			//getting the connection 
			 connection = DriverManager.getConnection(dbURL + creationAttribute); 
			
			// get the data that describes the this dataBase
			DatabaseMetaData dbmd = connection.getMetaData();
			
//			statement = connection.createStatement();
//			statement.execute("drop table " + tableName);
			
			// from that data, see if there is a table named 'players'. 
    		// at the time of creation, i discovered that the table names seem to be stored/retrived
    		// as caps, don't know why.
			ResultSet rs = dbmd.getTables(null, null,tableName.toUpperCase(), null);
	
			if(!rs.next())
			{
				// so if the resultSet is empty, the 'RESTAURANT' table does not exist.
				// thus create it
				statement = connection.createStatement();
				
				//creating the table in the data base
				statement.execute("create table players(PLAYERS_NAME varchar(20), ONE integer, TWO integer, THREE integer, FOUR integer, FIVE integer, SIX integer, SEVEN integer, EIGHT integer, NINE integer, OUT_FRONT integer)");
				
				//closing the statement
				statement.close();
			}
			
		// thrown by Class.forName(...) command if the class was not found
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Unable to load the jdbc.embeddedDriver.");
        	cnfe.printStackTrace();
		}catch (ExceptionInInitializerError eie) {
    			eie.printStackTrace();
    		} 
            // thrown by DriverManager.getConnection(dbURL) if a database access error occurs
            // see http://docs.oracle.com/javase/7/docs/api/java/sql/DriverManager.html#getConnection(java.lang.String)
            catch (SQLException sqle) {
            	System.out.println("SQL error");
    			sqle.printStackTrace();
    		}	
		 //returning the connection 
		return connection;
	}

	/**
	 * This method will Insert the data in to the table in the data base
	 */
	public static void addingNewPlayer(){
		//hard code each score includng a total.
		
		try {
					System.out.println("Enter the name of the Player?");
					String name = scan.next();
					
			//establishing the connection
			statement = connection.createStatement();
			
			//inserting the quries assign to the String variables
			String query="insert into " + tableName + " values ('" + name +"', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)";		
			
			//inserting the hard coded data into the table of the datbase
			statement.execute(query);
			
			//closing the statement
			statement.close();
			
			
		} catch (SQLException e) {
		   System.out.println("SQL Exception occurs");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method will reterive the data from the table from the data base
	 */
	public static void displayScoreCard(){
		
		 try {
			 
			 //getting the connection
			statement = connection.createStatement();
			
			//retriving the data from the database
			 ResultSet results = statement.executeQuery("select * from " + tableName);
			 
			 //Retrieves the Players_Name, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE and OUT_FRONT of this ResultSet object's columns. 
			 ResultSetMetaData rsmd = results.getMetaData();
			 
			 
			 System.out.println("\t\t\t\t Fort Cherry Golf Course");
			 // print the names of the above the table
			 int numberCols = rsmd.getColumnCount();
			 for (int i=1; i<=numberCols; i++) 
			 {
			     // extract each column name from the meta data and print them
			     System.out.print(rsmd.getColumnLabel(i)+"\t");  
			 }

			 //simply printing the line
			 System.out.println("\n--------------------------------------------------------------------------------------------------");
			 
			 // Reteriving all data one by one from the data base
			 while(results.next())
			 {
			     String players_Name = results.getString(1);
			     int ONE = results.getInt(2);
			     int TWO = results.getInt(3);
			     int THREE = results.getInt(4);
			     int FOUR = results.getInt(5);
			     int FIVE = results.getInt(6);
			     int SIX = results.getInt(7);
			     int SEVEN = results.getInt(8);
			     int EIGHT = results.getInt(9);
			     int NINE = results.getInt(10);
			     int OUT_FRONT = results.getInt(11);
			     
			     //printing the retrive data to the console
			     System.out.println(players_Name + "\t" + ONE + "\t" + TWO + "\t" + THREE + "\t" + FOUR + "\t" + FIVE + "\t" + SIX + "\t" + SEVEN + "\t" + EIGHT + "\t" + NINE + "\t" + OUT_FRONT);
			 }
			 
			 //closing the resultset and the statement
			 results.close();
			 statement.close();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method will close the statement and the connection to the data base
	 */
	public static void shutdown(){
	//releases the connection to the dB
		 try
	        {
	            if (statement != null)
	            {
	                statement.close();
	            }
	            if (connection != null)
	            {
	                DriverManager.getConnection(dbURL + ";shutdown=true");
	                connection.close();
	            }           
	        }
	        catch (SQLException sqle){
	      //there will always be successful shutdown indicating that Derby has shutdown  and that there is no connection. 
	        }
	}
	
	
	public static void calculateAndPost(){
		
		try {
			
			//connection.setAutoCommit(true);
			statement = connection.createStatement();
			
			
			 String players_Name = null;
			 int OUT_FRONT = 0;
			 String query = null;
			 String[] arayOfPlayersName = new String[4];
			 Integer[] arayOfOutFront = new Integer[4];
			 
			 
			 //retriving the data from the database
			ResultSet results = statement.executeQuery("select players_Name from " + tableName);
			
			int i=0;
			
			while(results.next()){
				arayOfPlayersName[i++] = results.getString(1);
			} 
				 
			 i =0; 
			 results = statement.executeQuery("select * from " + tableName);
			// for each player in the array of arrayOfPlayers
				//get its entire record
				//loop through each score and tally it
				 while(results.next()){
					 
				     players_Name = results.getString(1);
				     int ONE = results.getInt(2);
				     int TWO = results.getInt(3);
				     int THREE = results.getInt(4);
				     int FOUR = results.getInt(5);
				     int FIVE = results.getInt(6);
				     int SIX = results.getInt(7);
				     int SEVEN = results.getInt(8);
				     int EIGHT = results.getInt(9);
				     int NINE = results.getInt(10);
					 
				     OUT_FRONT =  ONE + TWO + THREE + FOUR + FIVE + SIX + SEVEN + EIGHT + NINE;
				     
				    	 arayOfOutFront[i++] = OUT_FRONT;
					
				 }
				 
				 
				 for ( i = 0; i < arayOfPlayersName.length; i++) {
					// update the players total score
					 query = "UPDATE " + tableName + " set OUT_FRONT = " + arayOfOutFront[i] + " where Players_Name = '" + arayOfPlayersName[i] + "'";
					 
					 statement.executeUpdate(query);
				}
				 //closing the resultset and the statement
				 results.close();
				 statement.close();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void playersInAlphabeticalOrder(){
		
		try {
			//connection.setAutoCommit(true);
			statement = connection.createStatement();
			
			//retriving the data from the database
			 ResultSet results = statement.executeQuery("select * from " + tableName + " ORDER BY Players_Name");
		
			 //Retrieves the Players_Name, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE and OUT_FRONT of this ResultSet object's columns. 
			 ResultSetMetaData rsmd = results.getMetaData();
			 
			 
			 System.out.println("\t\t\t\t Fort Cherry Golf Course");
			 // print the names of the above the table
			 int numberCols = rsmd.getColumnCount();
			 for (int i=1; i<=numberCols; i++) 
			 {
			     // extract each column name from the meta data and print them
			     System.out.print(rsmd.getColumnLabel(i)+"\t");  
			 }

			 //simply printing the line
			 System.out.println("\n--------------------------------------------------------------------------------------------------");
			 
			 // Reteriving all data one by one from the data base
			 while(results.next())
			 {
			     String players_Name = results.getString(1);
			     int ONE = results.getInt(2);
			     int TWO = results.getInt(3);
			     int THREE = results.getInt(4);
			     int FOUR = results.getInt(5);
			     int FIVE = results.getInt(6);
			     int SIX = results.getInt(7);
			     int SEVEN = results.getInt(8);
			     int EIGHT = results.getInt(9);
			     int NINE = results.getInt(10);
			     int OUT_FRONT = results.getInt(11);
			     
			     //printing the retrive data to the console
			     System.out.println(players_Name + "\t" + ONE + "\t" + TWO + "\t" + THREE + "\t" + FOUR + "\t" + FIVE + "\t" + SIX + "\t" + SEVEN + "\t" + EIGHT + "\t" + NINE + "\t" + OUT_FRONT);
			 }
			 //closing the resultset and the statement
			 results.close();
			 statement.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
public static void lowestToHighestScore(){
		
	try {
		//connection.setAutoCommit(true);
		statement = connection.createStatement();
		
		//retriving the data from the database
		 ResultSet results = statement.executeQuery("select * from " + tableName + " ORDER BY OUT_FRONT");
	
		 //Retrieves the Players_Name, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE and OUT_FRONT of this ResultSet object's columns. 
		 ResultSetMetaData rsmd = results.getMetaData();
		 
		 
		 System.out.println("\t\t\t\t Fort Cherry Golf Course");
		 // print the names of the above the table
		 int numberCols = rsmd.getColumnCount();
		 for (int i=1; i<=numberCols; i++) 
		 {
		     // extract each column name from the meta data and print them
		     System.out.print(rsmd.getColumnLabel(i)+"\t");  
		 }

		 //simply printing the line
		 System.out.println("\n--------------------------------------------------------------------------------------------------");
		 
		 // Reteriving all data one by one from the data base
		 while(results.next())
		 {
		     String players_Name = results.getString(1);
		     int ONE = results.getInt(2);
		     int TWO = results.getInt(3);
		     int THREE = results.getInt(4);
		     int FOUR = results.getInt(5);
		     int FIVE = results.getInt(6);
		     int SIX = results.getInt(7);
		     int SEVEN = results.getInt(8);
		     int EIGHT = results.getInt(9);
		     int NINE = results.getInt(10);
		     int OUT_FRONT = results.getInt(11);
		     
		     //printing the retrive data to the console
		     System.out.println(players_Name + "\t" + ONE + "\t" + TWO + "\t" + THREE + "\t" + FOUR + "\t" + FIVE + "\t" + SIX + "\t" + SEVEN + "\t" + EIGHT + "\t" + NINE + "\t" + OUT_FRONT);
		 }
		 //closing the resultset and the statement
		 results.close();
		 statement.close();
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	}


public static void higestToLowestScore(){
	
	try {
		//connection.setAutoCommit(true);
		statement = connection.createStatement();
		
		//retriving the data from the database
		 ResultSet results = statement.executeQuery("select * from " + tableName + " ORDER BY OUT_FRONT desc");
	
		 //Retrieves the Players_Name, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE and OUT_FRONT of this ResultSet object's columns. 
		 ResultSetMetaData rsmd = results.getMetaData();
		 
		 
		 System.out.println("\t\t\t\t Fort Cherry Golf Course");
		 // print the names of the above the table
		 int numberCols = rsmd.getColumnCount();
		 for (int i=1; i<=numberCols; i++) 
		 {
		     // extract each column name from the meta data and print them
		     System.out.print(rsmd.getColumnLabel(i)+"\t");  
		 }

		 //simply printing the line
		 System.out.println("\n--------------------------------------------------------------------------------------------------");
		 
		 // Reteriving all data one by one from the data base
		 while(results.next())
		 {
		     String players_Name = results.getString(1);
		     int ONE = results.getInt(2);
		     int TWO = results.getInt(3);
		     int THREE = results.getInt(4);
		     int FOUR = results.getInt(5);
		     int FIVE = results.getInt(6);
		     int SIX = results.getInt(7);
		     int SEVEN = results.getInt(8);
		     int EIGHT = results.getInt(9);
		     int NINE = results.getInt(10);
		     int OUT_FRONT = results.getInt(11);
		     
		     //printing the retrive data to the console
		     System.out.println(players_Name + "\t" + ONE + "\t" + TWO + "\t" + THREE + "\t" + FOUR + "\t" + FIVE + "\t" + SIX + "\t" + SEVEN + "\t" + EIGHT + "\t" + NINE + "\t" + OUT_FRONT);
		 }
		 //closing the resultset and the statement
		 results.close();
		 statement.close();
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public static void insertPlayersData(){

			System.out.println("Enter the name of the Players");
			String name = scan.next();
			System.out.println("Enter the hole you want to enter score for.");
			String hole = scan.next();
			System.out.println("Enter the score");
			int score = scan.nextInt();
			
			if(hole.endsWith("1")){
				hole = "ONE";
			}
			if(hole.endsWith("2")){
				hole = "TWO";
			}
			if(hole.endsWith("3")){
				hole = "THREE";
			}
			if(hole.endsWith("4")){
				hole = "FOUR";
			}
			if(hole.endsWith("5")){
				hole = "FIVE";
			}
			if(hole.endsWith("6")){
				hole = "SIX";
			}
			if(hole.endsWith("7")){
				hole = "SEVEN";
			}
			if(hole.endsWith("8")){
				hole = "EIGHT";
			}
			if(hole.endsWith("9")){
				hole = "NINE";
			}
			
			try {
				statement = connection.createStatement();

				ResultSet results = statement.executeQuery("select * from " + tableName);
         
				int ONE = 0;
			    int TWO = 0;
				int THREE = 0;
				int FOUR = 0;
				int FIVE = 0;
				int SIX = 0;
				int SEVEN = 0;
				int EIGHT = 0;
				int NINE = 0;
				int  OUT_FRONT = 0;
				
				while(results.next()){
					   
			         String players_Name = results.getString(1);
				     ONE = results.getInt(2);
				     TWO = results.getInt(3);
				     THREE = results.getInt(4);
				     FOUR = results.getInt(5);
				     FIVE = results.getInt(6);
				     SIX = results.getInt(7);
				     SEVEN = results.getInt(8);
				     EIGHT = results.getInt(9);
				     NINE = results.getInt(10);
							
				}
				
				if(checkingNameInDB(name)){
				String query = "UPDATE " + tableName + " set " + hole  +" = " + score + " where Players_Name = '" + name + "'";

				statement.executeUpdate(query);	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
}			

public static boolean checkingNameInDB(String name){
	
	boolean status = false;
	String players_Name = null;;

	try {
		statement = connection.createStatement();

		ResultSet results = statement.executeQuery("select * from " + tableName);
		
		while(results.next()){
		   players_Name = results.getString(1);
		   
		   if(players_Name.equalsIgnoreCase(name)){
			   status = true;
		   }
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return status;
}
/**
 * Main method will will execute up on running
 * @param args is not used
 */
public static void main(String[] args) {
	
	// Connecting to the dataBase
   createConnection(dbURL, creationAttribute);
    
    
    Scanner scan = new Scanner(System.in);

    int selection=0;
    do{
    	System.out.println("What would you like to do?");
        System.out.println("\t1) Add a new Player");
        System.out.println("\t2) Calculate and post the front 9 score");
        System.out.println("\t3) Display the Players in alphabetic order");
        System.out.println("\t4) Display the Players sorted lowest to highest score");
        System.out.println("\t5) Display the Players sorted highest to lowest score");
        System.out.println("\t6) Enter the player score");
        System.out.println("\t7) Quit");
          System.out.print("	    Choice: -->");
          
          selection = scan.nextInt();
        System.out.flush();
        
    if(selection == 1){
    //Adding new data from the data base
    addingNewPlayer();
    System.out.println("Players is successfully Added.");
    System.out.println();
    }else if(selection == 2){ 
    	
    	System.out.println("Calculating and posting the front 9 score:");
    	calculateAndPost();
    	displayScoreCard();
    	 System.out.println();
    	
    }
    else if(selection == 3){
    	System.out.println("The Players in alphabetic order:");
    	playersInAlphabeticalOrder();
    	 System.out.println();
    }
    else if(selection ==4){
    	System.out.println("The players sorted lowest to highest score:");
    	lowestToHighestScore();
    	 System.out.println();
    }else if(selection == 5){
    	System.out.println("The players sorted lowest to highest score:");
    	higestToLowestScore();
    	 System.out.println();
    }else if(selection == 6){
    	insertPlayersData();
    	displayScoreCard();
    	System.out.println();
    }else if (selection == 7){
    	System.out.println("You quit.\nThank you for playing this Game.");
    	System.exit(0);
    }else{
    	System.out.println("You have entered the wrong selection. Please Try again.");
    	 System.out.println();
    }
   
    }while(selection !=7);
    
    //closing the statement and connection to the database
    shutdown();
   }
}

/*
=========
OUT PUT
=========

PLAYERS_NAME	ONE	TWO	THREE	FOUR	FIVE	SIX	SEVEN	EIGHT	NINE	OUT_FRONT	
--------------------------------------------------------------------------------------
Amiel Jefferson	4	5	3	4	4	5	5	2	5	37
Tyus Jones		4	4	3	5	4	5	4	2	3	36
Quinn Cook		3	3	3	4	4	4	4	3	4	34
Grayson Allen	4	5	3	3	5	4	4	2	5	36*/

