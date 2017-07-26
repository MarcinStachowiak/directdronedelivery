package directdronedelivery.dao.impl;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import directdrondelivery.entity.Weather;
import directdronedelivery.dao.WeatherDao;
@Repository
@Scope("singleton")
public class JpaWeatherDaoImpl extends AbstractDao<Weather, Integer> implements WeatherDao {

	@Override
	public Weather createWeather(Integer windInPMS, Integer temperature, boolean lightningsPossible,
			boolean precipitationPossible, Date measurementTime) {
		Weather entity = new Weather();
		entity.setWindInPMS(windInPMS);
		entity.setTemperature(temperature);
		entity.setLightningsPossible(lightningsPossible);
		entity.setPrecipitationPossible(precipitationPossible);
		entity.setMeasurementTime(measurementTime);
		return save(entity);
	}
}
