import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	private Customer cust1;
	private Customer cust2;
	private Customer cust3;
	
	private ArrayList<Customer> CustomerList;
	
	public CustomerTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		cust1 = new Customer(1, "Dian", "223 Woodlands Street 11", "dian@gmail.com");
		cust2 = new Customer(2, "Li Ying", "550 Bedok View", "LiYing@hotmail.com");
		cust3 = new Customer(3, "Pravin", "123 Jurong West", "pravin@yahoo.com");

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
		CustomerMain.removeCustomer(CustomerList, cust1);		
		assertEquals("Test that Customer arraylist size is 1", 1, CustomerList.size());
		assertSame("Test that Customer is deleted", cust1, CustomerList.get(0));
		
		//Add another item. test The size of the list is 2? - normal
		//The item just added is as same as the second item of the list
		CustomerMain.removeCustomer(CustomerList, cust2);
		assertEquals("Test that Customer arraylist size is 2", 2, CustomerList.size());
		assertSame("Test that Customer is deleted", cust2, CustomerList.get(1));	
		
		//Add another item. test The size of the list is 3? - normal
		//The item just added is as same as the second item of the list
		CustomerMain.removeCustomer(CustomerList, cust3);
		assertEquals("Test that Customer arraylist size is 3", 3, CustomerList.size());
		assertSame("Test that Customer is deleted", cust3, CustomerList.get(2));	
	}
	@After
	public void tearDown() throws Exception {
		cust1 = null;
		cust2 = null;
		cust3 = null;
		CustomerList = null;

	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}