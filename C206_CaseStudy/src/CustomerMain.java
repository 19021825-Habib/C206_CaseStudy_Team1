import java.util.ArrayList;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19015781, 18 Aug 2020 11:36:20 pm
 */

/**
 * @author 19015781
 *
 */

		public class CustomerMain {


			public static void main(String[] args) {

				ArrayList<Customer> CustomerList = new ArrayList<Customer>();

				CustomerList.add(new Customer(1, "Dian", "223 Woodlands Street 11", "dian@gmail.com"));
				CustomerList.add(new Customer(2, "Li Ying", "550 Bedok View", "LiYing@hotmail.com"));
				CustomerList.add(new Customer(3, "Pravin", "123 Jurong West", "pravin@yahoo.com"));

				int option = 0;

				while (option != 4) {

					CustomerMain.menu();
					option = Helper.readInt("Enter an option > ");

					if (option == 1) {
						// View 
						CustomerMain.viewAllCustomer(CustomerList);

					} else if (option == 2) {
						// Add 
						CustomerMain.setHeader("ADD CUSTOMER");
						
						Customer cust = inputCustomer();
						CustomerMain.addCustomer(CustomerList, cust);
						


					} else if (option == 3) {
						// Delete
						CustomerMain.setHeader("DELETE CUSTOMER");		
						
						Customer cust = getCustomer();
						CustomerMain.removeCustomer(CustomerList, cust);
						
					} else if (option == 4) {
						System.out.println("Bye!");
					} else {
						System.out.println("Invalid option");
					}

				}

			}

			public static void menu() {
				CustomerMain.setHeader("DISO TRACKING SYSTEM");
				System.out.println("1. View customer");
				System.out.println("2. Add customer");
				System.out.println("3. Delete customer");
				System.out.println("4. Quit");
				Helper.line(80, "-");

			}
			
			public static void setHeader(String header) {
				Helper.line(80, "-");
				System.out.println(header);
				Helper.line(80, "-");
			}

			public static String showAvailability(boolean isAvailable) {
				String avail;

				if (isAvailable == true) {
					avail = "Yes";
				} else {
					avail = "No";
				}
				return avail;
			}


		//View Customer
		public static String retrieveAllCustomer(ArrayList<Customer> CustomerList) {
			String output = "";

			for (int i = 0; i < CustomerList.size(); i++) {

				output += String.format("%-10s %-10s %-30s %-10s\n", CustomerList.get(i).getCustomer_id(),
					CustomerList.get(i).getName(), CustomerList.get(i).getAddress(), CustomerList.get(i).getEmail());

			}
			return output;
	}
		public static void viewAllCustomer(ArrayList<Customer> CustomerList) {
			CustomerMain.setHeader("CUSTOMER LIST");
			String output = String.format("%-10s %-10s %-30s %-10s\n", "ID", "NAME",
					"ADDRESS", "EMAIL");
			 output += retrieveAllCustomer(CustomerList);	
			System.out.println(output);
		}
		//Add Customer
		public static Customer inputCustomer() {
			int customer_id = Helper.readInt("Enter id > ");
			String name = Helper.readString("Enter name > ");
			String address = Helper.readString("Enter address > ");
			String email = Helper.readString("Enter email > ");


			Customer cust = new Customer(customer_id ,name, address, email);
			return cust;
			
		}
		public static void addCustomer(ArrayList<Customer> CustomerList, Customer cust) {
			
			CustomerList.add(cust);
			System.out.println("Customer added");
		}
		//Delete customer
		public static Customer getCustomer() {
			int customer_id = Helper.readInt("Enter id > ");
			String name = Helper.readString("Enter name > ");
			String address = Helper.readString("Enter address > ");
			String email = Helper.readString("Enter email > ");

			Customer cust = new Customer(customer_id ,name, address, email);
			return cust;
		}
		public static void removeCustomer(ArrayList<Customer> CustomerList, Customer cust) {
			for (int i = 0; i < CustomerList.size(); i++) {
				
				if (CustomerList.contains(cust)) {
					CustomerList.remove(cust);
				}else {
					System.out.println("Customer not found, please type again");
				}
			}
						
}
		}
