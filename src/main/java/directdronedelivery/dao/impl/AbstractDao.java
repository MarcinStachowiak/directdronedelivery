package directdronedelivery.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import directdronedelivery.dao.Dao;

@Repository
public abstract class AbstractDao<T, K extends Serializable> implements Dao<T, K> {

	private Class<T> domainClass;
	private EntityManagerFactory entityManagerFactory;

	@Override
	public EntityManager getEntityManager() {
		if(entityManagerFactory==null){
			entityManagerFactory = Persistence.createEntityManagerFactory("JavaHelps");
		}
		return entityManagerFactory.createEntityManager();
	}

	@Override
	public T save(T entity) {
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();

		manager.persist(entity);

		manager.getTransaction().commit();
		manager.close();
		return entity;
	}

	@Override
	public T getOne(K id) {
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();

		T result = manager.getReference(getDomainClass(), id);

		manager.getTransaction().commit();
		manager.close();
		return result;
	}

	@Override
	public T findOne(K id) {
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();

		T result = manager.find(getDomainClass(), id);

		manager.getTransaction().commit();
		manager.close();
		return result;
	}

	@Override
	public List<T> findAll() {
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = builder.createQuery(getDomainClass());
		criteriaQuery.from(getDomainClass());
		TypedQuery<T> query = manager.createQuery(criteriaQuery);
		List<T> results = query.getResultList();

		manager.getTransaction().commit();
		manager.close();
		return results;
	}

	@Override
	public T update(T entity) {
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();

		T result = manager.merge(entity);

		manager.getTransaction().commit();
		manager.close();
		return result;
	}

	@Override
	public void delete(T entity) {
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();

		manager.remove(entity);

		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public void delete(K id) {
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();

		manager.remove(getOne(id));

		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public void deleteAll() {
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();

		manager.createQuery("delete " + getDomainClassName()).executeUpdate();

		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public long count() {
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();

		long result = (long) manager.createQuery("Select count(*) from " + getDomainClassName()).getSingleResult();

		manager.getTransaction().commit();
		manager.close();
		return result;
	}

	@Override
	public boolean exists(K id) {
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();

		boolean result = findOne(id) != null;

		manager.getTransaction().commit();
		manager.close();
		return result;
	}

	@Override
	public List<T> search(String query, Map<String,Object> queryParameters) {
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();

		TypedQuery<T> typedQuery=manager.createQuery(query, getDomainClass());
		queryParameters.entrySet().stream().forEach(e -> typedQuery.setParameter(e.getKey(), e.getValue()));
		List<T> resultList = typedQuery.getResultList();

		manager.getTransaction().commit();
		manager.close();
		return resultList;
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getDomainClass() {
		if (domainClass == null) {
			ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
			domainClass = (Class<T>) type.getActualTypeArguments()[0];
		}
		return domainClass;
	}

	protected String getDomainClassName() {
		return getDomainClass().getName();
	}
}