package sn.app.gsl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Singleton {
	//Declaration d'un objet de type Connection
	private static Connection instance=null;
	
	
	//Constructeur prive qui instancie l'att instance
	private Singleton() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/dba_gsl?serverTimezone=UTC";
		String login = "root" ;
		String password = "passer";
		
		instance = DriverManager.getConnection(url, login, password);
		
	}

	/*
	 * Cree une nouvelle connectin si l'instance est nulle
	 * sinon retourne une instance unique
	 */
	
	public static Connection getInstance() throws SQLException {
		if(instance==null) {
			new Singleton();
			}
		return instance;
	}
}
	