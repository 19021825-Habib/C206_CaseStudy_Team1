
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19021825, Aug 18, 2020 10:20:31 PM
 */

public class Transaction {
	private int transaction_id;
	private int customer_id;
	private String customer_name;
	private int product_id;
	private String product_desc;
	private String actionTaken;
	private int noOfReturns;


	public Transaction(int transaction_id, int customer_id, String customer_name, int product_id,
			String product_desc, String actionTaken, int noOfReturns) {
		this.transaction_id = transaction_id;
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.product_id = product_id;
		this.product_desc = product_desc;
		this.actionTaken = actionTaken;
		this.noOfReturns = noOfReturns;
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public String getActionTaken() {
		return actionTaken;
	}

	public int getProduct_id() {
		return product_id;
	}

	public String getProduct_desc() {
		return product_desc;
	}


	public int getCustomer_id() {
		return customer_id;
	}


	public String getCustomer_name() {
		return customer_name;
	}


	public int getNoOfReturns() {
		return noOfReturns;
	}


	public void setNoOfReturns(int noOfReturns) {
		this.noOfReturns = noOfReturns;
	}
	

}
