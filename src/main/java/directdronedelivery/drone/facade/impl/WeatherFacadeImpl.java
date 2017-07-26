package directdronedelivery.drone.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import directdrondelivery.entity.Weather;
import directdronedelivery.drone.facade.WeatherFacade;
import directdronedelivery.drone.service.WeatherService;

@Service
public class WeatherFacadeImpl implements WeatherFacade {

	@Autowired
	private WeatherService weatherService;

	@Override
	public boolean areWeatherConditionsGoodForFly(Weather weather) {
		return weatherService.areWeatherConditionsGoodForFly(weather);
	}

}
