package directdronedelivery.drone.service.impl;


import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import directdronedelivery.dao.FlightDao;
import directdronedelivery.drone.service.FlightControlService;
import directdronedelivery.entity.Drone;
import directdronedelivery.entity.Flight;

@RunWith(MockitoJUnitRunner.class)
public class FlightControlServiceTest {

	@Mock
	private FlightDao flightDao;

	// please, implement others mocks

	private FlightControlService flightControlService = null;

	@Before
	public void setup() {
		flightControlService = new FlightControlServiceImpl(flightDao, null, null);
		given(flightDao.findCurrentDroneFlight(Mockito.any(Drone.class))).willReturn(buildFlight());
	}

	@Test
	public void shouldCheckThatDroneCanStart() {
		// given
		// todo

		// when
		// todo

		// then
		// todo
	}

	private Flight buildFlight() {
		Flight flight = new Flight();
		// please, implement an Flight object
		return flight;
	}

}
