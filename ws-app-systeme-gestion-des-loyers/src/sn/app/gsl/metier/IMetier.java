package sn.app.gsl.metier;

import java.util.List;

import sn.app.gsl.entites.BienImmobilier;
import sn.app.gsl.entites.Locataire;
import sn.app.gsl.entites.Payement;
import sn.app.gsl.entites.User;
import sn.app.gsl.exceptions.MetierException;

public interface IMetier {
	
	//Teste d'authentificatinon d'un User
	public String authentification(User user) throws MetierException;
	
	//Les fonctionnnalites liees a un User
	public void supprimerUser(int id) throws MetierException;
	public void ajouterUser(User user) throws MetierException;
	public void modifierUser(User user) throws MetierException;
	public List<User> listeUsers() throws MetierException;
	public User rechercherUser(int id) throws MetierException;
	
	//Les fonctionnalites liees aux biens immobiliers
	public void desactiverBI(int id) throws MetierException;
	public void ajouterBI(BienImmobilier bImmobilier) throws MetierException;
	public void modifierBI(BienImmobilier bImmobilier) throws MetierException;
	public List<BienImmobilier> listeBI() throws MetierException;
	public List<BienImmobilier> listeBIDisponible() throws MetierException;
	public BienImmobilier rechercherBI(int id) throws MetierException;
	public void libererBI(int idBI, int idLoc)  throws MetierException;
	
	//les fonctionnalites liees aux locataires
	public void affecterBI(Locataire locataire)  throws MetierException;
	public List<Locataire> listeLocataires() throws MetierException;
	
	
	//Les fonctionnalites liees aux payements
	public void supprimerPayement(int id) throws MetierException;
	public void ajouterPayement(Payement payement) throws MetierException;
	public void modifierPayement(Payement payement) throws MetierException;
	public List<Payement> listePayements() throws MetierException;
	public Payement rechercherPayement(int id) throws MetierException;
}
