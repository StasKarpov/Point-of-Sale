/**
 * Catalog of products
 */
import java.util.HashMap;
import java.util.Map;

public class Database {
	private final Map<String, Product> mapOfProducts;

	public Database() {
		this.mapOfProducts = new HashMap<String, Product>();
	}

	boolean productExists(String code) {
		return mapOfProducts.containsKey(code);
	}
	
	Product getProduct(String code){
		return mapOfProducts.get(code);
	}
	
	String getProductName(String code){
		return mapOfProducts.get(code).getName();
	}

	Integer getProductPrice(String code) {
		return mapOfProducts.get(code).getPrice();
	}

	void add(String code, Product product) {
		mapOfProducts.put(code, product);
	}
}
