package products;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import enums.Manufacture;
import exceptions.BadInputException;

public class AutomobileTest {
	
	ElectricAuto ea;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	
	@Before
	public void init() throws BadInputException {
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
		ea = new ElectricAuto("508",
				Manufacture.MAZDA,
				300,
				"blue",
				5,
				false,
				15000,
				"76",
				153);
	}
	
	@Test
	public void displayDetailTest() {
		ea.displayDetail();
		
		String expected = 
				String.format(
				"%s by %s with VIN %s is available to be rent in %s. This beast has a range of %d and only cost $%f unless range exceeded", 
				ea.type, ea.getManufacture(), ea.getVin(), ea.getColor(), ea.getRange(), ea.getCost());		
				
		assertEquals("displayDetail is not working", expected , outContent.toString().trim());
	}
	
	

}
