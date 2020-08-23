import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Proceduretest {
	
	private Procedure cc1;
	private Procedure cc2;
	private ArrayList<Procedure> procedureList;
	@Before
	public void setUp() throws Exception {
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
		ProcedureExecution.deleteprocedure(procedureList, cc1);		
		assertEquals("Test that Customer arraylist size is 1", 1, procedureList.size());
		assertSame("Test that Customer is deleted", cc1, procedureList.get(0));
		
		//Add another item. test The size of the list is 2? - normal
		//The item just added is as same as the second item of the list
		ProcedureExecution.deleteprocedure(procedureList, cc2);
		assertEquals("Test that Customer arraylist size is 2", 2, procedureList.size());
		assertSame("Test that Customer is deleted", cc2, procedureList.get(1));	
		
		
	}
	

	@After
	public void tearDown() throws Exception {
		cc1 = null;
		cc2 = null;
		procedureList = null;
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}

