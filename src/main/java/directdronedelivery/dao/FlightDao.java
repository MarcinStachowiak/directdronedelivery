package directdronedelivery.dao;

import java.util.Date;
import java.util.List;

import directdrondelivery.entity.Cargo;
import directdrondelivery.entity.Drone;
import directdrondelivery.entity.Flight;
import directdrondelivery.entity.Weather;

public interface FlightDao {
	public Flight createFlight(Drone drone, Cargo cargo, Weather weather,Date flightTime);

	public List<Flight> findAllDroneFlights(Drone drone);

	public Flight findCurrentDroneFlight(Drone drone);
}
