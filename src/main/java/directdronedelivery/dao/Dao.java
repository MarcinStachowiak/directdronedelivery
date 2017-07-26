package directdronedelivery.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public interface Dao<T, K extends Serializable> {

	EntityManager getEntityManager();

	T save(T entity);

	T getOne(K id);

	T findOne(K id);

	List<T> findAll();

	T update(T entity);

	void delete(T entity);

	void delete(K id);

	void deleteAll();

	long count();

	List<T> search(String query, Map<String,Object> queryParameters);

	boolean exists(K id);
}
