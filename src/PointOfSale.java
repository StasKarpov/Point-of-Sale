/**
 * Point of sale includes all necessary parts (database,I\O) 
 * and waits for a massage from scanner, then processing it.
 * 
 * @author Stanislav Karpov
 *
 */


public class PointOfSale{
	private Database database;
	private CodeScanner codeScanner;
	private Printer printer;
	private LcdDisplay lcdDisplay;
	
	private StringBuilder receipt;
	private int totalPrice;
	
	public PointOfSale(Database database,CodeScanner codeScanner,Printer printer, LcdDisplay lcdDisplay){
			this.database = database;
			this.codeScanner = codeScanner;
			this.printer = printer;
			this.lcdDisplay = lcdDisplay;
			receipt = new StringBuilder();
			totalPrice = 0;
	}
	
	
	void checkScanner(){
		String code = codeScanner.getCode();
		
		if(code == "") {//invalid massage
			lcdDisplay.displayInvalidBarCode();
		}
		else if(code == "exit") {//finish scanning and print a receipt
			receipt.append("\r\nTotally: " + totalPrice + " $");
			printer.printReceipt(receipt.toString());
			totalPrice = 0;
		}
		else if(!database.productExists(code)) {//check if product exist
			lcdDisplay.displayProductNotFound();
		}
		else{//display product and add it to receipt
		    lcdDisplay.displayProduct(database.getProduct(code));
		    receipt.append(database.getProductName(code)+" ");
		    receipt.append(database.getProductPrice(code)+" $");
		    receipt.append("\r\n");
		    totalPrice+=database.getProductPrice(code);
		    }
		
	}
	

	
}