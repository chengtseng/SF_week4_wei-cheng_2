package products;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import enums.Manufacture;
import exceptions.BadInputException;

public class ElectronicAutoTest {
	
	ElectricAuto ea;
	
	@Before
	public void init() throws BadInputException {
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
	
	@Test(expected=BadInputException.class)
	public void constructorExceptionTest() throws BadInputException {
		ea = new ElectricAuto("508",
				Manufacture.MAZDA,
				0,
				"blue",
				5,
				false,
				15000,
				"76",
				153);
	}
	
	@Test
	public void getNumberOfBatteriesTest() {
		assertEquals("getNumberOfBatteries not working", 5, ea.getNumberOfBatteries());
	}
	
	@Test
	public void setNumberOfBatteriesTest() {
		ea.setNumberOfBatteries(1);
		assertEquals("getNumberOfBatteries not working", 1, ea.getNumberOfBatteries());		
	}
	
	@Test
	public void isTelslaTest() {		
		assertFalse(ea.isTelsla());
	}
	
	@Test
	public void setTelslaTest() {
		ea.setTelsla(true);
		assertTrue(ea.isTelsla());
	}
}
