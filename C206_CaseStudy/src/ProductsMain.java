import java.util.ArrayList;

/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * 19001627, 17 Aug 2020 10:57:55 pm
 */

public class ProductsMain {

	public static void main(String[] args) {
		ArrayList<HomeAppliances> haList = new ArrayList<HomeAppliances>();
		ArrayList<HomeFurnitures> hfList = new ArrayList<HomeFurnitures>();

		haList.add(new HomeAppliances(101, "Rice Cooker X19", "Deanne", 55.50, 5, 1));
		haList.add(new HomeAppliances(102, "Electric Oven R55", "Hanz", 105.20, 6, 3));
		hfList.add(new HomeFurnitures(201, "Storage Cabinet", "Alurea", 350.75, 4, "Oak"));
		hfList.add(new HomeFurnitures(202, "Study Table", "Chapmans", 95.50, 3, "Rosewood"));

		int option = 0;

		while (option != 4) {
			ProductsMain.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all products
				ProductsMain.viewAllHomeAppliances(haList);
				ProductsMain.viewAllHomeFurnitures(hfList);
			} else if (option == 2) {
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

			} else if (option == 3) {
				// Deleting a product
				ProductsMain.setHeader("DELETE PRODUCT");
				ProductsMain.setHeader("PRODUCT TYPES");
				System.out.println("1. Home Appliances");
				System.out.println("2. Home Furnitures");

				int prodType = Helper.readInt("Enter option to select product type > ");

				if (prodType == 1) {
					// Adding an Appliance
					HomeAppliances ha = getHomeAppliances();
					ProductsMain.removeHomeAppliances(haList, ha);

				} else if (prodType == 2) {
					// Adding a Furniture
					HomeFurnitures hf = getHomeFurnitures();
					ProductsMain.removeHomeFurnitures(hfList, hf);

				} else {
					System.out.println("Please enter a valid option");
				}

			} else if (option == 4) {
				System.out.println("Thank you for using our system! Goodbye");
			} else {
				System.out.println("Please enter a valid option");
			}
		}
	}

	private static void menu() {
		ProductsMain.setHeader("RESOURCE CENTRE APP");
		System.out.println("1. Display all Products");
		System.out.println("2. Add a product");
		System.out.println("3. Delete a product");
		System.out.println("4. Quit");
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
				"VENDOR NAME", "PRICE", "NO. OF RETURNS" ,"MATERIAL");

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
	public static HomeAppliances getHomeAppliances() {
		int id = Helper.readInt("Enter a Product ID: ");
		String description = Helper.readString("Enter Product Description: ");
		String venName = Helper.readString("Enter the Vendor's Name: ");
		double price = Helper.readDouble("Enter Product's price: ");
		int noOfReturns = Helper.readInt("Enter number of returns: ");
		int warYears = Helper.readInt("Enter Product Warranty (in Years): ");

		HomeAppliances ha = new HomeAppliances(id, description, venName, price, noOfReturns, warYears);
		return ha;

	}

	public static void removeHomeAppliances(ArrayList<HomeAppliances> haList, HomeAppliances ha) {

		haList.remove(ha);
		System.out.println("Home Appliance deleted successfullly!");
	}

	public static HomeFurnitures getHomeFurnitures() {
		int id = Helper.readInt("Enter a Product ID: ");
		String description = Helper.readString("Enter Product Description: ");
		String venName = Helper.readString("Enter the Vendor's Name: ");
		double price = Helper.readDouble("Enter Product's price: ");
		int noOfReturns = Helper.readInt("Enter number of returns: ");
		String material = Helper.readString("Enter Product's material: ");

		HomeFurnitures hf = new HomeFurnitures(id, description, venName, price, noOfReturns, material);
		return hf;

	}

	public static void removeHomeFurnitures(ArrayList<HomeFurnitures> hfList, HomeFurnitures hf) {

		hfList.remove(hf);
		System.out.println("Home Furniture deleted successfullly!");

	}
}
