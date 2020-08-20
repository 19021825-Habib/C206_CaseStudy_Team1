
/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * 19001627, 17 Aug 2020 10:55:03 pm
 */

public class Products {
	// Attributes
	private int productID;
	private String description;
	private String vendorName;
	private double price;
	private int noOfReturns;

	// Constructor
	public Products(int productID, String description, String vendorName, double price, int noOfReturns) {
		this.productID = productID;
		this.description = description;
		this.vendorName = vendorName;
		this.price = price;
		this.noOfReturns = noOfReturns;
	}

	// Getter Methods
	public int getProductID() {
		return productID;
	}

	public String getDescription() {
		return description;
	}

	public String getVendorName() {
		return vendorName;
	}
	public double getPrice() {
		return price;
	}

	public int getNoOfReturns() {
		return noOfReturns;
	}
}
