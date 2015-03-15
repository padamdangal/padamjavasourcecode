package cart.shopping.domain;

import java.util.List;

public interface ProductDAO {

	List<Product> getAllProducts();
	
	public boolean delete(String code);
	
	public boolean editProducts(String originalCode, String code, String description, double price);
		
}
