package directdronedelivery.drone.service;

import directdronedelivery.entity.Drone;
import directdronedelivery.entity.enumerators.DroneStatus;
import directdronedelivery.entity.enumerators.DroneType;

public interface DroneService {
	public Drone createDrone(String name, DroneStatus droneStatus, DroneType droneType);
	public boolean isDroneBusy(Drone drone);
	public Drone findDroneById(int droneId);
}
