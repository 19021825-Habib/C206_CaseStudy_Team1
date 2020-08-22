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
		
		transactionList.add(new Transaction(1, 1, "Habib", 101, "Rice Cooker X19", "Exchange", 10));
		transactionList.add(new Transaction(2, 2, "Sophia", 101, "Electirc Oven R55", "Refund", 5));
		transactionList.add(new Transaction(3, 3, "Shun Kai", 101, "Storage Cabinet", "Exchange", 6));
		transactionList.add(new Transaction(4, 4, "Aiysha", 101, "Study Table", "Refund", 8));
		
		int option = -1;

		while (option != 5) {

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
					if(archived_id == (transactionList.get(i).getTransaction_id())){
						isCheck = true;
						Transaction t = transactionList.remove(i);
						archivedList.add(t);
						TransactionMain.viewAllArchivedTransaction(archivedList);
					}
					
				}
				if(isCheck == false) {
					System.out.println("Invalid Transaction ID!! Please Try Again Later!!");
				}
				
				

			} else if (option == 4) {
				TransactionMain.updateTransaction(transactionList);
				
			}
			else if(option == 5) {
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
		System.out.println("4. Update Transaction");
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
		int noOfReturns = Helper.readInt("Enter Number of returns >");

		Transaction tc= new Transaction(transaction_id, cus_id, cus_name, product_id, product_desc, actionTaken, noOfReturns);
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

			output += String.format("%-15d %-15d %-15s %-15d %-30s %-20s %-10d\n", transactionList.get(i).getTransaction_id(), transactionList.get(i).getCustomer_id()
					, transactionList.get(i).getCustomer_name(), transactionList.get(i).getProduct_id(), transactionList.get(i).getProduct_desc(), transactionList.get(i).getActionTaken(), transactionList.get(i).getNoOfReturns() );
		}
		return output;
	}
	public static void viewAllTransaction(ArrayList<Transaction> transactionList) {
		TransactionMain.setHeader("TRANSACTION LIST");
		String output = String.format("%-15s %-15s %-15s %-15s %-30s %-20s %-10s\n", "TRANSACTION ID", "CUSTOMER ID", "CUSTOMER NAME", "PRODUCT ID", "PRODUCT DESCRIPTON","ACTION TAKEN", "NO OF RETURNS");
		 output += retrieveAllTransaction(transactionList);	
		System.out.println(output);
	}
	
	
	//================================= Option 3 View OLD archived =================================
	public static String retriveAllArchivedTransaction(ArrayList<Transaction> archivedList) {
		String output = "";

		int archived_size = archivedList.size();
		for (int i = 0; i < archived_size; i++) {

			output += String.format("%-15d %-15d %-15s %-15d %-30s %-20s %-10d\n", archivedList.get(i).getTransaction_id(), archivedList.get(i).getCustomer_id()
					, archivedList.get(i).getCustomer_name(), archivedList.get(i).getProduct_id(), archivedList.get(i).getProduct_desc(), archivedList.get(i).getActionTaken(), archivedList.get(i).getNoOfReturns());
		}
		return output;
	}
	
	public static void viewAllArchivedTransaction(ArrayList<Transaction> archivedList) {
		TransactionMain.setHeader("ARCHIVED LIST");
		String output = String.format("%-15s %-15s %-15s %-15s %-30s %-20s %-10s\n", "TRANSACTION ID", "CUSTOMER ID", 
				"CUSTOMER NAME", "PRODUCT ID", "PRODUCT DESCRIPTON","ACTION TAKEN", "NO OF RETURNS");
		output += retriveAllArchivedTransaction(archivedList);
		System.out.println(output);
	}
	
	
	//================================= Option 4 Update =================================
	public static void updateTransaction(ArrayList<Transaction> transactionList) {
		int transaction_id = Helper.readInt("Enter Transaction ID to update > ");
		int num_Returns = Helper.readInt("Enter number of return to update > ");
		boolean isUpdate = false;
		for(int i = 0; i < transactionList.size(); i++) {
			if(transactionList.get(i).getTransaction_id() == transaction_id) {
				transactionList.get(i).setNoOfReturns(num_Returns);
				isUpdate = true;
			}		
		}
		if(isUpdate == false) {
			System.out.println("Update Failed!!");
		}
	}
	
	

}
