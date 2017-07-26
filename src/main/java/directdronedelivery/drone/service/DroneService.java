package directdronedelivery.drone.service;

import directdrondelivery.entity.Drone;
import directdrondelivery.entity.enumerators.DroneStatus;
import directdrondelivery.entity.enumerators.DroneType;

public interface DroneService {
	public Drone createDrone(String name, DroneStatus droneStatus, DroneType droneType);
	public boolean isDroneBusy(Drone drone);
	public Drone findDroneById(int droneId);
}
