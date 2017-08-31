package com.formation.bank.dao;

import java.util.List;

import javax.persistence.Query;

import com.formation.bank.entities.Employe;
import com.formation.bank.entities.Groupe;

public interface IEmployeDAO {

	public void addEmploye(Employe e, Long numEmpSup);
	public void addEmployeToGroupe(Long idGroupe, Long idEmp);
	public List<Employe> consulterEmployes();
	public Employe consulterEmploye(Long idEmp);

}
