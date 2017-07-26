package directdronedelivery.dao.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.assertj.core.util.Preconditions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import directdrondelivery.entity.Cargo;
import directdrondelivery.entity.Drone;
import directdrondelivery.entity.Flight;
import directdrondelivery.entity.Weather;
import directdronedelivery.dao.FlightDao;
@Repository
@Scope("singleton")
public class JpaFlightDao extends AbstractDao<Flight, Integer> implements FlightDao{

	@Override
	public List<Flight> findAllDroneFlights(Drone drone){
		Preconditions.checkNotNull(drone);

		String query = "select flight from Flight flight where flight.drone = :drone";
		Map<String, Object> queryParameters = new HashMap<>();
		queryParameters.put("drone", drone);
		return search(query, queryParameters).stream().collect(Collectors.toList());
	}

	@Override
	public Flight findCurrentDroneFlight(Drone drone){
		return findAllDroneFlights(drone).stream()
				.sorted(Collections.reverseOrder())
				.findFirst()
				.orElse(null);
	}

	@Override
	public Flight createFlight(Drone drone, Cargo cargo, Weather weather,Date flightTime) {
		Flight entity = new Flight();
		entity.setDrone(drone);
		entity.setCargo(cargo);
		entity.setWeather(weather);
		entity.setDate(flightTime);
		return save(entity);
	}
}