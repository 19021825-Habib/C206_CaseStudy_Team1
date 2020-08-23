import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	//Customer
	private Customer cust1;
	private Customer cust2;
	private Customer cust3;
	
	private ArrayList<Customer> CustomerList;
	
	public void CustomerTest() {
	}
	
	@Before
	public void setUpCustomer() throws Exception {
		cust1 = new Customer(1, "Dian", "223 Woodlands Street 11", "dian@gmail.com", 3);
		cust2 = new Customer(2, "Li Ying", "550 Bedok View", "LiYing@hotmail.com", 4);
		cust3 = new Customer(3, "Pravin", "123 Jurong West", "pravin@yahoo.com", 5);

		CustomerList= new ArrayList<Customer>();
	}
	public void addCustomerTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid Customer arraylist to add to", CustomerList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		CustomerMain.addCustomer(CustomerList, cust1);		
		assertEquals("Test that Customer arraylist size is 1", 1, CustomerList.size());
		assertSame("Test that Customer is added", cust1, CustomerList.get(0));
		
		//Add another item. test The size of the list is 2? - normal
		//The item just added is as same as the second item of the list
		CustomerMain.addCustomer(CustomerList, cust2);
		assertEquals("Test that Customer arraylist size is 2", 2, CustomerList.size());
		assertSame("Test that Customer is added", cust2, CustomerList.get(1));
		
		//Add another item. test The size of the list is 3? - normal
		//The item just added is as same as the second item of the list
		CustomerMain.addCustomer(CustomerList, cust3);
		assertEquals("Test that Customer arraylist size is 2", 3, CustomerList.size());
		assertSame("Test that Customer is added", cust3, CustomerList.get(2));
	}
	@Test
	public void retrieveAllCustomerTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Customer arraylist to retrieve item", CustomerList);
		
		//test if the list of Customers retrieved from the SourceCentre is empty - boundary
		String allCustomer= CustomerMain.retrieveAllCustomer(CustomerList);
		String testOutput = "";
		assertEquals("Check that ViewAllCustomerlist", testOutput, allCustomer);
		
		//Given an empty list, after adding 3 items, test if the size of the list is 3 - normal
		CustomerMain.addCustomer(CustomerList, cust1);
		CustomerMain.addCustomer(CustomerList, cust2);
		CustomerMain.addCustomer(CustomerList, cust3);
		assertEquals("Test that Customer arraylist size is 3", 3, CustomerList.size());
		
		//test if the expected output string same as the list of Customers retrieved from the SourceCentre	
		allCustomer= CustomerMain.retrieveAllCustomer(CustomerList);
		testOutput = String.format("%-10s %-30s %-10s %-10s\n",1, "Dian", "223 Woodlands Street 11", "dian@gmail.com");
		testOutput += String.format("%-10s %-30s %-10s %-10s\n",2,"Li Ying", "550 Bedok View", "LiYing@hotmail.com");
		testOutput += String.format("%-10s %-30s %-10s %-10s\n",3, "Pravin", "123 Jurong West", "pravin@yahoo.com");
				
		assertEquals("Test that ViewAllCustomerlist", testOutput, allCustomer);
		
	}
	@Test
	public void removeCustomerTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid Customer arraylist to add to", CustomerList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		CustomerMain.removeCustomer(CustomerList);		
		assertEquals("Test that Customer arraylist size is 1", 1, CustomerList.size());
		assertSame("Test that Customer is deleted", cust1, CustomerList.get(0));
		
		//Add another item. test The size of the list is 2? - normal
		//The item just added is as same as the second item of the list
		CustomerMain.removeCustomer(CustomerList);
		assertEquals("Test that Customer arraylist size is 2", 2, CustomerList.size());
		assertSame("Test that Customer is deleted", cust2, CustomerList.get(1));	
		
		//Add another item. test The size of the list is 3? - normal
		//The item just added is as same as the second item of the list
		CustomerMain.removeCustomer(CustomerList);
		assertEquals("Test that Customer arraylist size is 3", 3, CustomerList.size());
		assertSame("Test that Customer is deleted", cust3, CustomerList.get(2));	
	}
	@After
	public void tearDownCustomer() throws Exception {
		cust1 = null;
		cust2 = null;
		cust3 = null;
		CustomerList = null;

	}

	
	//Products
	private HomeAppliances ha1;
	private HomeAppliances ha2;
	private HomeFurnitures hf1;
	private HomeFurnitures hf2;

	public ArrayList<HomeAppliances> haList;
	public ArrayList<HomeFurnitures> hfList;

	public void ProductsTest() {
	}
	
	@Before
	public void setUpProducts() throws Exception {
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
	public void tearDownProducts() throws Exception {
		ha1 = null;
		ha2 = null;
		hf1 = null;
		hf2 = null;
		haList = null;
		hfList = null;
	}
	
	//Transaction
	private Transaction t1;
	private Transaction t2;

	
	private ArrayList<Transaction> transactionList;
	private ArrayList<Transaction> archivedList;
	
	@Before
	public void setUpTransaction() throws Exception {
		t1 = new Transaction(1, 1, "Habib", 101, "Rice Cooker X19", "Exchange", 5);
		t2 = new Transaction(2, 2, "Sophia", 101, "Electirc Oven R55", "Refund", 5);

		transactionList = new ArrayList<Transaction>();
	}

	
	@Test
	public void addTransactionTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Transaction arraylist to add to", transactionList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		TransactionMain.addTransaction(transactionList, t1);
		assertEquals("Check that Transaction arraylist size is 1", 1, transactionList.size());
		assertSame("Check that Transaction is added", t1, transactionList.get(0));
				
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		TransactionMain.addTransaction(transactionList, t2);
		assertEquals("Check that Transaction arraylist size is 2", 2, transactionList.size());
		assertSame("Check that Transaction is added", t2, transactionList.get(1));
		
	}
	
	
	@Test
	public void retrieveAllTransactionTest() {
		//fail("Not yet implemented");
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Transaction arraylist to retrieve item from", transactionList);
		
		//test if the list of Transaction retrieved from the SourceCentre is empty - boundary
		String allTransaction = TransactionMain.retrieveAllTransaction(transactionList);
		String testOutput = "";
		assertEquals("Test that the retrieved transactionList is empty?", testOutput, allTransaction);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		TransactionMain.addTransaction(transactionList, t1);
		TransactionMain.addTransaction(transactionList, t2);
		assertEquals("Test addTransaction chromebook arraylist size is 2", 2, transactionList.size());
	}
	
	@Test
	public void retrieveAllArchivedTransactionTest() {
		//fail("Not yet implemented");
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid Archived Transaction arraylist to retrieve item from", archivedList);
		
		//test if the list of Archived Transaction retrieved from the SourceCentre is empty - boundary
		String allArchivedTransaction = TransactionMain.retriveAllArchivedTransaction(archivedList);
		String testOutput = "";
		assertEquals("Test that the retrieved archivedList is empty?", testOutput, allArchivedTransaction);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		TransactionMain.addTransaction(archivedList, t1);
		TransactionMain.addTransaction(archivedList, t2);
		assertEquals("Test  archived arraylist size is 2", 2, archivedList.size());
	}
	
	
	
	@After
	public void tearDownTransaction() throws Exception {
		t1 = null;
		t2 = null;

	}
	
	//Procedure
	private Procedure cc1;
	private Procedure cc2;
	private ArrayList<Procedure> procedureList;
	@Before
	public void setUpProcedure() throws Exception {
		cc1 = new Procedure(1, "refund",
				"Step 1: Verify product returns request, Step 2: Verify customer's credentials and order information, Step 3: Process refund by reqward points", "goodjob");
		cc2 = new Procedure(2, "exchange",
				"Step 1: Verify product exchange request, Step 2: Verify customer's credentials and order information, Step 3: exchange product", "completed");
		//ArrayList<Procedure> procedureList = new ArrayList<Procedure>();
		procedureList = new ArrayList<Procedure>();
	}
	
	public void addProcedure() {
		
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Camcorder arraylist to add to", procedureList);
		//Object procedureList;
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		ProcedureExecution.inputprocedure(procedureList, cc1);
		assertEquals("Check that Camcorder arraylist size is 1", 1, procedureList.size());
		assertSame("Check that Camcorder is added", cc1, procedureList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		ProcedureExecution.inputprocedure(procedureList, cc2);
		assertEquals("Check that Camcorder arraylist size is 2", 2, procedureList.size());
		assertSame("Check that Camcorder is added", cc2, procedureList.get(1));
	}
	
	
	public void deleteprocedureTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid Customer arraylist to add to", procedureList);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		ProcedureExecution.deleteprocedure(procedureList);		
		assertEquals("Test that Customer arraylist size is 1", 1, procedureList.size());
		assertSame("Test that Customer is deleted", cc1, procedureList.get(0));
		
		//Add another item. test The size of the list is 2? - normal
		//The item just added is as same as the second item of the list
		ProcedureExecution.deleteprocedure(procedureList);
		assertEquals("Test that Customer arraylist size is 2", 2, procedureList.size());
		assertSame("Test that Customer is deleted", cc2, procedureList.get(1));	
		
		
	}
	

	@After
	public void tearDownProcedure() throws Exception {
		cc1 = null;
		cc2 = null;
		procedureList = null;
	}

	





}
