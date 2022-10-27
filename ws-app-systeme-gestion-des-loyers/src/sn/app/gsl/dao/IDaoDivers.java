package sn.app.gsl.dao;

import java.util.List;

import sn.app.gsl.entites.BienImmobilier;
import sn.app.gsl.entites.User;
import sn.app.gsl.exceptions.DAOException;

public interface IDaoDivers {
	
	//Retourne le type_compte d'un user en fonction du login et du password
	public String authentification(User user) throws DAOException ;
	
	//Change le status d'un bien immoblier en 'DESACTIVE'
	public void desactiverBI(int id)  throws DAOException;
	
	//Change le status d'un bien immoblier en 'Disponible'
	public void libererBI(int id)  throws DAOException;
	
	//Retourne une liste de bien immobilier ave le status 'Disponible'	
	public List<BienImmobilier> listBienDispo() throws DAOException;

	//Change le status d'un bien immoblier en 'Occupé'
	public void affecterBI(int idBI) throws DAOException;
	
}

