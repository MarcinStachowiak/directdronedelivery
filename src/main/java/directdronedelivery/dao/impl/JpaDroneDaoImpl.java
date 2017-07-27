package directdronedelivery.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.google.common.base.Preconditions;

import directdronedelivery.dao.DroneDao;
import directdronedelivery.entity.Drone;
import directdronedelivery.entity.enumerators.DroneStatus;
import directdronedelivery.entity.enumerators.DroneType;

@Repository
public class JpaDroneDaoImpl extends AbstractDao<Drone, Integer> implements DroneDao {

    @Override
    public Drone findDroneByName(String droneName) {
        Preconditions.checkNotNull(droneName);

        String query = "select drone from Drone drone where UPPER(drone.name) = UPPER(:name)";
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("name", droneName);
        return search(query, queryParameters).stream().findFirst().orElse(null);
    }

    @Override
    public List<Drone> findDroneByStatus(DroneStatus droneStatus) {
        Preconditions.checkNotNull(droneStatus);

        String query = "select drone from Drone drone where drone.status = :status";
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("status", droneStatus);
        return search(query, queryParameters).stream().collect(Collectors.toList());
    }

    @Override
    public Drone createDrone(String name, DroneStatus droneStatus, DroneType droneType) {
        Preconditions.checkNotNull(name);
        Preconditions.checkNotNull(droneStatus);
        Preconditions.checkNotNull(droneType);

        Drone entity = new Drone();
        entity.setName(name);
        entity.setType(droneType);
        entity.setStatus(droneStatus);
        return save(entity);
    }

    @Override
    public Drone findDroneById(int droneId) {
        return getOne(droneId);
    }
}
