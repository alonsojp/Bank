package com.formation.bank.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.formation.bank.dao.IEmployeDAO;
import com.formation.bank.entities.Employe;
import com.formation.bank.entities.Groupe;

public class IEmployeDAOImpl implements IEmployeDAO {

	private EntityManager em;
	private EntityTransaction tx;
	
	public IEmployeDAOImpl() {
		super();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_BANK");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public void addEmploye(Employe employe, Long numEmpSup) {
		if (numEmpSup != 0) {
		
			employe.setSupHierarchique(em.find(Employe.class, numEmpSup));
		}
		tx.begin();
		em.persist(employe);
		tx.commit();
	}

	public void addEmployeToGroupe(Long idGroupe, Long idEmp) {
		Employe employe = em.find(Employe.class, idEmp);
		Groupe groupe = em.find(Groupe.class, idGroupe);
		employe.getGroupes().add(groupe);
//		groupe.getEmployes().add(employe);
		tx.begin();
		em.merge(employe);
		tx.commit();
//		em.merge(groupe);
	}
	@SuppressWarnings("unchecked")
	public List<Employe> consulterEmployes() {
		Query q = em.createQuery("SELECT emp FROM Employe emp");
		List<Employe> listemployes = (List<Employe>) q.getResultList();
		return listemployes;
	}
	
	public Employe consulterEmploye(Long idEmp){
		Employe employe=em.find(Employe.class,idEmp);
		return employe;	
	}	
}
