package sn.app.gsl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sn.app.gsl.dao.IDaoDivers;
import sn.app.gsl.dao.Singleton;
import sn.app.gsl.entites.BienImmobilier;
import sn.app.gsl.entites.User;
import sn.app.gsl.exceptions.DAOException;

/**
 * Classe d'implementation en base de donnees
 * de l'interface d'acces au donnees
 * @author Gaoussou
 *
 */
public class DaoDiversImpl implements IDaoDivers {


	@Override
	public String authentification(User user)  throws DAOException{
		try {
			Connection conx = Singleton.getInstance();			
			String sql = "select type_compte from t_users where login =? and password = ?";
			PreparedStatement statement = conx.prepareStatement(sql);
			statement.setString(1, user.getLogin());
			statement.setString(2, user.getPassword());
			ResultSet rslt = statement.executeQuery();
			if(rslt.next()) {
				return rslt.getString("type_compte");
			}else {
				return null;
			}
			
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}
	
	@Override
	public void affecterBI(int idBI) throws DAOException {
		changeStatus(idBI, "Occupe");
		
	}

	@Override
	public void desactiverBI(int id)  throws DAOException{
		changeStatus(id, "DESACTIVE");
	}

	@Override
	public void libererBI(int id) throws DAOException {
		changeStatus(id, "Disponible");

	}

	@Override
	public List<BienImmobilier> listBienDispo() throws DAOException{
		try {
			Connection conx = Singleton.getInstance();
			String sql = "select * from t_bienimmobilier where status= 'Disponible' order by type";
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

	private void changeStatus(int id, String status) throws DAOException {
		try {
			Connection conx = Singleton.getInstance();
			String sql = "update t_bienimmobilier set status='"+status+"' where id =?";
			PreparedStatement statement = conx.prepareStatement(sql);
			statement.setInt(1, id);
			
			statement.execute();
			
		}catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

}
