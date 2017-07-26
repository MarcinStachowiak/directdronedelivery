package directdrondelivery.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "FLIGHT")
public class Flight {
	@Id
	@GeneratedValue
	@Column(name="ID")
    private Integer id;
	@OneToOne
	@JoinColumn(name="DRONE_ID")
	private Drone drone;
	@OneToOne
	@JoinColumn(name="CARG_ID")
	private Cargo cargo;
	@OneToOne
	@JoinColumn(name="WEATHER_ID")
	private Weather weather;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FLIGHT_TIME", nullable = false)
	private Date date;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Drone getDrone() {
		return drone;
	}
	public void setDrone(Drone drone) {
		this.drone = drone;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public Weather getWeather() {
		return weather;
	}
	public void setWeather(Weather weather) {
		this.weather = weather;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", drone=" + drone + ", cargo=" + cargo + ", weather=" + weather + ", date=" + date
				+ "]";
	}

}
