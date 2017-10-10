package directdronedelivery.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import directdronedelivery.entity.Weather;
import directdronedelivery.facade.WeatherFacade;
import directdronedelivery.service.WeatherService;

@Service
public class WeatherFacadeImpl implements WeatherFacade {

	@Autowired
	private WeatherService weatherService;

	@Override
	public boolean areWeatherConditionsGoodForFly(Weather weather) {
		return weatherService.areWeatherConditionsGoodForFly(weather);
	}

}
