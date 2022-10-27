package sn.app.gsl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.app.gsl.dao.IDao;
import sn.app.gsl.dao.Singleton;
import sn.app.gsl.entites.User;
import sn.app.gsl.exceptions.DAOException;

/**
 * Classe d'implementation User en base de donnees 
 * de l'interface d'acces aux donnees
 * @author Gaoussou
 *
 */
public class DaoUser implements IDao<User> {

	

	@Override
	public void create(User user) throws DAOException {
		try {
			Connection conx = Singleton.getInstance();
			
			String sql = "INSERT INTO t_users VALUES (?, ?,?,?,?,?,?,?,?,?, ?)";
			PreparedStatement statement = conx.prepareStatement(sql);
			statement.setInt(1, 0);
			statement.setString(2, user.getNom());
			statement.setString(3, user.getPrenom());
			statement.setString(4, user.getContact());
			statement.setString(5,  user.getEmail());
			statement.setString(6, user.getDateNaissance());
			statement.setString(7, user.getSexe());
			statement.setString(8, user.getAdresse());
			statement.setString(9, user.getLogin());
			statement.setString(10, user.getPassword());
			statement.setString(11, user.getTypeCompte());
			
			statement.execute();
			
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public User read(int id) throws DAOException {
		try {
			Connection conx = Singleton.getInstance();
			String sql = "select * from t_users where id =? ";
			PreparedStatement statement = conx.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rslt = statement.executeQuery();
			if(rslt.next()) {
				
				String nom = rslt.getString("nom");
				String prenom = rslt.getString("prenom");
				String contact = rslt.getString("contact");
				String email = rslt.getString("email");
				String date = rslt.getString("date_naissance");
				String sexe = rslt.getString("sexe");
				String adresse = rslt.getString("adresse");
				String login = rslt.getString("login");
				String password = rslt.getString("password");
				String typeCompte = rslt.getString("type_compte");
				
				return new User(id, nom, prenom, contact, email, date, sexe, adresse, login, password, typeCompte);
			}
			
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		return null;
	}

	
	@Override
	public void update(User user) throws DAOException {

		try {
			Connection conx = Singleton.getInstance();
		String sql = "update t_users set NOM =?, PRENOM=?, ADRESSE=?, CONTACT=?, "
					+ "DATE_NAISSANCE=?, EMAIL=?, LOGIN=?, PASSWORD=?, TYPE_COMPTE=?, sexe = ? where id =?";
			PreparedStatement statement = conx.prepareStatement(sql);
			statement.setString(1, user.getNom());
			statement.setString(2, user.getPrenom());
			statement.setString(3, user.getAdresse());
			statement.setString(4, user.getContact());
			statement.setString(5, user.getDateNaissance());
			statement.setString(6, user.getEmail());
			statement.setString(7, user.getLogin());
			statement.setString(8, user.getPassword());
			statement.setString(9, user.getTypeCompte());			
			statement.setString(10, user.getSexe());
			statement.setInt(11, user.getId());	
			statement.execute();
			
		}catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void delete(int id) throws DAOException {
		
		try {
			Connection conx = Singleton.getInstance();
				String sql = "delete from t_users where id = ?";
				PreparedStatement statement = conx.prepareStatement(sql);
				statement.setInt(1, id);
				statement.execute();
			}catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		
	}

	@Override
	public List<User> list() throws DAOException {
		try {
			Connection conx = Singleton.getInstance();			
			
			String sql = "select * from t_users order by type_compte";
			PreparedStatement statement = conx.prepareStatement(sql);
			ResultSet rslt = statement.executeQuery();
			
			List<User> listEtudiants = new ArrayList<User>();
			while(rslt.next()) {
				
				int id = rslt.getInt("id");						
				String nom = rslt.getString("nom");
				String prenom = rslt.getString("prenom");
				String contact = rslt.getString("contact");
				String email = rslt.getString("email");
				String date = rslt.getString("date_naissance");
				String sexe = rslt.getString("sexe");
				String adresse = rslt.getString("adresse");
				String login = rslt.getString("login");
				String password = rslt.getString("password");
				String typeCompte = rslt.getString("type_compte");
				
				listEtudiants.add(new User(id, nom, prenom, contact, email, date, sexe, adresse, login, password, typeCompte));		
				}
			return listEtudiants;
			
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}	
	}
}
