package directdronedelivery.drone.service;

import directdrondelivery.entity.Weather;

public interface WeatherService {
	public boolean areWeatherConditionsGoodForFly(Weather weather);
}
