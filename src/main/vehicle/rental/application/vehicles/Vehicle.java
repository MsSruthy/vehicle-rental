package main.vehicle.rental.application.vehicles;

/**
 * The Parent class for Vehicle
 * 
 * @author Sruthy MS
 *
 */
public class Vehicle {

	private String vehicleModel;

	private boolean isAcAvailable;

	private boolean isDiesel;

	private Integer passengerLimit;

	/**
	 * Constructor with field
	 * 
	 * @param vehicleModel
	 * @param isAcAvailable
	 * @param isDiesel
	 * @param passengerLimit
	 */
	public Vehicle(String vehicleModel, boolean isAcAvailable, boolean isDiesel, Integer passengerLimit) {
		super();
		this.vehicleModel = vehicleModel;
		this.isAcAvailable = isAcAvailable;
		this.isDiesel = isDiesel;
		this.passengerLimit = passengerLimit;
	}

	/**
	 * Getter for vehicleModel
	 * 
	 * @return
	 */
	public String getVehicleModel() {
		return vehicleModel;
	}

	/**
	 * Setter for vehicle model
	 * 
	 * @param vehicleModel
	 */
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	/**
	 * Method for checking vehicle diesel or petrol
	 * 
	 * @return
	 */
	public boolean isDiesel() {
		return isDiesel;
	}

	/**
	 * Setter for fuel type
	 * 
	 * @return
	 */
	public void setDiesel(boolean isDiesel) {
		this.isDiesel = isDiesel;
	}

	/**
	 * Method for checking vehicle is AC or non AC
	 * 
	 * @return
	 */
	public boolean isAcAvailable() {
		return isAcAvailable;
	}

	/**
	 * Setter for Available
	 * 
	 * @return
	 */
	public void setAcAvailable(boolean isAcAvailable) {
		this.isAcAvailable = isAcAvailable;
	}

	/**
	 * Getter for PassengerLimitP
	 * 
	 * @return
	 */
	public Integer getPassengerLimit() {
		return passengerLimit;
	}

	/**
	 * Setter for passenger limit
	 * 
	 * @param passengerLimit
	 */
	public void setPassengerLimit(Integer passengerLimit) {
		this.passengerLimit = passengerLimit;
	}

}
