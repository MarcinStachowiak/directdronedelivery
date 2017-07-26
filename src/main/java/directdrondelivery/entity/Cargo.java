package directdrondelivery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARGO")
public class Cargo {
	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "WEIGHT", nullable = false)
	private Integer weight;

	@Column(name = "HEIGHT", nullable = false)
	private Integer height;

	@Column(name = "LENGTH", nullable = false)
	private Integer length;

	@Column(name = "WIDTH", nullable = false)
	private Integer width;

	@Column(name = "RECIPIENT_NAME", nullable = false)
	private String recipientName;

	@Column(name = "RECIPIENT_PHONE")
	private String recipientPhone;

	@Column(name = "RECIPIENT_EMAIL")
	private String recipientEmail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientPhone() {
		return recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}

	public String getRecipientEmail() {
		return recipientEmail;
	}

	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", weight=" + weight + ", height=" + height + ", length=" + length + ", width="
				+ width + ", recipientName=" + recipientName + ", recipientPhone=" + recipientPhone
				+ ", recipientEmail=" + recipientEmail + "]";
	}


}
