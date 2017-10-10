package directdronedelivery.service.impl;

public enum ErrorReason {
    BAD_WEATHER("Cant fly because of bad weather"),
    CARGO_NOT_LOADED("Cant fly cargo not loaded"),
    CARGO_TOO_BIG("Cant fly cargo too big"),
    CARGO_TOO_HEAVY("Cant fly cargo too heavy"),
    NO_FLIGHT_FOR_DRONE("Dron does not have a flight"),
    WRONG_STATUS("Cant fly because DroneStatus not READY_FOR_TAKE_OFF");

    private String message;

    private ErrorReason(String errorReason) {
        this.message = errorReason;
    }
}
