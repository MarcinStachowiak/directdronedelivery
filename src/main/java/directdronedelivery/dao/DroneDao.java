package directdronedelivery.dao;

import java.util.List;

import directdrondelivery.entity.Drone;
import directdrondelivery.entity.enumerators.DroneStatus;
import directdrondelivery.entity.enumerators.DroneType;

public interface DroneDao {
	public Drone findDroneByName(String droneName);

	public List<Drone> findDroneByStatus(DroneStatus droneStatus);

	public Drone createDrone(String name, DroneStatus droneStatus, DroneType droneType);

	public Drone findDroneById(int droneId);
}
