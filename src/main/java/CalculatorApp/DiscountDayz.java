package CalculatorApp;

import java.util.Date;
import java.util.Random;

public class DiscountDayz {
	
	static boolean isDiscountDay;
	
	public static boolean isDiscountDay(Date date) {
		Random rand = new Random(2);
		int i = rand.nextInt();
		isDiscountDay = i % 2 == 0 ? true : false;
		return isDiscountDay;
	}
	
	public void setIsDiscountDay(boolean boo) {
		isDiscountDay = boo;
	}
}
