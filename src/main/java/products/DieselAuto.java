package products;
import enums.CarType;
import enums.Manufacture;
import exceptions.BadInputException;

public class DieselAuto extends Automobile{	
	private int numberOfWheels;
	private int numberOfCylinders;

	public DieselAuto(String v, 
					Manufacture manufacture, 
					int range, 
					String color, 
					int numOfWheel, 
					int numOfCylin, 
					double basePrice, 
					String vCode, 
					double luxT) {
		
		super(v, manufacture, range, color, basePrice,vCode, luxT);
		
		//type specific
		this.numberOfCylinders = numOfCylin;
		this.numberOfWheels = numOfWheel;
		this.type = CarType.DIESEL;
		try {
			this.setRange(range);
		} catch (BadInputException e) {			
			e.printStackTrace();
		}
	}	
	
	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}

	public int getNumberOfCylinders() {
		return numberOfCylinders;
	}

	public void setNumberOfCylinders(int numberOfCylinders) {
		this.numberOfCylinders = numberOfCylinders;
	}

}
