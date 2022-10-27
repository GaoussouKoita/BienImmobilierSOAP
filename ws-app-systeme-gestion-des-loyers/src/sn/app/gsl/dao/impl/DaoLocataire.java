package sn.app.gsl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.app.gsl.dao.IDao;
import sn.app.gsl.dao.Singleton;
import sn.app.gsl.entites.Locataire;
import sn.app.gsl.exceptions.DAOException;

/**
 * Classe d'implementation Locataire en base de donnees
 * de l'interface d'acces aux donnees
 * @author Gaoussou
 *
 */
public class DaoLocataire implements IDao<Locataire> {

	@Override
	public void create(Locataire locataire) throws DAOException {
		
		try {
			
			Connection conx = Singleton.getInstance();		
			String sql = "insert into t_locataire VALUES (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = conx.prepareStatement(sql);
			
			statement.setInt(1, 0);
			statement.setString(2, locataire.getNom());
			statement.setString(3, locataire.getPrenom());
			statement.setString(4, locataire.getContact());
			statement.setString(5, locataire.getEmail());
			statement.setString(6, locataire.getDateNaissance());
			statement.setString(7, locataire.getSexe());
			statement.setString(8, locataire.getNumCIN());
			statement.setString(9, locataire.getTypeLocation());
			statement.setInt(10, locataire.getIdBI());
			statement.execute();
			
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public Locataire read(int id) throws DAOException {
		return null;	
		}

	@Override
	public void update(Locataire locataire) throws DAOException {}

	@Override
	public void delete(int id) throws DAOException {
		
		try {
			Connection conx = Singleton.getInstance();
				String sql = "delete from t_locataire where id = ?";
				PreparedStatement statement = conx.prepareStatement(sql);
				statement.setInt(1, id);
				statement.execute();
				
			}catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
	}

	@Override
	public List<Locataire> list() throws DAOException {
		try {
			Connection conx = Singleton.getInstance();			
			String sql = "select * from t_locataire";
			PreparedStatement statement = conx.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			List<Locataire> listeLocataire = new ArrayList<Locataire>();
			while(resultSet.next()) {
				
				int id = resultSet.getInt("id");
				String nom = resultSet.getString("nom");
				String prenom = resultSet.getString("prenom");
				String contact = resultSet.getString("contact");
				String email = resultSet.getString("email");
				String dateNaissance = resultSet.getString("date_naissance");
				String sexe = resultSet.getString("sexe");
				String numCIN = resultSet.getString("numero_CIN");
				String typeLocation = resultSet.getString("type_location");
				int idBI = resultSet.getInt("id_bi");
				
				
				listeLocataire.add(new Locataire(id, nom, prenom, contact, email, dateNaissance, sexe, numCIN, typeLocation, idBI));		
			}			
			return listeLocataire;
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

}
