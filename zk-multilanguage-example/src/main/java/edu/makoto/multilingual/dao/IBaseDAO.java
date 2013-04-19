package edu.makoto.multilingual.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IBaseDAO{

	public <T>T findById(Class<T> clazz,Serializable id);

	public <T>List<T> find(Class<T> clazz,String sql);

	public void initialize(Object object);

	public void save(Entity entity);
	
	public void update(Entity entity);

	public void saveOrUpdate(Entity entity);

	public void delete(Entity entity);

	public <T>T findByIdWithout(Class<T> clazz);

}
