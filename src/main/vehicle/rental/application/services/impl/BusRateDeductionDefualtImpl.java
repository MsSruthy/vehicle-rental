package main.vehicle.rental.application.services.impl;

import main.vehicle.rental.application.services.BusRateDeduction;

/**
 * Implementation class for BusRateDeduction
 * 
 * @author Sruthy MS
 *
 */
public class BusRateDeductionDefualtImpl implements BusRateDeduction {
	/**
	 * Implementation method for bus rate rate discount
	 */
	@Override
	public Double getBusRateDiscount() {
		return 0.02;
	}

}
