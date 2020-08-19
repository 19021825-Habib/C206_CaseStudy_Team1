
/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * 19001627, 17 Aug 2020 10:55:03 pm
 */

public class Products {
	// attributes
	private int productID;
	private String description;
	private String vendorName;
	private double price;

	// Constructor
	public Products(int productID, String description, String vendorName, double price) {
		this.productID = productID;
		this.description = description;
		this.vendorName = vendorName;
		this.price = price;
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

}
