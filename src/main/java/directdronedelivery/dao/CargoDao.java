package directdronedelivery.dao;

import directdronedelivery.entity.Cargo;

public interface CargoDao {
	public Cargo findCargoByName(String cargoName);

	public Cargo createCargo(Integer weight, Integer height, Integer length, Integer width, String recipientName,
			String recipientPhone, String recipientEmail);
}
