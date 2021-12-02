package main.vehicle.rental.application.tripcalculation;

import java.text.DecimalFormat;
import java.util.ArrayList;

import main.vehicle.rental.application.exception.CustomException;
import main.vehicle.rental.application.services.impl.AdditionalPassengerRateDefaultImpl;
import main.vehicle.rental.application.services.impl.AdditionalRateAcDefualtImpl;
import main.vehicle.rental.application.services.impl.BusRateDeductionDefualtImpl;
import main.vehicle.rental.application.services.impl.DistanceMapperDefaultImpl;
import main.vehicle.rental.application.services.impl.FuelRateDefaultImpl;
import main.vehicle.rental.application.vehicles.Bus;
import main.vehicle.rental.application.vehicles.Vehicle;

/**
 * The class is created for calculating total trip charges
 * 
 * @author Sruthy M S
 *
 */
public class TripRateCalculation {

	private Vehicle vehicle;
	private FuelRateDefaultImpl fuelRateDefaultImpl;
	private BusRateDeductionDefualtImpl busRateDeductionDefualtImpl;
	private DistanceMapperDefaultImpl distanceMapperDefaultImp;
	private AdditionalPassengerRateDefaultImpl additionalPassengerRateDefaultImpl;
	private AdditionalRateAcDefualtImpl additionalRateAcDefualtImpl;

	/**
	 * Constructor with field
	 * 
	 * @param vehicle
	 * @param fuelRateDefaultImpl
	 * @param busRateDeductionDefualtImpl
	 * @param distanceMapperDefaultImp
	 * @param additionalPassengerRateDefaultImpl
	 * @param additionalRateAcDefualtImpl
	 */
	public TripRateCalculation(Vehicle vehicle, FuelRateDefaultImpl fuelRateDefaultImpl,
			BusRateDeductionDefualtImpl busRateDeductionDefualtImpl, DistanceMapperDefaultImpl distanceMapperDefaultImp,
			AdditionalPassengerRateDefaultImpl additionalPassengerRateDefaultImpl,
			AdditionalRateAcDefualtImpl additionalRateAcDefualtImpl) {
		super();
		this.vehicle = vehicle;
		this.fuelRateDefaultImpl = fuelRateDefaultImpl;
		this.busRateDeductionDefualtImpl = busRateDeductionDefualtImpl;
		this.distanceMapperDefaultImp = distanceMapperDefaultImp;
		this.additionalPassengerRateDefaultImpl = additionalPassengerRateDefaultImpl;
		this.additionalRateAcDefualtImpl = additionalRateAcDefualtImpl;
	}

	/**
	 * Method for calculating total trip rate
	 * 
	 * @param vehicle
	 * @param route
	 * @param totalPassenger
	 * @return
	 */
	public Double calculateTripRate(Vehicle vehicle, String route, Integer totalPassenger) {
		try {
			if (vehicle != null && totalPassenger != null && totalPassenger != 0) {
				Double totalAmountForTrip = 0.0;
				Double calcualteRatePerKM = calcualteRatePerKM(vehicle, totalPassenger);
				Double calculateTotalDistanceForTrip;
				calculateTotalDistanceForTrip = calculateTotalDistanceForTrip(route);
				totalAmountForTrip = calculateTotalDistanceForTrip * calcualteRatePerKM;
				DecimalFormat formater = new DecimalFormat("0.00");
				double roundedValue = Double.parseDouble(formater.format(totalAmountForTrip));
				return roundedValue;
			}
		} catch (CustomException e) {
			//handle the exception instead of just printing!
			e.printStackTrace();
		}

		return 0.0;

	}

	/**
	 * Method for calculating rate per KM based on fuel rate, AC and extra person
	 * per head.
	 * 
	 * @param isDiesel
	 * @param totalPassenger
	 * @param isAcAvailable
	 * @return
	 */
	private Double calcualteRatePerKM(Vehicle vehicle, Integer totalPassenger) {
		Double totalRatePerKm = 0.00;
		Double fuelStandardRate = fuelRateDefaultImpl.getFuelStandardRate();
		if (vehicle instanceof Bus) {
			fuelStandardRate = fuelStandardRate - appyDiscount(fuelStandardRate);
		}
		if (vehicle.isDiesel()) {
			totalRatePerKm = fuelStandardRate - fuelRateDefaultImpl.getDieselRateReduction();
		} else {
			totalRatePerKm = fuelStandardRate;
		}

		if (vehicle.isAcAvailable()) {
			totalRatePerKm = totalRatePerKm + additionalRateAcDefualtImpl.getAdditionalRateAc();
		}
		totalRatePerKm = totalRatePerKm
				+ getExtraPerson(totalPassenger) * additionalPassengerRateDefaultImpl.getAdditionalPersonCharge();
		return totalRatePerKm;
	}

	/**
	 * The method for calculating total distance for trip
	 * 
	 * @param route
	 * @return
	 * @throws CustomException
	 */
	private Double calculateTotalDistanceForTrip(String route) throws CustomException {
		Double totalDistance = 0.0;
		String[] desitnations = route.split("-");
		ArrayList<String> distances = new ArrayList<>();
		for (int i = 0; i < desitnations.length - 1; i++) {
			distances.add(desitnations[i] + "-" + desitnations[i + 1]);
		}
		for (String distance : distances) {
			if (distanceMapperDefaultImp.getDistance(distance) == null) {
				throw new CustomException("Route Not Available");
			}
			totalDistance = totalDistance + distanceMapperDefaultImp.getDistance(distance);
		}
		return totalDistance;

	}

	/**
	 * Method to find Extra person
	 * 
	 * @param totalPassenger
	 * @return
	 */
	private Integer getExtraPerson(Integer totalPassenger) {
		return totalPassenger > vehicle.getPassengerLimit() ? totalPassenger - vehicle.getPassengerLimit()
				: 0;
	}

	/**
	 * Method for calculate discount for bus
	 * 
	 * @param totalAmountForTrip
	 * @return
	 */
	private Double appyDiscount(Double totalAmountForTrip) {
		return totalAmountForTrip * busRateDeductionDefualtImpl.getBusRateDiscount();

	}

}
