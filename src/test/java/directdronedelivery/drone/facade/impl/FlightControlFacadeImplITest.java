package directdronedelivery.drone.facade.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import directdrondelivery.entity.Weather;
import directdronedelivery.application.DirectdronedeliverApplication;
import directdronedelivery.drone.facade.WeatherFacade;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DirectdronedeliverApplication.class})
public class FlightControlFacadeImplITest {

	@Autowired
	private WeatherFacade weatherFacade;

	@Test
	public void shodCheckThatWeatherIsNotGood() {
		boolean result = weatherFacade.areWeatherConditionsGoodForFly(buildWeather());
		assertThat(result, is(false));
	}


	private Weather buildWeather() {
		Weather weather = new Weather();
		weather.setTemperature(3);
		weather.setLightningsPossible(true);
		weather.setWindInPMS(44);
		weather.setLightningsPossible(true);
		return weather;
	}

}
