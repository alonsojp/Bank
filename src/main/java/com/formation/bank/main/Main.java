package com.formation.bank.main;

import java.util.List;

import com.formation.bank.dao.IClientDAO;
import com.formation.bank.dao.IEmployeDAO;
import com.formation.bank.dao.impl.IClientDAOImpl;
import com.formation.bank.dao.impl.IEmployeDAOImpl;
import com.formation.bank.entities.Client;
import com.formation.bank.entities.Employe;

public class Main {

	public static void main(String[] args) {
		
		IClientDAO cldao= new IClientDAOImpl();
		String i = String.valueOf(Math.random() * 100);
//		Client c1 = new Client();
//		c1.setNom("JP A");
//		cldao.addClient(c1);
//		Client c2 = new Client();
//		c2.setNom("JP B");
//		cldao.addClient(c2);
//		Client c3 = new Client();
//		c3.setNom("JP C");
//		cldao.addClient(c3);
		
		List <Client> lCli = cldao.consulterClients();
		for (Client cli : lCli) {
			System.out.println(cli);
		}

		System.out.println("Execution Clients OK");

		IEmployeDAO empDAO = new IEmployeDAOImpl();
		Employe e = new Employe();
		e.setNomEmploye("JP Chef");
		empDAO.addEmploye(e, 0L);
		Employe e2 = new Employe();
		e2.setNomEmploye("JP Grouillot");
		empDAO.addEmploye(e2, 1L);
		
		List <Employe> lEmpl = empDAO.consulterEmployes();
		for (Employe emp : lEmpl) {
			System.out.println(emp);
		}

	}
	
	

}
