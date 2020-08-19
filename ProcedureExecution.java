
import java.util.ArrayList;

public class ProcedureExecution {

	public static void main(String[] args) {

		ArrayList<Procedure> procedureList = new ArrayList<Procedure>();

		procedureList.add(new Procedure(1, "refund",
				"Step 1: Verify product returns request, Step 2: Verify customer's credentials and order information, Step 3: Process refund by reqward points"));
		procedureList.add(new Procedure(2, "exchange",
				"Step 1: Verify product exchange request, Step 2: Verify customer's credentials and order information, Step 3: exchange product"));

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
				deleteprocedure(procedureList, getprocedure());

			} else {
				System.out.println("Invalid option");
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
		System.out.println("4. Quit");

	}

	public static void viewAllprocedure(ArrayList<Procedure> procedureList) {
		String output = "";
		output += String.format("%-10s %-30s %s\n", "Procedure ID", "Procedure Name", "Procedure Description");
		
		for (Procedure i : procedureList) {
			output += String.format("%-10d %-40s %s20\n", i.getProcedure_id(), i.getProcedure_name(), i.getProcedure_description());
		}
		System.out.println(output);
	}

	public static void inputprocedure(ArrayList<Procedure> procedureList) {
		int id = Helper.readInt("Enter id > ");
		String name = Helper.readString("Enter name > ");
		String description = Helper.readString("Enter description > ");

		procedureList.add(new Procedure(id, name, description));
		System.out.println("Procedure Added");
	}

	public static Procedure getprocedure() {
		int id = Helper.readInt("Enter id > ");
		String name = Helper.readString("Enter name > ");
		String description = Helper.readString("Enter description > ");

		Procedure Pro = new Procedure(id, name, description);
		return Pro;
	}

	public static void deleteprocedure(ArrayList<Procedure> procedureList, Procedure Pro) {
		for (int i = 0; i < procedureList.size(); i++) {
			if (procedureList.contains(Pro)) {
				procedureList.remove(Pro);
			} else {
				System.out.println("Procedure does not exist");
			}
		}
		System.out.println("Procedure deleted");
	}

}

