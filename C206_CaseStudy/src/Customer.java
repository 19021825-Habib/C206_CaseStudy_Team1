/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19015781, 19 Aug 2020 9:52:30 am
 */

/**
 * @author 19015781
 *
 */
public class Customer {

	/**
	 * @param args
	 */
	private int customer_id;
	private String name;
	private String address;
	private String email;
	/**
	 * @param customer_id
	 * @param name
	 * @param address
	 * @param email
	 */
	public Customer(int customer_id, String name, String address, String email) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.address = address;
		this.email = email;
	}
	/**
	 * @return the customer_id
	 */
	public int getCustomer_id() {
		return customer_id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	
	

}
