/**
 * LCD Display for point of sale.
 * Displays only appropriate massages.
 * 
 *
 */
public class LcdDisplay {
        
	   private String display;
       
	    
	    private void display(String text){
	    	display = text;
	    }
	    
	    void displayProduct(Product pr){
	    	display( pr.getName() + " " + pr.getPrice() + "$");
	    }
	    
	    void displayProductNotFound(){
	    	display = "Product not found.";
	    }
	    
	    void displayInvalidBarCode(){
	    	display = "Invalid bar code.";
	    }
	    
	    void displayTotalSum(int sum){
	    	display = "Total Sum is:" + sum + " $";
	    }
	    
	    String getText(){
	    	return display;
	    }
} 
