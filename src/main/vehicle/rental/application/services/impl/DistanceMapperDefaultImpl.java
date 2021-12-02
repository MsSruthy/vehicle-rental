package main.vehicle.rental.application.services.impl;

import java.util.HashMap;
import java.util.Map;

import main.vehicle.rental.application.services.DistanceMapper;

/**
 * Implementation class for FuelRate
 * 
 * @author Sruthy MS
 *
 */
public class DistanceMapperDefaultImpl implements DistanceMapper {
	/**
	 * Implementation method for getting  distance for each route
	 */
	@Override
	public Double getDistance(String distance) {
		Map<String, Double> distanceMap = new HashMap<>();
		distanceMap.put("Prague-Brno", 200.00);
		distanceMap.put("Brno-Prague", 200.00);
		distanceMap.put("Prague-Budapest", 550.00);
		distanceMap.put("Budapest-Prague", 550.00);
		distanceMap.put("Brno-Viena", 150.00);
		distanceMap.put("Viena-Brno", 150.00);
		distanceMap.put("Brno-Budapest", 350.00);
		distanceMap.put("Budapest-Brno", 350.00);

		return distanceMap.get(distance);
	}

}
