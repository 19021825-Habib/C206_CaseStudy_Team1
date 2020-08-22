import java.util.ArrayList;

public class C206_CaseStudy {
	// Test
	static int archived_id = 0;
	static ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
	static ArrayList<Transaction> archivedList = new ArrayList<Transaction>();

	public static void main(String[] args) {
		// Product
		ArrayList<HomeAppliances> haList = new ArrayList<HomeAppliances>();
		ArrayList<HomeFurnitures> hfList = new ArrayList<HomeFurnitures>();

		haList.add(new HomeAppliances(101, "Rice Cooker X19", "Deanne", 55.50, 10, 1));
		haList.add(new HomeAppliances(102, "Electric Oven R55", "Hanz", 105.20, 5, 3));
		hfList.add(new HomeFurnitures(201, "Storage Cabinet", "Alurea", 350.75, 6, "Oak"));
		hfList.add(new HomeFurnitures(202, "Study Table", "Chapmans", 95.50, 8, "Rosewood"));

		// Customer
		ArrayList<Customer> CustomerList = new ArrayList<Customer>();

		CustomerList.add(new Customer(1, "Dian", "223 Woodlands Street 11", "dian@gmail.com", 3));
		CustomerList.add(new Customer(2, "Li Ying", "550 Bedok View", "LiYing@hotmail.com", 4));
		CustomerList.add(new Customer(3, "Pravin", "123 Jurong West", "pravin@yahoo.com", 5));

		// Transaction
		transactionList.add(new Transaction(1, 1, "Habib", 101, "Rice Cooker X19", "Exchange", 10));
		transactionList.add(new Transaction(2, 2, "Sophia", 101, "Electirc Oven R55", "Refund", 5));
		transactionList.add(new Transaction(3, 3, "Shun Kai", 101, "Storage Cabinet", "Exchange", 6));
		transactionList.add(new Transaction(4, 4, "Aiysha", 101, "Study Table", "Refund", 8));

		// Procedure
		ArrayList<Procedure> procedureList = new ArrayList<Procedure>();

		procedureList.add(new Procedure(1, "refund",
				"Step 1: Verify product returns request, Step 2: Verify customer's credentials and order information, Step 3: Process refund by reward points",
				"Completed"));
		procedureList.add(new Procedure(2, "exchange",
				"Step 1: Verify product exchange request, Step 2: Verify customer's credentials and order information, Step 3: exchange product",
				"Processing"));

		int option = 0;

		while (option != 5) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// this would point out to Sophia's main product class
				int prodChoice = 0;

				C206_CaseStudy.productMenu();
				prodChoice = Helper.readInt("Enter an option > ");

				if (prodChoice == 1) {
					// View all products
					C206_CaseStudy.viewAllHomeAppliances(haList);
					C206_CaseStudy.viewAllHomeFurnitures(hfList);
				} else if (prodChoice == 2) {
					// Adding a product
					C206_CaseStudy.setHeader("ADD PRODUCT");
					C206_CaseStudy.setHeader("PRODUCT TYPES");
					System.out.println("1. Home Appliances");
					System.out.println("2. Home Furnitures");

					int prodType = Helper.readInt("Enter option to select product type > ");

					if (prodType == 1) {
						// Adding an Appliance
						HomeAppliances ha = inputHomeAppliances();
						C206_CaseStudy.addHomeAppliances(haList, ha);

					} else if (prodType == 2) {
						// Adding a Furniture
						HomeFurnitures hf = inputHomeFurnitures();
						C206_CaseStudy.addHomeFurnitures(hfList, hf);

					} else {
						System.out.println("Please enter a valid option");
					}

				} else if (prodChoice == 3) {
					// Deleting a product
					C206_CaseStudy.setHeader("DELETE PRODUCT");
					C206_CaseStudy.setHeader("PRODUCT TYPES");
					System.out.println("1. Home Appliances");
					System.out.println("2. Home Furnitures");

					int prodType = Helper.readInt("Enter option to select product type > ");

					if (prodType == 1) {
						// Adding an Appliance
						C206_CaseStudy.removeHomeAppliances(haList);

					} else if (prodType == 2) {
						// Adding a Furniture
						C206_CaseStudy.removeHomeFurnitures(hfList);

					} else {
						System.out.println("Please enter a valid option");
					}

				} else if (prodChoice == 4) {
					// Updating number of returns
					C206_CaseStudy.setHeader("UPDATE NO. OF RETURNS");
					C206_CaseStudy.setHeader("PRODUCT TYPES");
					System.out.println("1. Home Appliances");
					System.out.println("2. Home Furnitures");

					int prodType = Helper.readInt("Enter option to select product type > ");

					if (prodType == 1) {
						// Update an Appliance
						C206_CaseStudy.updateHomeAppliances(haList);

					} else if (prodType == 2) {
						// Update a Furniture
						C206_CaseStudy.updateHomeFurnitures(hfList);

					} else {
						System.out.println("Please enter a valid option");
					}
				}

			} else if (option == 2) {
				// this would point out to Aisyah's main customer information class
				C206_CaseStudy.customerMenu();
				option = Helper.readInt("Enter an option > ");

				if (option == 1) {
					// View
					C206_CaseStudy.viewAllCustomer(CustomerList);

				} else if (option == 2) {
					// Add
					C206_CaseStudy.setHeader("ADD CUSTOMER");

					Customer cust = inputCustomer();
					C206_CaseStudy.addCustomer(CustomerList, cust);

				} else if (option == 3) {
					// Delete
					C206_CaseStudy.setHeader("DELETE CUSTOMER");
					C206_CaseStudy.removeCustomer(CustomerList);

				} else if (option == 4) {
					// Update
					C206_CaseStudy.setHeader("UPDATE RETURN HISTORY");
					C206_CaseStudy.updatereturn(CustomerList);

				}
			} else if (option == 3) {
				// this would point out to Habib's main transactions class
				transactionMenu();
				option = Helper.readInt("Enter choice > ");
				if (option == 1) {
					Transaction tc = inputTransaction();
					C206_CaseStudy.addTransaction(transactionList, tc);

				} else if (option == 2) {
					C206_CaseStudy.viewAllTransaction(transactionList);

				} else if (option == 3) {
					boolean isCheck = false;
					archived_id = Helper.readInt("Enter Transaction ID to be archived: ");
					for (int i = 0; i < transactionList.size(); i++) {
						if (archived_id == (transactionList.get(i).getTransaction_id())) {
							isCheck = true;
							Transaction t = transactionList.remove(i);
							archivedList.add(t);
							C206_CaseStudy.viewAllArchivedTransaction(archivedList);
						}

					}
					if (isCheck == false) {
						System.out.println("Invalid Transaction ID!! Please Try Again Later!!");
					}

				} else if (option == 4) {
					C206_CaseStudy.updateTransaction(transactionList);

				}

			} else if (option == 4) {
				// this would point out to Shun Kai's main procedures class
				procedureMenu();
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
					// Update item
					updateremark(procedureList);
				}

			} else if (option == 5) {
				System.out.println("Thank you for using Diso's Return Tracking System! Goodbye!");

			} else {
				System.out.println("Please enter a valid option!");
			}
		}
	}

	private static void menu() {
		Helper.line(80, "-");
		System.out.println("");
		Helper.line(80, "-");
		System.out.println("1. Manage Products");
		System.out.println("2. Manage Customer Information");
		System.out.println("3. Manage Transactions");
		System.out.println("4. Manage Procedures");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}

	// PRODUCTS
	private static void productMenu() {
		ProductsMain.setHeader("DISO TRACKING SYSTEM");
		System.out.println("1. Display all Products");
		System.out.println("2. Add a product");
		System.out.println("3. Delete a product");
		System.out.println("4. Update Number of Returns");
		Helper.line(80, "-");

	}

	static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// -------------------- OPTION 1 VIEW --------------------
	public static String retrieveHomeAppliances(ArrayList<HomeAppliances> haList) {
		String output = "";

		for (int i = 0; i < haList.size(); i++) {

			output += String.format("%-15d %-25s %-25s %-15.2f %-20d %-20d\n", haList.get(i).getProductID(),
					haList.get(i).getDescription(), haList.get(i).getVendorName(), haList.get(i).getPrice(),
					haList.get(i).getNoOfReturns(), haList.get(i).getWarrantyYears());
		}
		return output;
	}

	public static void viewAllHomeAppliances(ArrayList<HomeAppliances> haList) {
		ProductsMain.setHeader("HOME APPLIANCES");
		String output = String.format("%-15s %-25s %-25s %-15s %-20s %-20s\n", "PRODUCT ID", "DESCRIPTION",
				"VENDOR NAME", "PRICE", "NO. OF RETURNS", "WARRANTY (IN YEARS)");
		output += retrieveHomeAppliances(haList);
		System.out.println(output);
	}

	public static String retrieveHomeFurnitures(ArrayList<HomeFurnitures> hfList) {
		String output = "";

		for (int i = 0; i < hfList.size(); i++) {

			output += String.format("%-15d %-25s %-25s %-15.2f %-20d %-20s\n", hfList.get(i).getProductID(),
					hfList.get(i).getDescription(), hfList.get(i).getVendorName(), hfList.get(i).getPrice(),
					hfList.get(i).getNoOfReturns(), hfList.get(i).getMaterial());
		}
		return output;
	}

	public static void viewAllHomeFurnitures(ArrayList<HomeFurnitures> hfList) {
		ProductsMain.setHeader("HOME FURNITURES");
		String output = String.format("%-15s %-25s %-25s %-15s %-20s %-20s\n", "PRODUCT ID", "DESCRIPTION",
				"VENDOR NAME", "PRICE", "NO. OF RETURNS", "MATERIAL");

		output += retrieveHomeFurnitures(hfList);
		System.out.println(output);
	}

	// -------------------- OPTION 2 ADDING--------------------
	public static HomeAppliances inputHomeAppliances() {
		int id = Helper.readInt("Enter a Product ID: ");
		String description = Helper.readString("Enter Product Description: ");
		String venName = Helper.readString("Enter the Vendor's Name: ");
		double price = Helper.readDouble("Enter Product's price: ");
		int noOfReturns = Helper.readInt("Enter number of returns: ");
		int warYears = Helper.readInt("Enter Product Warranty (in Years): ");

		HomeAppliances ha = new HomeAppliances(id, description, venName, price, noOfReturns, warYears);
		return ha;
	}

	public static void addHomeAppliances(ArrayList<HomeAppliances> haList, HomeAppliances ha) {

		haList.add(ha);
		System.out.println("Home Furniture added!");
	}

	public static HomeFurnitures inputHomeFurnitures() {
		int id = Helper.readInt("Enter a Product ID: ");
		String description = Helper.readString("Enter Product Description: ");
		String venName = Helper.readString("Enter the Vendor's Name: ");
		double price = Helper.readDouble("Enter Product's price: ");
		int noOfReturns = Helper.readInt("Enter number of returns: ");
		String material = Helper.readString("Enter Product's material: ");

		HomeFurnitures hf = new HomeFurnitures(id, description, venName, price, noOfReturns, material);
		return hf;
	}

	public static void addHomeFurnitures(ArrayList<HomeFurnitures> hfList, HomeFurnitures hf) {

		hfList.add(hf);
		System.out.println("Home Furniture added!");
	}

	// -------------------- OPTION 3 DELETING--------------------

	public static void removeHomeAppliances(ArrayList<HomeAppliances> haList) {
		int id = Helper.readInt("Enter a Product ID: ");
		boolean deleted = false;
		for (int i = 0; i < haList.size(); i++) {
			if (haList.get(i).getProductID() == id) {
				deleted = true;
				haList.remove(i);
				System.out.println("Home Appliance deleted successfullly!");
			}
		}
		if (deleted == false) {
			System.out.println("Delete rejected, Appliance not found!");
		}
	}

	public static void removeHomeFurnitures(ArrayList<HomeFurnitures> hfList) {

		int id = Helper.readInt("Enter a Product ID: ");
		boolean deleted = false;
		for (int i = 0; i < hfList.size(); i++) {
			if (hfList.get(i).getProductID() == id) {
				deleted = true;
				hfList.remove(i);
				System.out.println("Home Furniture deleted successfullly!");
			}
		}
		if (deleted == false) {
			System.out.println("Delete rejected, Furniture not found!");
		}
	}

	// -------------------- OPTION 3 UPDATING--------------------

	public static void updateHomeAppliances(ArrayList<HomeAppliances> haList) {
		int id = Helper.readInt("Enter a Product ID: ");
		int noOfReturns = Helper.readInt("Enter number of returns: ");
		for (int i = 0; i < haList.size(); i++) {
			if (haList.get(i).getProductID() == id) {
				haList.get(i).setNoOfReturns(noOfReturns);
			}
		}
	}

	public static void updateHomeFurnitures(ArrayList<HomeFurnitures> hfList) {
		int id = Helper.readInt("Enter a Product ID: ");
		int noOfReturns = Helper.readInt("Enter number of returns: ");
		for (int i = 0; i < hfList.size(); i++) {
			if (hfList.get(i).getProductID() == id) {
				hfList.get(i).setNoOfReturns(noOfReturns);
			}
		}
	}

	// CUSTOMER
	public static void customerMenu() {
		CustomerMain.setHeader("DISO TRACKING SYSTEM");
		System.out.println("1. Display all Customers");
		System.out.println("2. Add a Customer");
		System.out.println("3. Delete a Customer");
		System.out.println("4. Update Customer Return History");
		Helper.line(80, "-");

	}

