package directdronedelivery.drone.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import directdronedelivery.drone.facade.WeatherFacade;
import directdronedelivery.drone.service.WeatherService;
import directdronedelivery.entity.Weather;

@Service
public class WeatherFacadeImpl implements WeatherFacade {

	@Autowired
	private WeatherService weatherService;

	@Override
	public boolean areWeatherConditionsGoodForFly(Weather weather) {
		return weatherService.areWeatherConditionsGoodForFly(weather);
	}

}
