package sn.app.gsl.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import sn.app.gsl.entites.BienImmobilier;
import sn.app.gsl.entites.Locataire;
import sn.app.gsl.entites.Payement;
import sn.app.gsl.entites.User;
import sn.app.gsl.exceptions.MetierException;
import sn.app.gsl.metier.IMetier;
import sn.app.gsl.metier.impl.Metier;
/**
 * Creation du web service  qui expose 
 * les fonctionnalites metier de l'application
 * @author Gaoussou
 *
 */
@WebService
public class WSAppGSL {
	private IMetier metier;
	
	public WSAppGSL() {
		metier = new Metier();
	}
	
	@WebMethod
	public String authentification(@WebParam(name="user") User user) {
		try {
			return metier.authentification(user);
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	
	@WebMethod
	public void supprimerUser(@WebParam(name="id") int id) {
		try {
			metier.supprimerUser(id);
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	@WebMethod
	public void ajouterUser(@WebParam(name="user") User user) {
		try {
			metier.ajouterUser(user);
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		}
		}
	
	@WebMethod
	public void modifierUser(@WebParam(name="user") User user) {
		try {
			metier.modifierUser(user);
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	@WebMethod
	public List<User> listeUsers() {
		try {
			return metier.listeUsers();
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		}
		return null;
		
	}
	
	
	@WebMethod
	public User rechercherUser(@WebParam(name="id") int id) {
		try {
			return metier.rechercherUser(id);
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		}
		return null;
		
	}


	@WebMethod
	public void desactiverBI(@WebParam(name="id") int id) {
		try {
			metier.desactiverBI(id);
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	
	@WebMethod
	public void ajouterBI(@WebParam(name="bienImmoblier") BienImmobilier bImmobilier) {
		try {
			metier.ajouterBI(bImmobilier);
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	
	@WebMethod
	public void modifierBI(@WebParam(name="bienImmoblier") BienImmobilier bImmobilier) {
		try {
			metier.modifierBI(bImmobilier);
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		};
		
	}
	
	
	@WebMethod
	public List<BienImmobilier> listeBI() {
		try {
			return metier.listeBI();
		} catch (MetierException e) {
			System.err.println(e.getMessage());  }
		return null;
		}
	
	
	@WebMethod
	public List<BienImmobilier> listeBIDisponible() {
		try {
			return metier.listeBIDisponible();
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		}
		return null;
		}
	
	
	@WebMethod
	public BienImmobilier rechercherBI(@WebParam(name="id") int id) {
		try {
			return metier.rechercherBI(id);
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		}
		return null;
		}
	
	
	@WebMethod
	public void libererBI(@WebParam(name="idBI") int idBI, @WebParam(name="idLoc") int idLoc)  {
		try {
			metier.libererBI(idBI, idLoc);
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	
	@WebMethod
	public void affecterBI(@WebParam(name="locataire")Locataire locataire) {
		try {
			metier.affecterBI(locataire);
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	@WebMethod
	public List<Locataire> listeLocataires() {
		try {
			return metier.listeLocataires();
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		}
		return null;
		}

	@WebMethod
	public void supprimerPayement(@WebParam(name="id") int id) {
		try {
			metier.supprimerPayement(id);
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	@WebMethod
	public void ajouterPayement(@WebParam(name="payement") Payement payement) {
		try {
			metier.ajouterPayement(payement);
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		}
		}
	
	
	@WebMethod
	public void modifierPayement(@WebParam(name="payement") Payement payement) {
		try {
			metier.modifierPayement(payement);
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	@WebMethod
	public List<Payement> listePayements() {
		try {
			return metier.listePayements();
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		}
		return null;
		}
	
	
	@WebMethod
	public Payement rechercherPayement(@WebParam(name="id") int id) {
		try {
			return metier.rechercherPayement(id);
		} catch (MetierException e) {
			System.err.println(e.getMessage());
		}
		return null;
		}

}
