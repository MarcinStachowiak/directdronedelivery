package directdronedelivery.dao;

import java.util.Date;
import java.util.List;

import directdronedelivery.entity.Cargo;
import directdronedelivery.entity.Drone;
import directdronedelivery.entity.Flight;
import directdronedelivery.entity.Weather;

public interface FlightDao {
	public Flight createFlight(Drone drone, Cargo cargo, Weather weather,Date flightTime);

	public List<Flight> findAllDroneFlights(Drone drone);

	public Flight findCurrentDroneFlight(Drone drone);
}
