package products;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import enums.Manufacture;
import exceptions.BadInputException;

public class SemiTruckTest {
	SemiTruck st;
	
	@Before
	public void init() throws BadInputException {
		st = new SemiTruck("7331", Manufacture.VOVO, 498, "yellow", 3, 3, 20000, "66", 3000);
		
	}
	
	@Test(expected = BadInputException.class)
	public void BadInputExceptionTest() throws BadInputException {
		st = new SemiTruck("7331", Manufacture.VOVO, 0, "yellow", 3, 3, 20000, "66", 3000);
	}
	
	@Test
	public void semiTruckConstructorTest() {
		assertTrue("SemiTruck constructor error!", 
				st.getVin().equals("7331") &&
				st.getManufacture().equals(Manufacture.VOVO) &&
				st.getRange() == 498 &&
				st.getColor().equals("yellow") &&
				st.getNumberOfWheels() == 3 &&
				st.getNumberOfCylinders() == 3 &&
				st.getBasePrice() == 20000 &&
				st.getVehicleCode().equals("66") &&
				st.getLuxTax() == 3000);
	}
}
