package directdronedelivery.facade.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import directdronedelivery.application.DirectdronedeliverApplication;
import directdronedelivery.configuration.keys.ProfileKey;

@ActiveProfiles(ProfileKey.MOCK_DAO)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { DirectdronedeliverApplication.class })
public class FlightControlFacadeImplIntegrationTest {

	// @Autowired todo

	@Before
	public void setup() {
		// Mockito setup
	}

	@Test
	public void shouldCheckThatDroneCanStart() {
		// given
		// todo

		// when
		// todo

		// then
		// todo
	}
}
