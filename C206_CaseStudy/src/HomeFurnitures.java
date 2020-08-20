
/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * 19001627, 17 Aug 2020 10:55:39 pm
 */

public class HomeFurnitures extends Products {
	// Attributes
	private String material;

	// Constructors
	public HomeFurnitures(int productID, String description, String vendorName, double price,int noOfReturns, String material) {
		super(productID, description, vendorName, price, noOfReturns);
		this.material = material;
	}

	// Getter Methods
	public String getMaterial() {
		return material;
	}

}
