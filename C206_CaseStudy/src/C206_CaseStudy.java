import java.util.ArrayList;

public class C206_CaseStudy {
	static ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
	static ArrayList<Transaction> archivedList = new ArrayList<Transaction>();

	public static void main(String[] args) {
		
		int option = -1;

		while (option != 4) {

			menu();
			option = Helper.readInt("Enter choice > ");
			if (option == 1) {
				Transaction tc = inputTransaction();
				C206_CaseStudy.addTransaction(transactionList, tc);

			} else if (option == 2) {
				C206_CaseStudy.viewAllTransaction(transactionList);

			} else if (option == 3) {
				String archived_id = Helper.readString ("Enter Transaction ID to be archived: ");
				for(int i = 0; i < transactionList.size(); i++) {
					if(archived_id.equals(transactionList.get(i).getId())) {
						archivedList.add(new Transaction(archived_id, transactionList.get(i).getActionTaken()));
					}	
				}
				C206_CaseStudy.viewAllArchivedTransaction(archivedList);
				

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
		String id = Helper.readString("Enter Transaction id > ");
		String actionTaken = Helper.readString("Enter Action Taken > ");

		Transaction tc= new Transaction(id, actionTaken);
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

			output += String.format("%-10s %-10s\n", transactionList.get(i).getId(), transactionList.get(i).getActionTaken());
		}
		return output;
	}
	public static void viewAllTransaction(ArrayList<Transaction> transactionList) {
		C206_CaseStudy.setHeader("TRANSACTION LIST");
		String output = String.format("%-10s %-10s\n", "ID", "ACTION TAKEN");
		 output += retrieveAllTransaction(transactionList);	
		System.out.println(output);
	}
	
	
	//================================= Option 2 View OLD archived =================================
	public static String retriveAllArchivedTransaction(ArrayList<Transaction> archivedList) {
		String output = "";

		int archived_size = archivedList.size();
		for (int i = 0; i < archived_size; i++) {

			output += String.format("%-10s %-10s\n", archivedList.get(i).getId(), archivedList.get(i).getActionTaken());
		}
		return output;
	}
	
	public static void viewAllArchivedTransaction(ArrayList<Transaction> archivedList) {
		C206_CaseStudy.setHeader("ARCHIVED LIST");
		String output = String.format("%-10s %-10s\n", "ID", "ACTION TAKEN");
		output += retriveAllArchivedTransaction(archivedList);
		System.out.println(output);
	}
	
	
	
}
