package main.vehicle.rental.application.services.impl;

import main.vehicle.rental.application.services.AdditionalPassengerRate;

/**
 * Implementation class for AdditionalPassengerRate
 * 
 * @author Sruthy MS
 *
 */
public class AdditionalPassengerRateDefaultImpl implements AdditionalPassengerRate {

	/**
	 * Implementation method for get additional Person charge
	 */
	@Override
	public double getAdditionalPersonCharge() {
		return 0.1;
	}

}
