package products;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import enums.BoatType;
import exceptions.BadInputException;

public class BoatTest {
	Boat b;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void init() throws BadInputException {
		b = new Boat(BoatType.YACHT, 6800, 60000, "8047", "90210", 985000, false);
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}
	
	@Test(expected = BadInputException.class)
	public void testConstructorException() throws BadInputException {
		b = new Boat(BoatType.YACHT, 0, 60000, "8047", "90210", 985000, false);		
	}
	
	@Test
	public void displayDetailTest() {
		String[] expected = (BoatType.YACHT + " with VIN " + b.getVin() + 
				" is available to rent. This beauty has a range of " +
				b.getRange() + " and only costs $" + b.getCost()).split(" ");
				
		b.displayDetail();
		
		String[] actual =  outContent.toString().trim().split(" ");
		int length = actual.length;		
		boolean sameString = true;
		
		for(int i = 0; i < length - 1; i++) {
			sameString &= (actual[i].equals(expected[i]));
		}
		
		boolean sameValue = (Double.valueOf(actual[length - 1].substring(1)) - Double.valueOf(expected[length - 1].substring(1))) <= 0.1 ;
				
		assertTrue(sameValue && sameString);
	}
	
	@Test
	public void determineRangeTest() throws BadInputException {
		b.determineRange(5);
		assertEquals("determineRange not working", 5, b.getRange());
	}
	
	@Test(expected = BadInputException.class)
	public void determineRangeExceptionTest() throws BadInputException {
		b.determineRange(0);	
	}
	
	@Test
	public void isLimitableTest() {
		assertFalse(b.isLimitable());		
	}
	
	@Test
	public void setLimitableTest() {
		b.setLimitable(true);
		assertTrue(b.isLimitable());
	}

}
