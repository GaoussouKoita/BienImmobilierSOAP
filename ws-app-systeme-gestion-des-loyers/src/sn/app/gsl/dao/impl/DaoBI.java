package sn.app.gsl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.app.gsl.dao.IDao;
import sn.app.gsl.dao.Singleton;
import sn.app.gsl.entites.BienImmobilier;
import sn.app.gsl.exceptions.DAOException;

/**
 * Classe d'implementation Bien Immobilier en base de donnee 
 * de l'interface d'access aux donnees
 * @author Gaoussou
 *
 */
public class DaoBI implements IDao<BienImmobilier> {


	@Override
	public void create(BienImmobilier bienImmobilier) throws DAOException {
		
		try {
			Connection conx = Singleton.getInstance();
			String sql = "INSERT INTO t_bienimmobilier VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement statement = conx.prepareStatement(sql);
			
			statement.setInt(1, 0);
			statement.setString(2, bienImmobilier.getAdresse());
			statement.setDouble(3, bienImmobilier.getLoyer());
			statement.setInt(4, bienImmobilier.getNbrePiece());
			statement.setString(5, bienImmobilier.getDetails());
			statement.setString(6, bienImmobilier.getMeuble());
			statement.setString(7, bienImmobilier.getTypeBI());
			statement.setString(8, bienImmobilier.getStatus());
			statement.execute();
			
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public BienImmobilier read(int id) throws DAOException {
			try{
				Connection conx = Singleton.getInstance();
			String sql = "select * from t_bienimmobilier where id = ?";
			PreparedStatement statement = conx.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				String adresse = resultSet.getString("adresse");
				double loyer = resultSet.getDouble("loyer");
				int nbrePiece = resultSet.getInt("nombre_piece");
				String details = resultSet.getString("details");
				String meuble = resultSet.getString("meuble");
				String type = resultSet.getString("type");
				String status = resultSet.getString("status");	
				
				return new BienImmobilier(id, adresse, loyer, nbrePiece, details, meuble, type, status);				
			}			
			
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
			return null;
	}

	@Override
	public void update(BienImmobilier bienImmobilier) throws DAOException {
		try{
			Connection conx = Singleton.getInstance();
			String sql = "update t_bienimmobilier set adresse =?, loyer=?, nombre_piece=?, details=?, "
					+ "meuble=?, type=?, status=? where id =?";
			PreparedStatement statement = conx.prepareStatement(sql);
			statement.setString(1, bienImmobilier.getAdresse());
			statement.setDouble(2, bienImmobilier.getLoyer());
			statement.setInt(3, bienImmobilier.getNbrePiece());
			statement.setString(4, bienImmobilier.getDetails());
			statement.setString(5, bienImmobilier.getMeuble());
			statement.setString(6, bienImmobilier.getTypeBI());
			statement.setString(7, bienImmobilier.getStatus());	
			statement.setInt(8, bienImmobilier.getId());
			
			statement.execute();
			
		}catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

	}

	@Override
	public void delete(int id) throws DAOException {}

	@Override
	public List<BienImmobilier> list() throws DAOException {
		try {
			
			Connection conx = Singleton.getInstance();
			String sql = "select * from t_bienimmobilier order by status, type";
			PreparedStatement statement = conx.prepareStatement(sql);
			ResultSet rslt = statement.executeQuery();
			
			List<BienImmobilier> listBI = new ArrayList<>();
			while(rslt.next()) {
				
				int id = rslt.getInt("id");						
				String adresse = rslt.getString("adresse");
				double loyer = rslt.getDouble("loyer");
				int nbrePiece = rslt.getInt("nombre_piece");
				String details = rslt.getString("details");
				String meuble = rslt.getString("meuble");
				String typeBI = rslt.getString("type");
				String status = rslt.getString("status");
				listBI.add(new BienImmobilier(id, adresse, loyer, nbrePiece, details, meuble, typeBI, status));		
				}
			return listBI;
			
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
		
	}
	
}
