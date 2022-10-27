package sn.app.gsl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sn.app.gsl.dao.IDao;
import sn.app.gsl.dao.Singleton;
import sn.app.gsl.entites.Payement;
import sn.app.gsl.exceptions.DAOException;

/**
 * Classe d'implementation de Payement en base de donnees 
 * de l'interface d'acces aux donnees
 * @author Gaoussou
 *
 */
public class DaoPayement implements IDao<Payement> {

	@Override
	public void create(Payement payement) throws DAOException {

		try {
			Connection conx = Singleton.getInstance();		
			String sql = "INSERT INTO t_payement VALUES (?,?,?,?,?,?)";
			PreparedStatement statement = conx.prepareStatement(sql);
			
			statement.setInt(1, 0);
			statement.setString(2, payement.getDatePayement());
			statement.setDouble(3, payement.getMontant());
			statement.setString(4, payement.getNomLocataire());
			statement.setString(5, payement.getPrenomLocataire());
			statement.setInt(6, payement.getIdBI());
			statement.execute();
			
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public Payement read(int id) throws DAOException {
		try {
			Connection conx = Singleton.getInstance();		
			String sql = "select * from t_payement where id = ?";
			PreparedStatement statement = conx.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				String datePayement = resultSet.getString("date_payement");
				double montant = resultSet.getDouble("montant");
				String nomLocataire = resultSet.getString("nom_locataire");
				String prenomLocataire = resultSet.getString("prenom_locataire");
				int idBI = resultSet.getInt("id_bi");	
				
				return new Payement(id, datePayement, montant, nomLocataire, prenomLocataire, idBI);		
			}			
			
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
			return null;
	}

	@Override
	public void update(Payement payement) throws DAOException {
		try {
			Connection conx = Singleton.getInstance();
			String sql = "update t_payement set date_payement =?, montant=?, nom_locataire=?, prenom_locataire=?, "
					+ "id_BI=? where id =?";
			PreparedStatement statement = conx.prepareStatement(sql);
			statement.setString(1, payement.getDatePayement());
			statement.setDouble(2, payement.getMontant());
			statement.setString(3, payement.getNomLocataire());
			statement.setString(4, payement.getPrenomLocataire());
			statement.setInt(5, payement.getIdBI());
			statement.setInt(6, payement.getId());			
			statement.execute();
			
		}catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		
	}

	@Override
	public void delete(int id) throws DAOException {
		
		try {
			Connection conx = Singleton.getInstance();
				String sql = "delete from t_payement where id = ?";
				PreparedStatement statement = conx.prepareStatement(sql);
				statement.setInt(1, id);
				statement.execute();
				
			}catch (SQLException e) {
				throw new DAOException(e.getMessage());
			}
		}

	@Override
	public List<Payement> list() throws DAOException {
		
		try {
			Connection conx = Singleton.getInstance();
					
			String sql = "select * from t_payement";
			PreparedStatement statement = conx.prepareStatement(sql);
			ResultSet rslt = statement.executeQuery();
			
			List<Payement> listBI = new ArrayList<>();
			while(rslt.next()) {
				
				int id = rslt.getInt("id");						
				String datePayement = rslt.getString("date_payement");
				double montant = rslt.getDouble("montant");
				String nomLocataire = rslt.getString("nom_locataire");
				String prenomLocataire = rslt.getString("prenom_locataire");
				int idBI = rslt.getInt("id_BI");
				listBI.add( new Payement(id, datePayement, montant, nomLocataire, prenomLocataire, idBI));		
				}
			return listBI;
			
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

}
