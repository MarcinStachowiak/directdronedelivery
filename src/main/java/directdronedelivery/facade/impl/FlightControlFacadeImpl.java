package directdronedelivery.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import directdronedelivery.entity.Drone;
import directdronedelivery.facade.FlightControlFacade;
import directdronedelivery.service.DroneService;
import directdronedelivery.service.FlightControlService;

@Service
public class FlightControlFacadeImpl implements FlightControlFacade {

    private FlightControlService flightControlService = null;
    private DroneService droneService = null;

    @Autowired
    public FlightControlFacadeImpl(FlightControlService flightControlService, DroneService droneService) {
        this.flightControlService = flightControlService;
        this.droneService = droneService;
    }

    @Override
    public boolean canStartDrone(int droneId) {
        Drone drone = droneService.findDroneById(droneId);
        return flightControlService.canDroneStart(drone).isCanDroneStart();
    }

}
