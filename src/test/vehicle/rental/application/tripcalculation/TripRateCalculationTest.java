package test.vehicle.rental.application.tripcalculation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.vehicle.rental.application.services.impl.AdditionalPassengerRateDefaultImpl;
import main.vehicle.rental.application.services.impl.AdditionalRateAcDefualtImpl;
import main.vehicle.rental.application.services.impl.BusRateDeductionDefualtImpl;
import main.vehicle.rental.application.services.impl.DistanceMapperDefaultImpl;
import main.vehicle.rental.application.services.impl.FuelRateDefaultImpl;
import main.vehicle.rental.application.tripcalculation.TripRateCalculation;
import main.vehicle.rental.application.vehicles.Bus;
import main.vehicle.rental.application.vehicles.Car;
import main.vehicle.rental.application.vehicles.Vehicle;

/**
 * The Junit class for TripRateCalculation
 * 
 * @author Sruthy MS
 *
 */
public class TripRateCalculationTest {

	private TripRateCalculation tripRateCalculation;
	private Vehicle vehicle;
	private FuelRateDefaultImpl fuelRateDefaultImpl;
	private BusRateDeductionDefualtImpl busRateDeductionDefualtImpl;
	private DistanceMapperDefaultImpl distanceMapperDefaultImpl;
	private AdditionalPassengerRateDefaultImpl additionalPassengerRateDefaultImpl;
	private AdditionalRateAcDefualtImpl additionalRateAcDefualtImpl;

	/**
	 * Set up method
	 */
	@Before
	public void setUp() {

		fuelRateDefaultImpl = new FuelRateDefaultImpl();
		busRateDeductionDefualtImpl = new BusRateDeductionDefualtImpl();
		distanceMapperDefaultImpl = new DistanceMapperDefaultImpl();
		additionalPassengerRateDefaultImpl = new AdditionalPassengerRateDefaultImpl();
		additionalRateAcDefualtImpl = new AdditionalRateAcDefualtImpl();

	}

	/**
	 * Test method for calculate total trip rate for AC bus
	 */
	@Test
	public void testCalculateTripRateBus() {
		vehicle = new Bus("Volvo", true, true, 5);
		tripRateCalculation = new TripRateCalculation(vehicle, fuelRateDefaultImpl, busRateDeductionDefualtImpl,
				distanceMapperDefaultImpl, additionalPassengerRateDefaultImpl, additionalRateAcDefualtImpl);
		Double output = tripRateCalculation.calculateTripRate(vehicle, "Prague-Brno-Budapest-Prague", 7);

		assertEquals((Double) 1947.0, output);

	}

	/**
	 * Test method for calculate total trip rate for AC Petrol Car
	 */
	@Test
	public void testCalculateTripRateCarPetrolWithAC() {
		vehicle = new Car("VW Golf", true, false, 3);
		tripRateCalculation = new TripRateCalculation(vehicle, fuelRateDefaultImpl, busRateDeductionDefualtImpl,
				distanceMapperDefaultImpl, additionalPassengerRateDefaultImpl, additionalRateAcDefualtImpl);
		Double output = tripRateCalculation.calculateTripRate(vehicle, "Prague-Brno-Budapest-Prague", 5);

		assertEquals((Double) 2090.0, output);

	}
	
	/**
	 * Test method for calculate total trip rate for Non AC Diesel Car
	 */
	@Test
	public void testCalculateTripRateCarDieselWithoutAC() {
		vehicle = new Car("VW Golf", false, true, 3);
		tripRateCalculation = new TripRateCalculation(vehicle, fuelRateDefaultImpl, busRateDeductionDefualtImpl,
				distanceMapperDefaultImpl, additionalPassengerRateDefaultImpl, additionalRateAcDefualtImpl);
		Double output = tripRateCalculation.calculateTripRate(vehicle, "Prague-Brno-Budapest-Prague", 2);

		assertEquals((Double) 1540.0, output);

	}


	/**
	 * Test method for calculate total trip rate for Non AC Diesel Bus
	 */
	@Test
	public void testCalculateTripRateBusPetrolWithoutAC() {
		vehicle = new Bus("Scania", false, false, 10);
		tripRateCalculation = new TripRateCalculation(vehicle, fuelRateDefaultImpl, busRateDeductionDefualtImpl,
				distanceMapperDefaultImpl, additionalPassengerRateDefaultImpl, additionalRateAcDefualtImpl);
		Double output = tripRateCalculation.calculateTripRate(vehicle, "Prague-Brno-Budapest-Prague", 20);

		assertEquals((Double) 2717.0, output);

	}
}
