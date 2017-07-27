package directdronedelivery.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "WEATHER")
public class Weather {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	protected int id;
	@Column(name = "WIND_IN_PMS", nullable = false)
	protected double windInPMS;
	@Column(name = "LIGHTNINGS_POSSIBLE", nullable = false)
	protected boolean lightningsPossible = false;
	@Column(name = "PRECIPITATION_POSSIBLE", nullable = false)
	protected boolean precipitationPossible = false;
	@Column(name = "TEMPERATIRE", nullable = false)
	protected int temperature;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "MEASUREMENT_TIME", nullable = false)
	private Date measurementTime;

	// TODO 02: tdd implementation: implement first test cases and extend
	// Weather to pass tests... repeat
	public boolean isGoodToFly() {
		return false;
	}

	public double getWindInPMS() {
		return windInPMS;
	}

	public boolean isLightningsPossible() {
		return lightningsPossible;
	}

	public boolean isPrecipitationPossible() {
		return precipitationPossible;
	}

	public int getTemperature() {
		return temperature;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Weather weather = (Weather) o;

		if (Double.compare(weather.windInPMS, windInPMS) != 0)
			return false;
		if (lightningsPossible != weather.lightningsPossible)
			return false;
		if (precipitationPossible != weather.precipitationPossible)
			return false;
		return temperature == weather.temperature;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		temp = Double.doubleToLongBits(windInPMS);
		result = (int) (temp ^ (temp >>> 32));
		result = 31 * result + (lightningsPossible ? 1 : 0);
		result = 31 * result + (precipitationPossible ? 1 : 0);
		result = 31 * result + temperature;
		return result;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getMeasurementTime() {
		return measurementTime;
	}

	public void setMeasurementTime(Date measurementTime) {
		this.measurementTime = measurementTime;
	}

	public void setWindInPMS(double windInPMS) {
		this.windInPMS = windInPMS;
	}

	public void setLightningsPossible(boolean lightningsPossible) {
		this.lightningsPossible = lightningsPossible;
	}

	public void setPrecipitationPossible(boolean precipitationPossible) {
		this.precipitationPossible = precipitationPossible;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "Weather [id=" + id + ", windInPMS=" + windInPMS + ", lightningsPossible=" + lightningsPossible
				+ ", precipitationPossible=" + precipitationPossible + ", temperature=" + temperature + ", measurementTime=" + measurementTime
				+ "]";
	}


}