//View Customer
	public static String retrieveAllCustomer(ArrayList<Customer> CustomerList) {
		String output = "";

		for (int i = 0; i < CustomerList.size(); i++) {

			output += String.format("%-10d %-10s %-30s %-20s %-10d\n", CustomerList.get(i).getCustomer_id(),
					CustomerList.get(i).getName(), CustomerList.get(i).getAddress(), CustomerList.get(i).getEmail(),
					CustomerList.get(i).getNoOfReturns());

		}
		return output;
	}

	public static void viewAllCustomer(ArrayList<Customer> CustomerList) {
		CustomerMain.setHeader("CUSTOMER LIST");
		String output = String.format("%-10s %-10s %-30s %-20s %-10s\n", "ID", "NAME", "ADDRESS", "EMAIL", "RETURNS");
		output += retrieveAllCustomer(CustomerList);
		System.out.println(output);
	}

//Add Customer
	public static Customer inputCustomer() {
		int customer_id = Helper.readInt("Enter id > ");
		String name = Helper.readString("Enter name > ");
		String address = Helper.readString("Enter address > ");
		String email = Helper.readString("Enter email > ");
		int returns = Helper.readInt("Enter number of return >");

		Customer cust = new Customer(customer_id, name, address, email, returns);
		return cust;

	}

	public static void addCustomer(ArrayList<Customer> CustomerList, Customer cust) {

		CustomerList.add(cust);
		System.out.println("Customer added");
	}

