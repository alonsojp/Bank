package com.formation.bank.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Retrait() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retrait(long numOperation, Date dateOperation, double montant, Compte compte, Employe employe) {
		super(numOperation,dateOperation,montant,compte,employe);
	}
	
}
