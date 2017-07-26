package directdrondelivery.exceptions;

import java.util.Set;

import directdronedelivery.drone.service.impl.ErrorReason;

@SuppressWarnings("serial")
public class DroneCannotStartException extends RuntimeException {

    private Set<ErrorReason> messages;

    public DroneCannotStartException(Set<ErrorReason> messages) {
        this.messages = messages;
    }

    public Set<ErrorReason> getMessages() {
        return messages;
    }
}
