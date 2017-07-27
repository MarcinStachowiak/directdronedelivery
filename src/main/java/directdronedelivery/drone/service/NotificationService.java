package directdronedelivery.drone.service;

import directdronedelivery.entity.Flight;

public interface NotificationService {
	public void nofifyAboutShipmentStatus(Flight flight);

	public String prepareRightMessage(Flight flight);
}
