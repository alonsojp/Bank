package com.formation.bank.dao;

import java.util.List;

import com.formation.bank.entities.Client;

public interface IClientDAO {

	public void addClient(Client c);
	public void supprimerClient(Client c);
//	public void modifierClient(Client c);
	public List<Client> consulterClients();
	public Client consulterClientsParId(Long id);
	public List<Client> consulterClientsParNom(String nomClient);

}
