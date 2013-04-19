package edu.makoto.multilingual.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.ResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BaseDAO{

	protected final Log logger=LogFactory.getLog(getClass());

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	protected Query createQuery(String sql){
		return getCurrentSession().createQuery(sql);
	}
	
	public <T> List<T> find(String sql, Object... params) {
		Query query=getCurrentSession().createQuery(sql);
		
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		
		List list = query.list();
		
		logger.debug("Find : " + query);		
		logger.debug("Found : " + ((list != null) ? list.size() : "null lista"));
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public <T>List<T> findByQuery(Class<T> clazz,Query query){
		logger.info("findByQuery (" + clazz.getSimpleName() + ") : " + query);
		
		List<T> list=query.list();
		logger.info("Found : " + ((list != null) ? list.size() : "null lista"));
		return list;
	}
	
	/**
	 * Find the entity by the identifier
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T>T findById(Class<T> clazz,Serializable id){
		logger.debug("FindById (" + clazz.getSimpleName() + ") : " + id);
		return (T) getCurrentSession().get(clazz,id);
	}
	
	

	/**
	 * Return a list of entities that match with the criteria given by the query
	 * and the params
	 * 
	 * @param clazz
	 * @param sql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T>List<T> find(Class<T> clazz,String sql){		
		Query query=getCurrentSession().createQuery(sql);		
		List<T> list=query.list();
		logger.info("Find : " + query);
		logger.info("Found : " + ((list != null) ? list.size() : "null lista"));
		return list;
	}
	

	/**
	 * Resolve the hibernate connections. When an entity is loaded from the
	 * database, and the connection with another entities is lazy type (or proxy
	 * type), the related entities is not loaded yet, until this is explicitly
	 * used by the application in the transaction scope. To load this, we need
	 * 'initializate' the proxies connection
	 * 
	 * @param object
	 */
	public void initialize(Object object){
		Hibernate.initialize(object);
	}

	/**
	 * Save the entity, this is, notify to hibernate that this entity is changed
	 * and require serialization. The real change is given when Hibernate make
	 * the commit at the end of the transaction, OR, this changes are ignored if
	 * an exception produce a rollback.
	 * 
	 * @param entity
	 */
	public void save(Entity entity){
		logger.debug("Saving " + entity);
		getCurrentSession().save(entity);
	}
	
	/**
	 * Update the entity, this is, notify to hibernate that this entity is changed
	 * and require serialization. The real change is given when Hibernate make
	 * the commit at the end of the transaction, OR, this changes are ignored if
	 * an exception produce a rollback.
	 * 
	 * @param entity
	 */
	public void update(Entity entity){
		logger.debug("Updating " + entity);
		getCurrentSession().update(entity);
	}

	/**
	 * A difference of the simple save, this method, first evaluate if the
	 * entity exists, then update from the given entity parameter, if not
	 * exists, create a new in the database. This is created in the hibernate
	 * cache until the transaction finish with a commit or a rollback.
	 * 
	 * @param entity
	 */
	public void saveOrUpdate(Entity entity){
		logger.debug("Saving " + entity);
		getCurrentSession().saveOrUpdate(entity);
	}

	public void delete(Entity entity){
		getCurrentSession().delete(entity);
	}

	/**
	 * This Method return the class specific
	 * 
	 * */

	@SuppressWarnings("unchecked")
	public <T>T findByIdWithout(Class<T> clazz){
		logger.debug("findByIdWithout (" + clazz.getSimpleName() + ") ");
		return (T) getCurrentSession().createQuery("from " + clazz.getName()).list();
	}

}
