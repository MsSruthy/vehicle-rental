package main.vehicle.rental.application.services;

/**
 * The Interface for get Fuel rate
 * 
 * @author Sruthy MS
 *
 */
public interface FuelRate {

	/**
	 * The Method for get fuel rate/ km
	 * 
	 * @return
	 */
	public Double getFuelStandardRate();

	/**
	 * The Method for get fuel rate deduction for diesel vehicle/ km
	 * 
	 * @return
	 */
	public Double getDieselRateReduction();

}
