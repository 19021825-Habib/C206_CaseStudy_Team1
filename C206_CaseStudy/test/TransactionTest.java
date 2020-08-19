import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19021825, Aug 19, 2020 3:39:41 PM
 */

public class TransactionTest {
	private Transaction t1;
	private Transaction t2;

	
	private ArrayList<Transaction> transactionList;
	private ArrayList<Transaction> archivedList;
	
	
	public TransactionTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		t1 = new Transaction(1, 1, "Habib", 101, "Rice Cooker X19", "Exchange");
		t2 = new Transaction(2, 2, "Sophia", 101, "Electirc Oven R55", "Refund");

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
	public void tearDown() throws Exception {
		t1 = null;
		t2 = null;

	}




}
