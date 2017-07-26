package directdronedelivery.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.assertj.core.util.Preconditions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import directdrondelivery.entity.Cargo;
import directdrondelivery.entity.Drone;
import directdrondelivery.entity.enumerators.DroneStatus;
import directdrondelivery.entity.enumerators.DroneType;
import directdronedelivery.dao.CargoDao;
@Repository
@Scope("singleton")
public class JpaCargoDaoImpl extends AbstractDao<Cargo, Integer>implements CargoDao{


	@Override
	public Cargo findCargoByName(String cargoName) {
		Preconditions.checkNotNull(cargoName);

		String query = "select cargo from Cargo cargo where UPPER(cargo.name) = UPPER(:name)";
		Map<String, Object> queryParameters = new HashMap<>();
		queryParameters.put("name", cargoName);
		return search(query, queryParameters).stream().findFirst().orElse(null);
	}

	@Override
	public Cargo createCargo(Integer weight, Integer height,Integer length,Integer width,String recipientName,String recipientPhone,String recipientEmail) {
		Cargo entity = new Cargo();
		entity.setWeight(weight);
		entity.setHeight(height);
		entity.setWidth(width);
		entity.setLength(length);
		entity.setRecipientEmail(recipientEmail);
		entity.setRecipientName(recipientName);
		entity.setRecipientPhone(recipientPhone);
		return save(entity);
	}
}
