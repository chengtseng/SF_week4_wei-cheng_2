package products;
import enums.Type;
import exceptions.BadInputException;

public abstract class Vehicle {
	protected String vin;
	protected int range;
	protected double basePrice;
	protected String vehicleCode;
	protected boolean limitable;
	protected Type type;
	protected double luxTax;
	
	//abstract methods : to display vehicle's detail.
	public abstract void displayDetail();	
	
	//determine if the range is valid
	public abstract void determineRange(int r) throws BadInputException;
	
	//get the cost of the vehicle, same formula for all kinds
	public double getCost() {
		return (((Double.valueOf(vin) / Double.valueOf(vehicleCode)) * basePrice) / range ) + luxTax;
	}	
	
	//getter and setter for all common vehicle's attribute
	public void setRange(int r) throws BadInputException {
		determineRange(r);
	}
	
	public int getRange() {
		return this.range;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public String getVehicleCode() {
		return vehicleCode;
	}

	public void setVehicleCode(String vehicleCode) {
		this.vehicleCode = vehicleCode;
	}

	public boolean isLimitable() {
		return limitable;
	}

	public void setLimitable(boolean limitable) {
		this.limitable = limitable;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public double getLuxTax() {
		return luxTax;
	}

	public void setLuxTax(double luxTax) {
		this.luxTax = luxTax;
	}	
}
