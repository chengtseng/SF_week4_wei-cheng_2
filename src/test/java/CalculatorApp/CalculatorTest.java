package CalculatorApp;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import enums.Manufacture;
import exceptions.BadInputException;
import products.ElectricAuto;
import products.StandardAuto;
import products.Vehicle;

public class CalculatorTest {
	Calculator calculator;	
	
	@Before
	public void init() {
		calculator = new Calculator();
	} 
	
	@Test
	public void testElectricVehiclePrice() throws BadInputException {
		Vehicle electric = new ElectricAuto(
				"508", Manufacture.TESLA, 300, "red", 5, true, 15000, "76", 153);
		
		calculator.addVehicle(electric);
		assertTrue( "WRONG PRICE FOR ELECTRIC AUTO", Math.abs(calculator.getTotalCost() - 487.21) <= 0.01);
	}
	
	@Test
	public void testStandardVehiclePrice() throws BadInputException {
		Vehicle standard = new StandardAuto(
				"75082", Manufacture.TOYOTA, 9800, "blue", 3000, new Date(), 6, "12", 0);
		
		calculator.addVehicle(standard);
		System.out.print(calculator.getTotalCost());
		assertTrue( "WRONG PRICE FOR STANDARD AUTO", Math.abs(calculator.getTotalCost() - 1915.36) <= 0.01);
	}
	
	@Test
	public void testDisplayOrderInformation() throws BadInputException {
		Vehicle electric = new ElectricAuto(
				"508", Manufacture.TESLA, 300, "red", 5, true, 15000, "76", 153);		
		calculator.addVehicle(electric);
		
		String str = calculator.displayOrderInformation();
		String[] arrs = str.split(" ");
		
		String expected = String.format("There are " + calculator.numOfVehicle + " vehicles in your order, complete total of the order would be " + calculator.getTotalCost());
		String[] ex = str.split(" ");
		
		boolean bool = true;
		
		for(int i = 0; i < arrs.length - 1; i++) {
			bool &= arrs[i].equals(ex[i]);		
		}	
		 
		
		assertTrue("displayOrderInformation is not working",bool);
	}
}
