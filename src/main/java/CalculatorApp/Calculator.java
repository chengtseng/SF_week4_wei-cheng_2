package CalculatorApp;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import enums.BoatType;
import enums.Manufacture;
import exceptions.BadInputException;
import products.Boat;
import products.DieselAuto;
import products.ElectricAuto;
import products.SemiTruck;
import products.StandardAuto;
import products.Vehicle;


public class Calculator {
	
	public static void main(String[] args) throws BadInputException {
		Calculator cal = new Calculator();
		Vehicle electric = new ElectricAuto(
				"508", Manufacture.TESLA, 300, "red", 5, true, 15000, "76", 153);
		
		Vehicle b = new Boat(BoatType.YACHT, 6800, 60000, "8047", "90210", 985000, false);
		Vehicle sa = new StandardAuto("75082", Manufacture.TOYOTA, 9800, "green", 3000, new Date(2017, 5, 25), 6, "12", 0);
		Vehicle st = new SemiTruck("7331", Manufacture.VOVO, 498, "yellow", 3, 3, 20000, "66", 3000);
		Vehicle da = new DieselAuto("764528", Manufacture.HUMMER, 100, "black", 6, 6, 8000, "54", 50);
		//cal.addVehicle(electric);
		//cal.addVehicle(b);//.87
		//cal.addVehicle(sa);
		//cal.addVehicle(st);
		cal.addVehicle(da);
		System.out.print(cal.totalCost);
	}

	
	private List<Vehicle> list;
	public int numOfVehicle;
	private double totalCost;
	
	public Calculator(){
		list = new LinkedList<Vehicle>();
		numOfVehicle = 0;
		totalCost = 0;
	}
	
	public void addVehicle(Vehicle v) {
		list.add(v);
		numOfVehicle++;
		totalCost += v.getCost();		
	}
	
	public String displayOrderInformation() {
		
		for(Vehicle v : list) {
			v.displayDetail();
		}
		
		String message = String.format("There are %d vehicles in your order, complete total of the order would be %f",
				 numOfVehicle, totalCost);
		
		return message;
	}

	public double getTotalCost() {
		return totalCost;
	}
	
}
