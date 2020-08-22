import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// Product
		ArrayList<HomeAppliances> haList = new ArrayList<HomeAppliances>();
		ArrayList<HomeFurnitures> hfList = new ArrayList<HomeFurnitures>();

		haList.add(new HomeAppliances(101, "Rice Cooker X19", "Deanne", 55.50, 5, 1));
		haList.add(new HomeAppliances(102, "Electric Oven R55", "Hanz", 105.20, 6, 3));
		hfList.add(new HomeFurnitures(201, "Storage Cabinet", "Alurea", 350.75, 4, "Oak"));
		hfList.add(new HomeFurnitures(202, "Study Table", "Chapmans", 95.50, 3, "Rosewood"));

		// Customer

		// Transaction

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
					ProductsMain.viewAllHomeAppliances(haList);
					ProductsMain.viewAllHomeFurnitures(hfList);
				} else if (prodChoice == 2) {
					// Adding a product
					ProductsMain.setHeader("ADD PRODUCT");
					ProductsMain.setHeader("PRODUCT TYPES");
					System.out.println("1. Home Appliances");
					System.out.println("2. Home Furnitures");

					int prodType = Helper.readInt("Enter option to select product type > ");

					if (prodType == 1) {
						// Adding an Appliance
						HomeAppliances ha = inputHomeAppliances();
						ProductsMain.addHomeAppliances(haList, ha);

					} else if (prodType == 2) {
						// Adding a Furniture
						HomeFurnitures hf = inputHomeFurnitures();
						ProductsMain.addHomeFurnitures(hfList, hf);

					} else {
						System.out.println("Please enter a valid option");
					}

				} else if (prodChoice == 3) {
					// Deleting a product
					ProductsMain.setHeader("DELETE PRODUCT");
					ProductsMain.setHeader("PRODUCT TYPES");
					System.out.println("1. Home Appliances");
					System.out.println("2. Home Furnitures");

					int prodType = Helper.readInt("Enter option to select product type > ");

					if (prodType == 1) {
						// Adding an Appliance
						ProductsMain.removeHomeAppliances(haList);

					} else if (prodType == 2) {
						// Adding a Furniture
						ProductsMain.removeHomeFurnitures(hfList);

					} else {
						System.out.println("Please enter a valid option");
					}

				} else if (prodChoice == 4) {
					// Updating number of returns
					ProductsMain.setHeader("UPDATE NO. OF RETURNS");
					ProductsMain.setHeader("PRODUCT TYPES");
					System.out.println("1. Home Appliances");
					System.out.println("2. Home Furnitures");

					int prodType = Helper.readInt("Enter option to select product type > ");

					if (prodType == 1) {
						// Update an Appliance
						ProductsMain.updateHomeAppliances(haList);

					} else if (prodType == 2) {
						// Update a Furniture
						ProductsMain.updateHomeFurnitures(hfList);

					} else {
						System.out.println("Please enter a valid option");
					}
				}

			} else if (option == 2) {
				// this would point out to Aisyah's main customer information class

			} else if (option == 3) {
				// this would point out to Habib's main transactions class

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
		ProductsMain.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. Display all Products");
		System.out.println("2. Add a product");
		System.out.println("3. Delete a product");
		System.out.println("4. Update number of returns");
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

	// TRANSACTION

	// PROCEDURE
	private static void procedureMenu() {
		Helper.line(50, "=");
		System.out.println("Procedures");
		Helper.line(50, "=");

		System.out.println("1. View all procedure");
		System.out.println("2. add procedure");
		System.out.println("3. delete procedure");

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
