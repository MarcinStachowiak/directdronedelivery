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
import directdronedelivery.entity.Weather;
import directdronedelivery.entity.enumerators.DroneStatus;
import directdronedelivery.entity.enumerators.DroneType;
import directdronedelivery.service.FlightControlService;
import directdronedelivery.service.NotificationService;
import directdronedelivery.service.WeatherService;

@RunWith(MockitoJUnitRunner.class)
public class FlightControlServiceTest {

	@Mock
	private FlightDao flightDao;

	@Mock
	private WeatherService weatherService;

	@Mock
	private NotificationService notificationService;

	private FlightControlService flightControlService = null;

	@Before
	public void setup() {
		flightControlService = new FlightControlServiceImpl(flightDao, weatherService, notificationService);
		given(flightDao.findCurrentDroneFlight(Mockito.any(Drone.class))).willReturn(buildFlight());
		given(weatherService.areWeatherConditionsGoodForFly(Mockito.any(Weather.class))).willReturn(true);
	}

	@Test
	public void shouldCheckThatDroneCanStart() {
		// given
		Drone drone = buildDrone();

		// when
		DroneStartResultDs result = flightControlService.canDroneStart(drone);

		// then
		assertThat(result, notNullValue());
		assertThat(result.isCanDroneStart(), is(true));
		assertThat(result.getReasons(), empty());
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
		cargo.setHeight(10);
		cargo.setLength(10);
		cargo.setWidth(10);
		cargo.setWeight(1000);
		return cargo;
	}

}
