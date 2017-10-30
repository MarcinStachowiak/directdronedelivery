package directdronedelivery.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import directdronedelivery.dao.FlightDao;
import directdronedelivery.ds.DroneStartResultDs;
import directdronedelivery.entity.Cargo;
import directdronedelivery.entity.Drone;
import directdronedelivery.entity.Flight;
import directdronedelivery.entity.enumerators.DroneStatus;
import directdronedelivery.entity.enumerators.DroneType;
import directdronedelivery.service.FlightControlService;

public class FlightControlServiceTest {


	private FlightControlService flightControlService = null;

	@Before
	public void setup() {
		flightControlService = new FlightControlServiceImpl(null, null, null);
	}

	@Test
	public void shouldCheckThatDroneCanStart() {
		// given
		Drone drone = buildDrone();

		// when
		DroneStartResultDs result = flightControlService.canDroneStart(drone);

		// then
	}

	private Drone buildDrone() {
		Drone drone = new Drone();
		drone.setType(DroneType.BIG_SIX_ROTORS);
		drone.setStatus(DroneStatus.READY_FOR_TAKE_OFF);
		return drone;
	}

	private Flight buildFlight() {
		Flight flight = new Flight();
		flight.setCargo(buildCargo());
		return flight;
	}

	private Cargo buildCargo() {
		Cargo cargo = new Cargo();
		return cargo;
	}

}
