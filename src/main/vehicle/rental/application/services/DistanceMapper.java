package main.vehicle.rental.application.services;

/**
 * The Interface for getting distance of different routes
 * 
 * @author Sruthy MS
 *
 */
public interface DistanceMapper {
	/**
	 * The method that return distance for each route
	 * 
	 * @return
	 */
	public Double getDistance(String distance);

}
