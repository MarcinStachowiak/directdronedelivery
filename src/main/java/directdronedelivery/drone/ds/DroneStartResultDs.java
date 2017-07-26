package directdronedelivery.drone.ds;

import java.util.Set;

import directdronedelivery.drone.service.impl.ErrorReason;


public class DroneStartResultDs {

    public DroneStartResultDs(boolean canDroneStart, Set<ErrorReason> reasons) {

        this.canDroneStart = canDroneStart;
        this.reasons = reasons;
    }

    /**
     * Decision if the drone can start
     */
    private boolean canDroneStart;

    /**
     * Reasons why the drone cannot start
     */
    private Set<ErrorReason> reasons;

    public boolean isCanDroneStart() {
        return canDroneStart;
    }

    public Set<ErrorReason> getReasons() {
        return reasons;
    }
}
