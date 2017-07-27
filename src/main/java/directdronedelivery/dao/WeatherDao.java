package directdronedelivery.dao;

import java.util.Date;

import directdronedelivery.entity.Weather;

public interface WeatherDao {
	Weather createWeather(Integer windInPMS, Integer temperature, boolean lightningsPossible,
			boolean precipitationPossible, Date date);
}
