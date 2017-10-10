package directdronedelivery.service;

import directdronedelivery.entity.Weather;

public interface WeatherService {
	public boolean areWeatherConditionsGoodForFly(Weather weather);
}
