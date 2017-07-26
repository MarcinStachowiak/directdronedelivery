package directdronedelivery.drone.service;

import directdrondelivery.entity.Flight;

public interface NotificationService {
	public void nofifyAboutShipmentStatus(Flight flight);

	public String prepareRightMessage(Flight flight);
}
