package products;
import enums.BoatType;
import exceptions.BadInputException;

public class Boat extends Vehicle{	
	public Boat(BoatType type, 
				int range, 
				double luxT, 
				String vCode, 
				String vin, 
				double bPrice, 
				boolean limit) throws BadInputException {
		
		this.type = type;		
		
		//different type of boats have different tax amount
		this.luxTax = luxT;
		
		this.vehicleCode = vCode;
		this.vin = vin;
		this.basePrice = bPrice;
		this.limitable = limit;
		
		//special requirement for boat
		try {
			setRange(range);
		} catch (BadInputException e) {			
			throw e;
		}
		this.range *= 7;
	}	
	
	@Override
	public void displayDetail() {
		System.out.printf(
				"%s with VIN %s is available to rent. This beauty has a range of %d and only costs $%f \n", this.type, this.vin, this.range, getCost());		
	}

	@Override
	public void determineRange(int r) throws BadInputException {
		try {
			if(r > 0) this.range = r;			
			else throw new BadInputException("Invalid Range.");			
		}
		catch(BadInputException ex) {	
			throw ex;	
		}	
	}
}
