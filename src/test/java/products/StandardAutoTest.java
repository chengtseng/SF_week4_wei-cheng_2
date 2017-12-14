package products;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import enums.Manufacture;
import exceptions.BadInputException;

public class StandardAutoTest {
	StandardAuto sa;
	
	@Before
	public void init() throws BadInputException {
		sa = new StandardAuto(
				"75082",
				Manufacture.TOYOTA,
				9800,
				"green",
				3000,
				new Date(2017, 5, 25),
				6,
				"12",
				0);
	} 
	
	@Test(expected=BadInputException.class)
	public void constructorException() throws BadInputException {
		sa = new StandardAuto(
				"75082",
				Manufacture.TOYOTA,
				0,
				"green",
				3000,
				new Date(2017, 5, 25),
				6,
				"12",
				0);
	} 
	
	@Test
	public void StandardAutoConstructorNotNullTest() {
		assertTrue(sa != null);
	}
	
	@Test
	public void StandardAutoConstructorTest() {
		assertTrue(sa.getVin() == "75082" &&
				sa.getManufacture() == Manufacture.TOYOTA &&
				sa.getRange() == 9800 &&
				sa.color == "green" &&
				sa.getBasePrice() == 3000 &&
				sa.getEmissionTestDate() != null &&
				sa.getNumberOfSeats() == 6 &&
				sa.getVehicleCode() == "12" &&
				sa.getLuxTax() == 0);
	}
	
	@Test
	public void getEmissionTestDateTest() {
		assertTrue(sa.getEmissionTestDate().getYear() == 2017 &&
				sa.getEmissionTestDate().getMonth() == 5 &&
				sa.getEmissionTestDate().getDate() == 25);
	}
	
	@Test
	public void setEmissionTestDateTest() {
		sa.setEmissionTestDate(new Date(2018, 3, 13));
		assertTrue(sa.getEmissionTestDate().getYear() == 2018 &&
				sa.getEmissionTestDate().getMonth() == 3 &&
				sa.getEmissionTestDate().getDate() == 13);
	}
	
	@Test
	public void getNumberOfSeatsTest() {
		assertEquals(6, sa.getNumberOfSeats());
	}
	
	@Test
	public void setNumberOfSeatsTest() {
		sa.setNumberOfSeats(4);
		assertEquals(4, sa.getNumberOfSeats());
	}

}
