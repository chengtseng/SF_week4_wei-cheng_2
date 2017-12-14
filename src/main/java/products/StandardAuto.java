package products;
import java.util.Date;

import enums.CarType;
import enums.Manufacture;
import exceptions.BadInputException;

public class StandardAuto extends Automobile {	
	private Date emissionTestDate;
	private int numberOfSeats;
	
	public StandardAuto(String v,
						Manufacture manufacture,
						int range, 
						String color, 
						double basePrice, 
						Date emi, 
						int numOfSeats, 
						String vCode, 
						double luxT) throws BadInputException {
		
		super(v, manufacture, range, color, basePrice, vCode, luxT);	
		
		//type specific
		this.emissionTestDate = emi;
		this.numberOfSeats = numOfSeats;
		this.type = CarType.STANDARD;
		try {
			this.setRange(range);
		} catch (BadInputException e) {
			throw e;
		}
	}		

	public Date getEmissionTestDate() {
		return emissionTestDate;
	}

	public void setEmissionTestDate(Date emissionTestDate) {
		this.emissionTestDate = emissionTestDate;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
}
