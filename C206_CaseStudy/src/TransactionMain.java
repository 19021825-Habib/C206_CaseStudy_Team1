import java.util.ArrayList;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19021825, Aug 19, 2020 2:14:39 PM
 */

public class TransactionMain {
	static int archived_id = 0;
	static ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
	static ArrayList<Transaction> archivedList = new ArrayList<Transaction>();
	
	public static void main(String[] args) {
		
		transactionList.add(new Transaction(1, 1, "Habib", 101, "Rice Cooker X19", "Exchange"));
		transactionList.add(new Transaction(2, 2, "Sophia", 101, "Electirc Oven R55", "Refund"));
		transactionList.add(new Transaction(3, 3, "Shun Kai", 101, "Storage Cabinet", "Exchange"));
		transactionList.add(new Transaction(4, 4, "Aiysha", 101, "Study Table", "Refund"));
		
		int option = -1;

		while (option != 4) {

			menu();
			option = Helper.readInt("Enter choice > ");
			if (option == 1) {
				Transaction tc = inputTransaction();
				TransactionMain.addTransaction(transactionList, tc);

			} else if (option == 2) {
				TransactionMain.viewAllTransaction(transactionList);

			} else if (option == 3) {
				boolean isCheck = false;
				archived_id = Helper.readInt("Enter Transaction ID to be archived: ");
				for(int i = 0; i < transactionList.size(); i++) {
					if(archived_id  == (transactionList.get(i).getTransaction_id())){
						isCheck = true;
						archivedList.add(transactionList.get(archived_id));
						TransactionMain.viewAllArchivedTransaction(archivedList);
						transactionList.remove(archived_id);
					}
					
				}
				if(isCheck == false) {
					System.out.println("Invalid Transaction ID!! Please Try Again Later!!");
				}
				
				

			} else if (option == 4) {
				System.out.println("Thank you for using Diso Tracking System");
			}
			else {
				System.out.println("Invalid option!");
			}

		
		
		
		
		
		}

	}
	private static void menu() {
		//TODO: P05 Task 1 - Write code here for the menu options.
		Helper.line(40, "-");
		System.out.println("WELCOME TO DISO TRACKING SYSTEM");
		Helper.line(40, "-");
		
		System.out.println("1. Add Transaction");
		System.out.println("2. View Transaction");
		System.out.println("3. View Archived Transaction");
		System.out.println("4. Quit");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	
	
	//================================= Option 1 Add =================================
	public static Transaction inputTransaction() {
		int transaction_id = Helper.readInt("Enter Transaction ID > ");
		int cus_id = Helper.readInt("Enter Customer ID > ");
		String cus_name = Helper.readString("Enter Customer Name > ");
		int product_id = Helper.readInt("Enter Product ID > ");
		String product_desc = Helper.readString("Enter Product Description > ");
		String actionTaken = Helper.readString("Enter Action Taken > ");

		Transaction tc= new Transaction(transaction_id, cus_id, cus_name, product_id, product_desc, actionTaken);
		return tc;
		
	}
	public static void addTransaction(ArrayList<Transaction> transactionList, Transaction tc) {
		
		transactionList.add(tc);
		System.out.println("Transaction added");
	}
	
	
	
	//================================= Option 2 View =================================
	public static String retrieveAllTransaction(ArrayList<Transaction> transactionList) {
		String output = "";

		int transction_size = transactionList.size();
		for (int i = 0; i < transction_size; i++) {

			output += String.format("%-15d %-15d %-15s %-15d %-30s %s\n", transactionList.get(i).getTransaction_id(), transactionList.get(i).getCustomer_id()
					, transactionList.get(i).getCustomer_name(), transactionList.get(i).getProduct_id(), transactionList.get(i).getProduct_desc(), transactionList.get(i).getActionTaken()   );
		}
		return output;
	}
	public static void viewAllTransaction(ArrayList<Transaction> transactionList) {
		TransactionMain.setHeader("TRANSACTION LIST");
		String output = String.format("%-15s %-15s %-15s %-15s %-30s %s\n", "TRANSACTION ID", "CUSTOMER ID", "CUSTOMER NAME", "PRODUCT ID", "PRODUCT DESCRIPTON","ACTION TAKEN");
		 output += retrieveAllTransaction(transactionList);	
		System.out.println(output);
	}
	
	
	//================================= Option 2 View OLD archived =================================
	public static String retriveAllArchivedTransaction(ArrayList<Transaction> archivedList) {
		String output = "";

		int archived_size = archivedList.size();
		for (int i = 0; i < archived_size; i++) {

			output += String.format("%-15d %-15d %-15s %-15d %-30s %s\n", transactionList.get(archived_id).getTransaction_id(), transactionList.get(archived_id).getCustomer_id()
					, transactionList.get(archived_id).getCustomer_name(), transactionList.get(archived_id).getProduct_id(), transactionList.get(archived_id).getProduct_desc(), transactionList.get(archived_id).getActionTaken()   );
		}
		return output;
	}
	
	public static void viewAllArchivedTransaction(ArrayList<Transaction> archivedList) {
		TransactionMain.setHeader("ARCHIVED LIST");
		String output = String.format("%-15s %-15s %-15s %-15s %-30s %s\n", "TRANSACTION ID", "CUSTOMER ID", 
				"CUSTOMER NAME", "PRODUCT ID", "PRODUCT DESCRIPTON","ACTION TAKEN");
		output += retriveAllArchivedTransaction(archivedList);
		System.out.println(output);
	}
	

}