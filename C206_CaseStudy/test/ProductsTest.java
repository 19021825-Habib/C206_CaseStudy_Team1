import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * 19001627, 19 Aug 2020 12:43:24 am
 */

public class ProductsTest {
	private HomeAppliances ha1;
	private HomeAppliances ha2;
	private HomeFurnitures hf1;
	private HomeFurnitures hf2;

	public ArrayList<HomeAppliances> haList;
	public ArrayList<HomeFurnitures> hfList;

	public ProductsTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		//preparing test data
		ha1 = new HomeAppliances(101, "Rice Cooker X19", "Deanne", 55.50 , 10, 1);
		ha2 = new HomeAppliances(102, "Electric Oven R55", "Hanz",105.20 ,5, 3);
		hf1 = new HomeFurnitures(201, "Storage Cabinet", "Alurea", 350.75,6,"Oak");
		hf2 = new HomeFurnitures(202, "Study Table", "Chapmans", 95.50,8,"Rosewood");
		
		haList = new ArrayList<HomeAppliances>();
		hfList = new ArrayList<HomeFurnitures>();
	}

	@Test
	public void addHomeAppliancesTest() {
		// Home Appliance list is not null, so that a new item can be added (Boundary)
		assertNotNull("Check if there is valid HomeAppliances arraylist to add to", haList);

		// Given an empty list, after adding 1st Appliance the size of the list should be 1 (Normal)
		// The appliance that was just added should be the first appliance in the HA list
		ProductsMain.addHomeAppliances(haList, ha1);
		assertEquals("Check that Home Appliances array list size is 1", 1, haList.size());
		assertSame("Check that Home Appliance is added", ha1, haList.get(0));

		// Given a list with 1 Appliances, after adding 2nd Furniture the size of the list should be 2 (Normal)
		// The Appliance that was added recently should be the second Appliance in the HA list
		ProductsMain.addHomeAppliances(haList, ha2);
		assertEquals("Check that Home Appliances array list size is 2", 2, haList.size());
		assertSame("Check that Home Appliance is added", ha1, haList.get(1));

	}
	
	@Test
	public void addHomeFurnituresTest() {
		// Home Furnitures is not null, so that a new item can be added (Boundary)
		assertNotNull("Check if there is valid HomeFurnitures arraylist to add to", hfList);

		// Given an empty list, after adding 1st Furniture the size of the list should be 1 (Normal)
		// The furniture that was just added should be the first furniture in the HF list
		ProductsMain.addHomeFurnitures(hfList, hf1);
		assertEquals("Check that Home Furnitures array list size is 1", 1, hfList.size());
		assertSame("Check that Home Furnitures is added", hf1, hfList.get(0));

		// Given a list with 1 furniture, after adding 2nd Furniture the size of the list should be 2 (Normal)
		// The furniture that was recently added should be the second furniture in the HF list
		ProductsMain.addHomeFurnitures(hfList, hf2);
		assertEquals("Check that Home Furnitures array list size is 2", 2, haList.size());
		assertSame("Check that Home Furnitures is added", hf2, hfList.get(1));
	}
	
	@Test
	public void retrieveAllHomeAppliancesTest(){
		//Test that Home Appliances list is not null but empty (Boundary)
		assertNotNull("Test if there is valid Home Appliances array list to retrieve product", haList);
		
		//Test if the list of Home Appliances retrieved from ProductsMain is empty (Boundary)
		String allHA = ProductsMain.retrieveHomeAppliances(haList);
		String testOutput = "";
		assertEquals("Check that ViewAllHomeAppliancesList", testOutput, allHA);
		
		//Given an empty list, after adding 2 Appliances the size of the list should be 2 (Normal)
		ProductsMain.addHomeAppliances(haList, ha1);
		ProductsMain.addHomeAppliances(haList, ha2);
		assertEquals("Test that Home Appliances array list size is 2",2, haList.size());
		
		//Test if the expected output string same as the list of Home Appliances retrieved from the Products
		String allAppliances = ProductsMain.retrieveHomeAppliances(haList);
		String testOutput1 = "";
		testOutput1 += String.format("%-15s %-25s %-25s %-15s %-20s %-20s\n", "101", "Rice Cooker X19", "Deanne", "55.50", "10" ,"1");
		testOutput1 += String.format("%-15s %-25s %-25s %-15s %-20s %-20s\n", "102", "Electric Oven R55", "Hanz", "105.20","5", "3");
		
		assertEquals("Test that ViewAllHomeAppliancesList", testOutput1, allAppliances);
	}
	
	@Test
	public void retrieveAllHomeFurnituresTest(){
		//Test that Home Furnitures list is not null but empty (Boundary)
		assertNotNull("Test if there is valid Home Furnitures array list to retrieve product", hfList);
		
		//Test if the list of Home Furnitures retrieved from ProductsMain is empty (Boundary)
		String allHF = ProductsMain.retrieveHomeFurnitures(hfList);
		String testOutput = "";
		assertEquals("Check that ViewAllHomeFurnituresList", testOutput, allHF);
		
		//Given an empty list, after adding 2 Furnitures the size of the list should be 2 (Normal)
		ProductsMain.addHomeFurnitures(hfList, hf1);
		ProductsMain.addHomeFurnitures(hfList, hf2);
		assertEquals("Test that Home Furnitures array list size is 2",2, hfList.size());
		
		//Test if the expected output string same as the list of Home Furnitures retrieved from the Products
		String allAppliances = ProductsMain.retrieveHomeAppliances(haList);
		String testOutput1 = ""; 
		testOutput1 += String.format("%-15s %-25s %-25s %-15s %-20s %-20s\n", "201", "Storage Cabinet", "Alurea", "350.75","6" ,"Oak");
		testOutput1 += String.format("%-15s %-25s %-25s %-15s %-20s %-20s\n", "202", "Study Table", "Chapmans", "95.50", "8","Rosewood");
				
		assertEquals("Test that ViewAllHomeAppliancesList", testOutput1, allAppliances);
	}
	
	@Test
	public void deleteHomeAppliancesTest() {
	// Home Appliance list is not null, so that a new item can be added (Boundary)
	assertNotNull("Check if there is valid HomeAppliances arraylist to delete to", haList);
	}
	
	@Test
	public void deleteHomeFurnituresTest() {
	// Home Furnitures list is not null, so that a new item can be added (Boundary)
	assertNotNull("Check if there is valid HomeFurnitures arraylist to delete to", hfList);
	}
	
	@After
	public void tearDown() throws Exception {
		ha1 = null;
		ha2 = null;
		hf1 = null;
		hf2 = null;
		haList = null;
		hfList = null;
	}

}
