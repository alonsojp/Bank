package com.formation.bank.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.formation.bank.dao.IClientDAO;
import com.formation.bank.entities.Client;

public class IClientDAOImpl extends AbstractFacadeDAO<Client> implements IClientDAO {

	private EntityManager em;
	private EntityTransaction tx; 
	
	public IClientDAOImpl() {
		super(Client.class);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_BANK");
		em = emf.createEntityManager();
		tx = getEntityManager().getTransaction();
	}
//
//	@SuppressWarnings("unchecked")
//	public List<Client> consulterClients() {
//		Query q = em.createQuery("SELECT cl FROM Client cl");
//
//		List<Client> listclients = (List<Client>) q.getResultList();
//		return listclients;
//	}


	@Override
	public void addClient(Client c) {
		tx.begin();
		create(c);
		tx.commit();
	}

	@Override
	public void supprimerClient(Client c) {
		tx.begin();
		remove(c);
		tx.commit();
	}
	@Override
	public List<Client> consulterClients() {
		return findAll(new Client());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> consulterClientsParNom(String nomClient) {
		return em.createQuery("SELECT cl FROM Client cl WHERE cl.nom= :nom").setParameter("nom", nomClient).getResultList();
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public Client consulterClientsParId(Long id) {
		return (Client)findById(Client.class, id);
	}
	
}
