package directdronedelivery.drone.facade.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import directdronedelivery.application.DirectDronedeliverApplication;
import directdronedelivery.configuration.keys.ProfileKey;
import directdronedelivery.dao.FlightDao;
import directdronedelivery.drone.ds.DroneStartResultDs;
import directdronedelivery.drone.service.FlightControlService;
import directdronedelivery.entity.Cargo;
import directdronedelivery.entity.Drone;
import directdronedelivery.entity.Flight;
import directdronedelivery.entity.Weather;
import directdronedelivery.entity.enumerators.DroneStatus;
import directdronedelivery.entity.enumerators.DroneType;

@ActiveProfiles(ProfileKey.MOCK_DAO)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DirectDronedeliverApplication.class })
public class FlightControlFacadeImplIntegrationTest {

    @Autowired
    private FlightDao flightDaoMock;

    @Autowired
    private FlightControlService flightControlService;

    @Before
    public void setup() {
        given(flightDaoMock.findCurrentDroneFlight(Mockito.any(Drone.class))).willReturn(buildFlight());
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
        flight.setWeather(buildWeather());
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

    private Weather buildWeather() {
        Weather weather = new Weather();
        weather.setLightningsPossible(false);
        weather.setPrecipitationPossible(false);
        weather.setTemperature(20);
        weather.setWindInPMS(10);
        return weather;
    }
}
