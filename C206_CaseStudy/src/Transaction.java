
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19021825, Aug 18, 2020 10:20:31 PM
 */

public class Transaction {
	private String id;
	private String actionTaken;

	public Transaction(String id, String actionTaken) {
		this.id = id;
		this.actionTaken = actionTaken;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getActionTaken() {
		return actionTaken;
	}


	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}
	
	
	
	

}
