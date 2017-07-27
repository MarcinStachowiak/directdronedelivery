package directdronedelivery.drone.service;

import directdronedelivery.drone.ds.DroneStartResultDs;
import directdronedelivery.entity.Drone;
import directdronedelivery.exceptions.DroneCannotStartException;

public interface FlightControlService {

    void startDrone(Drone drone) throws DroneCannotStartException;

    DroneStartResultDs canDroneStart(Drone drone);
}
