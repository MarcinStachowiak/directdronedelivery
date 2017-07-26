package directdronedelivery.dao;

import java.util.Date;

import directdrondelivery.entity.Weather;

public interface WeatherDao {
	Weather createWeather(Integer windInPMS, Integer temperature, boolean lightningsPossible,
			boolean precipitationPossible, Date date);
}
