package com.formation.bank.dao;

import java.util.List;

import com.formation.bank.entities.Employe;
import com.formation.bank.entities.Groupe;

public interface IGroupeDAO {

	public void addGroupe(Groupe g);
	public List<Groupe> consulterGroupe();
	public List<Employe> consulterEmployesParGroupe(Long idG);
}
