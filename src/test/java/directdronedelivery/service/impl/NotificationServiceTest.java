package directdronedelivery.service.impl;

import static org.mockito.Mockito.mock;
import org.junit.Before;
import org.junit.Test;

import directdronedelivery.entity.Cargo;
import directdronedelivery.entity.Drone;
import directdronedelivery.entity.Flight;
import directdronedelivery.entity.enumerators.DroneStatus;
import directdronedelivery.service.MailService;
import directdronedelivery.service.NotificationService;
import directdronedelivery.service.impl.MailServiceImpl;
import directdronedelivery.service.impl.NotificationServiceImpl;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class NotificationServiceTest {
	private static final String RECEIPIENT_EMAIL="do-not-reply@capgemini.com";
	private static final String RECEIPIENT_NAME="name";
	private static final String MESSAGE_TEXT="Shipment number: 1 is ready to fly. Recipient: name.";
	NotificationService notificationService;
	MailService mailServiceMock;

	@Before
	public void setup(){
		mailServiceMock = new MailServiceImpl();
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
