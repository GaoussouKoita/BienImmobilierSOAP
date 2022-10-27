package sn.app.gsl.dao;

import java.util.List;
import sn.app.gsl.exceptions.DAOException;

public interface IDao<T> {	
	
	//Creation d'un objet T
	public void create(T t) throws DAOException;
	
	//Lecture d'un objet T
	public T read(int id) throws DAOException;
	
	//Mise a jour d'un objet T
	public void update(T t) throws DAOException;
	
	//Suppression d'un objet T
	public void delete(int id) throws DAOException;
	
	//Lecture ou la liste de tous les objets T
	public List<T> list() throws DAOException;
	

}
