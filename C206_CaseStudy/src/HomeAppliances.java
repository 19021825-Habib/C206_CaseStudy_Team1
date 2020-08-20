
/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * 19001627, 17 Aug 2020 11:05:56 pm
 */

public class HomeAppliances extends Products {
	// Attributes
	private int warrantyYears;

	// Constructors
	public HomeAppliances(int productID, String description, String vendorName, double price, int noOfReturns,
			int warrantyYears) {
		super(productID, description, vendorName,price, noOfReturns);
		this.warrantyYears = warrantyYears;
	}

	// Getter Methods
	public int getWarrantyYears() {
		return warrantyYears;
	}
}
