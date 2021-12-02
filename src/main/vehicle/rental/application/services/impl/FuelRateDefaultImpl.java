package main.vehicle.rental.application.services.impl;

import main.vehicle.rental.application.services.FuelRate;

/**
 * Implementation class for FuelRate
 * 
 * @author Sruthy MS
 *
 */
public class FuelRateDefaultImpl implements FuelRate {
	/**
	 * Implementation method for standard fuel rate / km
	 */
	@Override
	public Double getFuelStandardRate() {
		return 1.5;
	}

	/**
	 * Implementation method for fuel rate deduction for diesel vehicle/ km
	 */
	@Override
	public Double getDieselRateReduction() {
		return 0.1;
	}

}
