package directdronedelivery.drone.service.impl;

import static org.mockito.Mockito.mock;
import org.junit.Before;
import org.junit.Test;




import directdrondelivery.entity.Cargo;
import directdrondelivery.entity.Drone;
import directdrondelivery.entity.Flight;
import directdrondelivery.entity.enumerators.DroneStatus;
import directdronedelivery.drone.service.MailService;
import directdronedelivery.drone.service.NotificationService;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class NotificationServiceImplTest {
	private static final String RECEIPIENT_EMAIL="do-not-reply@capgemini.com";
	private static final String RECEIPIENT_NAME="name";
	private static final String MESSAGE_TEXT="Shipment number: 1 is ready to fly. Recipient: name.";
	NotificationService notificationService;
	MailService mailServiceMock;

	@Before
	public void setup(){
		mailServiceMock= mock(MailServiceImpl.class);
		notificationService= new NotificationServiceImpl(mailServiceMock);
	}

	@Test
	public void shouldPrepareCorrectMessageToReceipientWhenDroneStatusIsAIRBORNE() {
		//given
		Flight flight = buildFlight();

		//when
		String result = notificationService.prepareRightMessage(flight);

		//then
		assertThat(result, equalTo(MESSAGE_TEXT));
	}

	private Flight buildFlight(){
		Flight flight=new Flight();

		Cargo cargo=new Cargo();
		cargo.setId(1);
		cargo.setRecipientEmail(RECEIPIENT_EMAIL);
		cargo.setRecipientName(RECEIPIENT_NAME);
		flight.setCargo(cargo);

		Drone drone = new Drone();
		drone.setStatus(DroneStatus.AIRBORNE);
		flight.setDrone(drone);
		return flight;
	}

}
