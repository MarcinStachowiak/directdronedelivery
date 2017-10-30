package directdronedelivery.facade.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import directdronedelivery.application.DirectdronedeliverApplication;
import directdronedelivery.configuration.keys.ProfileKey;
import directdronedelivery.dao.FlightDao;
import directdronedelivery.ds.DroneStartResultDs;
import directdronedelivery.entity.Cargo;
import directdronedelivery.entity.Drone;
import directdronedelivery.entity.Flight;
import directdronedelivery.entity.Weather;
import directdronedelivery.entity.enumerators.DroneStatus;
import directdronedelivery.entity.enumerators.DroneType;
import directdronedelivery.service.FlightControlService;


public class FlightControlFacadeImplIntegrationTest {

    @Before
    public void setup() {

    }

    @Test
    public void shouldCheckThatDroneCanStart() {
        // given
        Drone drone = buildDrone();

        // when
        //    DroneStartResultDs result = flightControlService.canDroneStart(drone);

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
