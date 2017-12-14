package products;
import enums.CarType;
import enums.Manufacture;
import exceptions.BadInputException;

public class ElectricAuto extends Automobile {	
	private int numberOfBatteries;
	private boolean isTelsla;
	
	public ElectricAuto(String v, 
						Manufacture manufacture, 
						int range, 
						String color, 
						int numOfBatter, 
						boolean isTel, 
						double basePrice, 
						String vCode, 
						double luxT) throws BadInputException {
		
		super(v, manufacture, range, color, basePrice, vCode, luxT);
		
		//type specific
		this.numberOfBatteries = numOfBatter;
		this.isTelsla = isTel;
		this.limitable = true;
		this.type = CarType.ELECTRIC;
		try {
			this.setRange(range);
		} catch (BadInputException e) {
			throw e;
		}
	}	

	public int getNumberOfBatteries() {
		return numberOfBatteries;
	}

	public void setNumberOfBatteries(int numberOfBatteries) {
		this.numberOfBatteries = numberOfBatteries;
	}

	public boolean isTelsla() {
		return isTelsla;
	}

	public void setTelsla(boolean isTelsla) {
		this.isTelsla = isTelsla;
	}

}
