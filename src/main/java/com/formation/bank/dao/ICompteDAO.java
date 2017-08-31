package com.formation.bank.dao;

import java.util.Date;

import com.formation.bank.entities.Client;
import com.formation.bank.entities.Compte;
import com.formation.bank.entities.Employe;
import com.formation.bank.entities.Operation;
import com.formation.bank.entities.Versement;

public interface ICompteDAO {

	public void addCompte(Compte c, Long numCli, Long numEmp);
	public void addOperation(Operation op, String numCpte, Long numEmp);
	public Compte consulterCompte(String numCpte);

}
