package products;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import enums.Manufacture;

public class DieselAutoTest {
	public DieselAuto da;
	
	@Before
	public void init() {
		da = new DieselAuto(
				"764528",
				Manufacture.HUMMER,
				100,
				"black",
				6,
				6,
				8000,
				"54",
				50);
	}	
	
	@Test
	public void getNumberOfWheelsTest() {
		assertEquals("getNumberOfWheels is not working", 6, da.getNumberOfWheels());
	}
	
	@Test
	public void setNumberOfWheelsTest() {
		da.setNumberOfWheels(8);
		assertEquals("setNumberOfWheels is not working", 8, da.getNumberOfWheels());
	}
	
	@Test
	public void getNumberOfCylindersTest() {
		assertEquals("getNumberOfCylinders is not working", 6, da.getNumberOfCylinders());
	}
	
	@Test
	public void setNumberOfCylindersTest() {
		da.setNumberOfCylinders(8);
		assertEquals("setNumberOfCylinders is not working", 8, da.getNumberOfCylinders());
	}
}
