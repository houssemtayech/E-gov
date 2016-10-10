package tn.esprit.services;

import javax.ejb.Local;

import tn.esprit.domain.Agent;

@Local
public interface AgentGestionLocal {
	public Agent Authentification(String login , String pwd);
	public Agent findAgentById(int id);
}
