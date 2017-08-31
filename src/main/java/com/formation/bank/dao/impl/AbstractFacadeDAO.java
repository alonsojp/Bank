package com.formation.bank.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class AbstractFacadeDAO<T> {
	
	private Class<T> entityClass;


	protected abstract EntityManager getEntityManager();
	
	public AbstractFacadeDAO(Class<T> eClass) {
		entityClass = eClass;
	}
	
	public void create(T entity) {
		getEntityManager().persist(entity);
	}
	
	public void remove(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}
	
	public void merge(T entity) {
		getEntityManager().merge(entity);
	}	

	public Object findById(Class entity, Object id) {
		return getEntityManager().find(entity, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(T entity) {
		return getEntityManager().createQuery("SELECT t FROM " + entity.getClass().getName() + " t").getResultList();
	}
}
