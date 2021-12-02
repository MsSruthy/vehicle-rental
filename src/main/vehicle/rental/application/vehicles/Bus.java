package main.vehicle.rental.application.vehicles;

/**
 * The class for implementing bus from vehicle
 * 
 * @author Sruthy MS
 *
 */
public class Bus extends Vehicle {
	/**
	 * Parameterized constructor
	 * 
	 * @param vehicleModel
	 * @param isAcAvailable
	 * @param isDiesel
	 * @param passengerLimit
	 */
	public Bus(String vehicleModel, boolean isAcAvailable, boolean isDiesel, Integer passengerLimit) {
		super(vehicleModel, isAcAvailable, isDiesel, passengerLimit);
	}

}
