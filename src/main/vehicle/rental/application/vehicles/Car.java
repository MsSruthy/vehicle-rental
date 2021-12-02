package main.vehicle.rental.application.vehicles;

/**
 * The class for implementing Car from vehicle
 * 
 * @author Sruthy MS
 *
 */
public class Car extends Vehicle {
	/**
	 * Parameterized constructor
	 * 
	 * @param vehicleModel
	 * @param isAcAvailable
	 * @param isDiesel
	 * @param passengerLimit
	 */
	public Car(String vehicleModel, boolean isAcAvailable, boolean isDiesel, Integer passengerLimit) {
		super(vehicleModel, isAcAvailable, isDiesel, passengerLimit);
	}

}
