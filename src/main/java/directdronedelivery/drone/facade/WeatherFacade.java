package directdronedelivery.drone.facade;

import directdrondelivery.entity.Weather;

public interface WeatherFacade {
	public boolean areWeatherConditionsGoodForFly(Weather weather);
}
