package products;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import enums.CarType;
import enums.Manufacture;

import exceptions.BadInputException;

public class VehicleTest {
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
	
	@Test
	public void setRangeTest() throws BadInputException {
		ea.setRange(100);
		assertEquals("setRangeTest is not working", 100, ea.getRange());
	}
	
	@Test(expected = BadInputException.class)
	public void setRangeTestException() throws BadInputException {
		ea.setRange(0);
		assertEquals("setRangeTest is not working", 100, ea.getRange());
	}
	
	@Test
	public void getRangeTest() {
		assertEquals("getRange is not working", 300, ea.getRange());
	}

	@Test
	public void getVinTest() {
		assertEquals("getVin is not working", "508", ea.getVin());
	}
	
	@Test
	public void setVinTest() {
		ea.setVin("123");
		assertEquals("setVin is not working", "123", ea.getVin());
	}
	
	@Test
	public void getBasePriceTest() {
		assertTrue("getBasePrice is not working", Math.abs(15000 - ea.getBasePrice()) <= 0.1);
	}
	
	@Test
	public void setBasePriceTest() {
		ea.setBasePrice(0);
		assertTrue("setBasePrice is not working", ea.getBasePrice() - 0 <= 0.1);
	}

	@Test
	public void getVehicleCodeTest() {
		assertEquals("getVehicleCode is not working", "76", ea.getVehicleCode());
	}

	@Test
	public void setVehicleCodeTest() {
		ea.setVehicleCode("88");
		assertEquals("setVehicleCode is not working", "88", ea.getVehicleCode());
		
	}

	@Test
	public void isLimitableTest() {
		assertTrue(ea.isLimitable());
	}

	@Test
	public void setLimitableTest() {
		ea.setLimitable(false);
		assertTrue(!ea.isLimitable());
	}

	@Test
	public void getTypeTest() {		
		assertEquals("setType is not working", CarType.ELECTRIC, ea.getType());
	}

	@Test
	public void setTypeTest() {
		ea.setType(CarType.STANDARD);
		assertEquals("setType is not working", CarType.STANDARD, ea.getType());
	}

	@Test
	public void getLuxTaxTest() {
		assertTrue("getLuxTax is not working", (153 - ea.getLuxTax()) < 0.1);
	}

	@Test
	public void setLuxTaxTest() {
		ea.setLuxTax(99);
		assertTrue("setLuxTax is not working", (99 - ea.getLuxTax()) < 0.1);
	}
}