//Delete customer
	public static void removeCustomer(ArrayList<Customer> CustomerList) {
		int id = Helper.readInt("Enter Cutomer ID >");
		boolean deleted = false;
		for (int i = 0; i < CustomerList.size(); i++) {
			if (CustomerList.get(i).getCustomer_id() == id) {
				CustomerList.remove(i);
				deleted = true;
				System.out.println("Customer deleted successfullly!");
			}
		}
		if (deleted == false) {
			System.out.println("Delete rejected, Customer not found!");
		}

	}

	public static void updatereturn(ArrayList<Customer> CustomerList) {
		int customer_id = Helper.readInt("Enter customer's id > ");
		int returns = Helper.readInt("Enter number of return to be updated > ");
		boolean isUpdate = false;
		for (int i = 0; i < CustomerList.size(); i++) {
			if (CustomerList.get(i).getCustomer_id() == customer_id) {
				CustomerList.get(i).setNoOfReturns(returns);
				isUpdate = true;
				System.out.println("Update Successfull!!");
			}
		}
		if (isUpdate == false) {
			System.out.println("Update Failed!!");
		}
	}

	// TRANSACTION
	public static void transactionMenu() {
		// TODO: P05 Task 1 - Write code here for the menu options.
		Helper.line(40, "-");
		System.out.println("DISO TRACKING SYSTEM");
		Helper.line(40, "-");

		System.out.println("1. Add a Transaction");
		System.out.println("2. View all Transactions");
		System.out.println("3. View Archived Transactions");
		System.out.println("4. Update Transaction");
	}

	// ================= Option 1 Add  =================
	public static Transaction inputTransaction() {
		int transaction_id = Helper.readInt("Enter Transaction ID > ");
		int cus_id = Helper.readInt("Enter Customer ID > ");
		String cus_name = Helper.readString("Enter Customer Name > ");
		int product_id = Helper.readInt("Enter Product ID > ");
		String product_desc = Helper.readString("Enter Product Description > ");
		String actionTaken = Helper.readString("Enter Action Taken > ");
		int noOfReturns = Helper.readInt("Enter Number of returns >");

		Transaction tc = new Transaction(transaction_id, cus_id, cus_name, product_id, product_desc, actionTaken,
				noOfReturns);
		return tc;

	}

	public static void addTransaction(ArrayList<Transaction> transactionList, Transaction tc) {

		transactionList.add(tc);
		System.out.println("Transaction added");
	}

	//  ================= Option 2 View  =================
	public static String retrieveAllTransaction(ArrayList<Transaction> transactionList) {
		String output = "";

		int transction_size = transactionList.size();
		for (int i = 0; i < transction_size; i++) {

			output += String.format("%-15d %-15d %-15s %-15d %-30s %-20s %-10d\n",
					transactionList.get(i).getTransaction_id(), transactionList.get(i).getCustomer_id(),
					transactionList.get(i).getCustomer_name(), transactionList.get(i).getProduct_id(),
					transactionList.get(i).getProduct_desc(), transactionList.get(i).getActionTaken(),
					transactionList.get(i).getNoOfReturns());
		}
		return output;
	}

	public static void viewAllTransaction(ArrayList<Transaction> transactionList) {
		TransactionMain.setHeader("TRANSACTION LIST");
		String output = String.format("%-15s %-15s %-15s %-15s %-30s %-20s %-10s\n", "TRANSACTION ID", "CUSTOMER ID",
				"CUSTOMER NAME", "PRODUCT ID", "PRODUCT DESCRIPTON", "ACTION TAKEN", "NO OF RETURNS");
		output += retrieveAllTransaction(transactionList);
		System.out.println(output);
	}

	//  ================= Option 3 View OLD archived  =================
	public static String retriveAllArchivedTransaction(ArrayList<Transaction> archivedList) {
		String output = "";

		int archived_size = archivedList.size();
		for (int i = 0; i < archived_size; i++) {

			output += String.format("%-15d %-15d %-15s %-15d %-30s %-20s %-10d\n",
					archivedList.get(i).getTransaction_id(), archivedList.get(i).getCustomer_id(),
					archivedList.get(i).getCustomer_name(), archivedList.get(i).getProduct_id(),
					archivedList.get(i).getProduct_desc(), archivedList.get(i).getActionTaken(),
					archivedList.get(i).getNoOfReturns());
		}
		return output;
	}

	public static void viewAllArchivedTransaction(ArrayList<Transaction> archivedList) {
		TransactionMain.setHeader("ARCHIVED LIST");
		String output = String.format("%-15s %-15s %-15s %-15s %-30s %-20s %-10s\n", "TRANSACTION ID", "CUSTOMER ID",
				"CUSTOMER NAME", "PRODUCT ID", "PRODUCT DESCRIPTON", "ACTION TAKEN", "NO OF RETURNS");
		output += retriveAllArchivedTransaction(archivedList);
		System.out.println(output);
	}

	//  ================= Option 4 Update  =================
	public static void updateTransaction(ArrayList<Transaction> transactionList) {
		int transaction_id = Helper.readInt("Enter Transaction ID to update > ");
		int num_Returns = Helper.readInt("Enter number of return to update > ");
		boolean isUpdate = false;
		for (int i = 0; i < transactionList.size(); i++) {
			if (transactionList.get(i).getTransaction_id() == transaction_id) {
				transactionList.get(i).setNoOfReturns(num_Returns);
				isUpdate = true;
			}
		}
		if (isUpdate == false) {
			System.out.println("Update Failed!!");
		}
	}

	// PROCEDURE
	private static void procedureMenu() {
		Helper.line(50, "=");
		System.out.println("DISO TRACKING SYSTEM");
		Helper.line(50, "=");
	
		System.out.println("1. View all Procedures");
		System.out.println("2. Add a Procedure");
		System.out.println("3. Delete a Procedure");
		System.out.println("4. Update Procedure Remarks");
		

	}

	public static void viewAllprocedure(ArrayList<Procedure> procedureList) {
		String output = "";
		output += String.format("%-20s %-20s %-150s %-100s\n", "Procedure ID", "Procedure Name",
				"Procedure Description", "Remarks");

		for (Procedure i : procedureList) {
			output += String.format("%-20d %-20s %-150s %-100s\n", i.getProcedure_id(), i.getProcedure_name(),
					i.getProcedure_description(), i.getComment());
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
		if (isDelete == false) {
			System.out.println("Delete Failed!!");
		}

	}

	public static void inputprocedure(Object procedureList, Procedure cc1) {
		// TODO Auto-generated method stub

	}

	public static void updateremark(ArrayList<Procedure> procedureList) {
		int chooseid = Helper.readInt("Enter the id that need to be updated");
		String updatecomment = Helper.readString("Enter the updated remark");
		for (int i = 0; i < procedureList.size(); i++) {
			if (procedureList.get(i).getProcedure_id() == chooseid) {
				procedureList.get(i).setComment(updatecomment);
			}
		}
	}

}
