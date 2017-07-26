package directdronedelivery.drone.service;

import directdrondelivery.entity.Drone;
import directdrondelivery.exceptions.DroneCannotStartException;
import directdronedelivery.drone.ds.DroneStartResultDs;

public interface FlightControlService {
	void startDrone(Drone drone) throws DroneCannotStartException;

	DroneStartResultDs canDroneStart(Drone drone);
}
