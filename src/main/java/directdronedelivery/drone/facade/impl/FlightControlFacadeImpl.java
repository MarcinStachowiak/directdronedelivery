package directdronedelivery.drone.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import directdrondelivery.entity.Drone;
import directdronedelivery.drone.facade.FlightControlFacade;
import directdronedelivery.drone.service.DroneService;
import directdronedelivery.drone.service.FlightControlService;

@Service
@Scope("singleton")
public class FlightControlFacadeImpl implements FlightControlFacade {

	private FlightControlService flightControlService = null;
	private DroneService droneService=null;

	@Autowired
	public FlightControlFacadeImpl(FlightControlService flightControlService,DroneService droneService) {
		this.flightControlService = flightControlService;
		this.droneService=droneService;
	}

	@Override
	public boolean canStartDrone(int droneId) {
		Drone drone = droneService.findDroneById(droneId);
		return flightControlService.canDroneStart(drone).isCanDroneStart();
	}

}