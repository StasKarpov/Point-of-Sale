import static org.junit.Assert.*;
import org.junit.Test;



public class ProductsSaleTest {
    private Database database = new Database();
    private CodeScanner scanner = new CodeScanner();
    private Printer printer = new Printer();
    private LcdDisplay display = new LcdDisplay();
    
    PointOfSale pointOfSale = new PointOfSale(database,scanner,printer,display);
    
	@Test
	public void productOnDisplay() {
		database.add("12345", new Product("Bread",2));
		scanner.setCode("12345");
		pointOfSale.checkScanner();
		
		assertEquals("Bread 2$", display.getText());
	}
	
	@Test
	public void invalidBarCodeOnDisplay() {
		scanner.setCode("");
		pointOfSale.checkScanner();
		
		assertEquals("Invalid bar code.",display.getText());
	}
	
	@Test 
	public void productNotFoundOnDisplay() {
		scanner.setCode("11111");
		pointOfSale.checkScanner();
		
		assertEquals("Product not found.", display.getText());
	}
	
	@Test
	public void receiptIsPrinted() {
		database.add("12345", new Product("Bread",2));
		database.add("11111", new Product("Milk",3));
		
		scanner.setCode("11111");
		pointOfSale.checkScanner();
		scanner.setCode("12345");
		pointOfSale.checkScanner();
		scanner.setCode("exit");
		pointOfSale.checkScanner();
		
		assertEquals("Milk 3 $\r\nBread 2 $\r\n\r\nTotally: 5 $",printer.getReceipt());
	}

}
