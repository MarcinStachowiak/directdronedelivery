package directdrondelivery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import directdrondelivery.entity.enumerators.DroneStatus;
import directdrondelivery.entity.enumerators.DroneType;

@Entity
@Table(name = "DRONE")
public class Drone {
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME", columnDefinition = "VARCHAR(50) NOT NULL UNIQUE")
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "DRONE_TYPE", nullable=false)
	private DroneType type;

	@Enumerated(EnumType.STRING)
	@Column(name = "DRONE_STATUS", nullable=false)
	protected DroneStatus status;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Drone that = (Drone) o;

		return id != null ? id.equals(that.id) : that.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DroneType getType() {
		return type;
	}

	public void setType(DroneType type) {
		this.type = type;
	}

	public DroneStatus getStatus() {
		return status;
	}

	public void setStatus(DroneStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Drone{" + "droneID=" + id + ", droneType=" + type + ", status=" + status + '}';
	}
}
