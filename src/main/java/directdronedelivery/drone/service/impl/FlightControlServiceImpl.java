package directdronedelivery.drone.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import directdronedelivery.dao.FlightDao;
import directdronedelivery.drone.ds.DroneStartResultDs;
import directdronedelivery.drone.service.FlightControlService;
import directdronedelivery.drone.service.NotificationService;
import directdronedelivery.drone.service.WeatherService;
import directdronedelivery.entity.Cargo;
import directdronedelivery.entity.Drone;
import directdronedelivery.entity.Flight;
import directdronedelivery.entity.enumerators.DroneStatus;
import directdronedelivery.entity.enumerators.DroneType;
import directdronedelivery.exceptions.DroneCannotStartException;

/**
 *
 * @author Marcin Stachowiak, Capgemini(marcin.stachowiak@capgemini.com)
 *
 */

@Service
public class FlightControlServiceImpl implements FlightControlService {
    private static final long MAX_VOLUME_FOR_FOUR_ROTORS_DRONE = 30 * 20 * 25;
    private static final long MAX_VOLUME_FOR_SIX_ROTORS_DRONE = 40 * 30 * 40;
    private static final long MAX_WEIGHT_FOR_FOUR_ROTORS_DRONE = 2500;
    private static final long MAX_WEIGHT_FOR_SIX_ROTORS_DRONE = 5000;

    private FlightDao flightDao = null;
    private WeatherService weatherService = null;
    private NotificationService notificationService = null;

    @Autowired
    public FlightControlServiceImpl(FlightDao flightDao, WeatherService weatherService,
            NotificationService notificationService) {
        this.flightDao = flightDao;
        this.weatherService = weatherService;
        this.notificationService = notificationService;
    }

    @Override
    public DroneStartResultDs canDroneStart(Drone drone) {
        Set<ErrorReason> messages = new HashSet<>();

        if (drone.getStatus() != DroneStatus.READY_FOR_TAKE_OFF) {
            messages.add(ErrorReason.WRONG_STATUS);
        }

        Flight flight = flightDao.findCurrentDroneFlight(drone);
        if (flight == null) {
            messages.add(ErrorReason.NO_FLIGHT_FOR_DRONE);
        }

        Cargo cargo = flight.getCargo();
        if (!checkIfVolumePreconditionsAreMet(drone, cargo)) {
            messages.add(ErrorReason.CARGO_TOO_BIG);
        }

        if (!checkIfWeightPreconditionsAreMet(drone, cargo)) {
            messages.add(ErrorReason.CARGO_TOO_HEAVY);
        }

        if (!weatherService.areWeatherConditionsGoodForFly(flight.getWeather())) {
            messages.add(ErrorReason.BAD_WEATHER);
        }

        return new DroneStartResultDs(messages.isEmpty(), messages);
    }

    private boolean checkIfVolumePreconditionsAreMet(Drone drone, Cargo cargo) {
        long volume = cargo.getHeight() * cargo.getLength() * cargo.getWidth();
        return drone.getType() == DroneType.SMALL_FOUR_ROTORS && volume < MAX_VOLUME_FOR_FOUR_ROTORS_DRONE
                || drone.getType() == DroneType.BIG_SIX_ROTORS && volume < MAX_VOLUME_FOR_SIX_ROTORS_DRONE;
    }

    private boolean checkIfWeightPreconditionsAreMet(Drone drone, Cargo cargo) {
        Integer weight = cargo.getWeight();
        return drone.getType() == DroneType.SMALL_FOUR_ROTORS && weight < MAX_WEIGHT_FOR_FOUR_ROTORS_DRONE
                || drone.getType() == DroneType.BIG_SIX_ROTORS && weight < MAX_WEIGHT_FOR_SIX_ROTORS_DRONE;
    }

    /**
     * Method check if the drone can start. When he does it changes drone status
     * to AIRBORNE. Additionally informs recipient that the drone is on the way.
     *
     * @param droneAggregate
     * @throws DroneCannotStartException
     */
    @Override
    public void startDrone(Drone drone) throws DroneCannotStartException {
        DroneStartResultDs canDronStartResult = canDroneStart(drone);
        if (canDronStartResult.isCanDroneStart()) {
            drone.setStatus(DroneStatus.AIRBORNE);
            Flight flight = flightDao.findCurrentDroneFlight(drone);
            notificationService.nofifyAboutShipmentStatus(flight);
        }
        else {
            throw new DroneCannotStartException(canDronStartResult.getReasons());
        }
    }
}
