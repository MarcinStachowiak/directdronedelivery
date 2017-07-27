package directdronedelivery.drone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

import directdronedelivery.dao.DroneDao;
import directdronedelivery.drone.service.DroneService;
import directdronedelivery.entity.Drone;
import directdronedelivery.entity.enumerators.DroneStatus;
import directdronedelivery.entity.enumerators.DroneType;

/**
 *
 * @author Marcin Stachowiak, Capgemini(marcin.stachowiak@capgemini.com)
 *
 */
@Service
public class DroneServiceImpl implements DroneService {

    private DroneDao droneDao = null;

    @Autowired
    public DroneServiceImpl(DroneDao droneDao) {
        this.droneDao = droneDao;
    }

    @Override
    public Drone createDrone(String name, DroneStatus droneStatus, DroneType droneType) {
        return droneDao.createDrone(name, droneStatus, droneType);
    }

    @Override
    public boolean isDroneBusy(Drone drone) {
        Preconditions.checkNotNull(drone);

        DroneStatus droneStatus = drone.getStatus();
        return droneStatus != DroneStatus.DOCKED;
    }

    @Override
    public Drone findDroneById(int droneId) {
        return droneDao.findDroneById(droneId);
    }

}
