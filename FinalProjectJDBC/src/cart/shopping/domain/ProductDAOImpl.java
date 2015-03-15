package cart.shopping.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
	
	private String driverClassName;
	private String jdbcURL;
	private String username;
	private String password;
	
	
/**
 * Parameterize constructor with database attributes for the connection
 * @param driverClassName
 * @param jdbcURL
 * @param username
 * @param password
 */
	public ProductDAOImpl(String driverClassName, String jdbcURL,String username, String password) {
		this.driverClassName = driverClassName;
		this.jdbcURL = jdbcURL;
		this.username = username;
		this.password = password;
	}

	/**
	 * This method will get all the products from the database and put into the ArrayList
	 * @return products
	 */
	public List<Product> getAllProducts() {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;

		List<Product> products = new ArrayList<Product>();
		try {
			connection = getConnection();
			statement = connection.createStatement();
			
			String query = "select * from products";
			
			result = statement.executeQuery(query);
			
			while(result.next()){
				
				String code = result.getString("code");
				String desc = result.getString("description");
				double price = result.getDouble("price");
				
				Product product = new Product();
				product.setCode(code);
				product.setDescription(desc);
				product.setPrice(price);
				
				//putting the product object in to the ArrayList
				products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (result != null) {
					result.close();
				}
				closeResources(statement, connection);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return products;
	}

	/**
	 * Creating the connection to the database
	 * @return connection
	 * @throws SQLException
	 */
	private Connection getConnection(){
		
			Connection con = null;
			try {
				
				Class.forName(driverClassName);
				con = DriverManager.getConnection(jdbcURL, username, password);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return con;
	}
	
	/**
	 * Closing the resources if it is not null.
	 * That is connection and the statement 
	 * @param statement
	 * @param connection
	 */
	private void closeResources(Statement statement, Connection connection) {
		try {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public boolean delete(String code) {
		
		boolean status = false;
		Connection connection = null;
		Statement statement = null;

		try {
			connection = getConnection();
			statement = connection.createStatement();
			
			String query = "Delete from products where code = '" + code + "'";
			
			if(statement.executeUpdate(query) > 0){
				status = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				closeResources(statement, connection);
		}
		return status;
	}
	
public boolean editProducts(String originalCode,String code, String description, double price) {
	
	boolean status = false;
	Connection connection = null;
	Statement statement = null;

	try {
		connection = getConnection();
		statement = connection.createStatement();
		
		String query = "Update products set code = '" + code + "', description = '" + description + "', price =" + price +" where code = '" + originalCode +"'";
		
	  if(statement.executeUpdate(query) > 0){
		  status = true;
	  }

	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
			closeResources(statement, connection);
	}
	return status;
	}
}
