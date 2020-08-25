

import java.util.ArrayList;

public class ProcedureExecution {
//terst
	public static void main(String[] args) {
		//try
		ArrayList<Procedure> procedureList = new ArrayList<Procedure>();

		procedureList.add(new Procedure(1, "refund",
				"Step 1: Verify product returns request, Step 2: Verify customer's credentials and order information, Step 3: Process refund by reward points", "Completed"));
		procedureList.add(new Procedure(2, "exchange",
				"Step 1: Verify product exchange request, Step 2: Verify customer's credentials and order information, Step 3: exchange product", "Processing"));
	//	remarkList.add(new Procedure("Good job"));

		int option = 0;

		while (option != 4) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				viewAllprocedure(procedureList);

			} else if (option == 2) {
				// Add item
				inputprocedure(procedureList);
				
			} else if (option == 3) {
				// Delete item
				deleteprocedure(procedureList);

			} else if (option == 4) {
				updateremark(procedureList);
			}
		}
	}

	private static void menu() {
		Helper.line(50, "=");
		System.out.println("Procedures");
		Helper.line(50, "=");

		System.out.println("1. View all procedure");
		System.out.println("2. add procedure");
		System.out.println("3. delete procedure");
		System.out.println("4. Update procedure");

	}

	public static void viewAllprocedure(ArrayList<Procedure> procedureList) {
		String output = "";
		output += String.format("%-20s %-20s %-150s %-100s\n", "Procedure ID", "Procedure Name", "Procedure Description", "Remarks");
		
		for (Procedure i : procedureList) {
			output += String.format("%-20d %-20s %-150s %-100s\n", i.getProcedure_id(), i.getProcedure_name(), i.getProcedure_description(), i.getComment());
		}
		System.out.println(output);
	}

	public static void inputprocedure(ArrayList<Procedure> procedureList) {
		int id = Helper.readInt("Enter id > ");
		String name = Helper.readString("Enter name > ");
		String description = Helper.readString("Enter description > ");
		String comment = Helper.readString("Enter your remark > ");

		procedureList.add(new Procedure(id, name, description, comment));
		System.out.println("Procedure Added");
	}


//test
	public static void deleteprocedure(ArrayList<Procedure> procedureList) {
		int id = Helper.readInt("Enter id > ");
		boolean isDelete = false;
		for (int i = 0; i < procedureList.size(); i++) {
			if (procedureList.get(i).getProcedure_id() == id) {
				isDelete = true;
				procedureList.remove(i);
				System.out.println("Procedure deleted");
			}
		}
		if(isDelete == false) {
			System.out.println("Delete Failed!!");
		}
		
	}

	public static void inputprocedure(Object procedureList, Procedure cc1) {
		// TODO Auto-generated method stub
		
	}
	
	public static void updateremark(ArrayList<Procedure> procedureList)  {
		int chooseid = Helper.readInt("Enter the id that need to be updated");
		String updatecomment = Helper.readString("Enter the updated remark");
		for (int i = 0; i < procedureList.size(); i++) {
			if (procedureList.get(i).getProcedure_id() == chooseid) {
				procedureList.get(i).setComment(updatecomment);
			}
		}
	}
}