package sn.app.gsl.metier.impl;

import java.util.List;

import sn.app.gsl.dao.IDao;
import sn.app.gsl.dao.IDaoDivers;
import sn.app.gsl.dao.impl.DaoBI;
import sn.app.gsl.dao.impl.DaoDiversImpl;
import sn.app.gsl.dao.impl.DaoLocataire;
import sn.app.gsl.dao.impl.DaoPayement;
import sn.app.gsl.dao.impl.DaoUser;
import sn.app.gsl.entites.BienImmobilier;
import sn.app.gsl.entites.Locataire;
import sn.app.gsl.entites.Payement;
import sn.app.gsl.entites.User;
import sn.app.gsl.exceptions.DAOException;
import sn.app.gsl.exceptions.MetierException;
import sn.app.gsl.metier.IMetier;

public class Metier implements IMetier {
	
	//Declaration des objets d'acces aux donnees referecent par leur interfaces
	private IDao<User> daoUser;
	private IDao<BienImmobilier> daoBI;
	private IDao<Locataire> daoLocataire;
	private IDao<Payement> daoPayement;
	private IDaoDivers daoDivers;
	
	public Metier() {
		//Initialisation des objets d'acces aux donnees a l'aide de leur classe d'implementation
		daoUser = new DaoUser();
		daoBI = new DaoBI();
		daoLocataire = new DaoLocataire();
		daoPayement = new DaoPayement();
		daoDivers = new DaoDiversImpl() ;
	}
	

	
	/*
	 * Retourne le type_compte si le login et le password de user fournit 
	 * existe en source de donnees
	 */
	@Override
	public String authentification(User user) throws MetierException {
		
		try {
				return daoDivers.authentification(user);
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
	}

	//supprime un user dans la source de donnees
	@Override
	public void supprimerUser(int id) throws MetierException {
		
		try {
			daoUser.delete(id);
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
	}

	//ajouter un user dans la source de donnees
	@Override
	public void ajouterUser(User user) throws MetierException {
		try {
			daoUser.create(user);
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
	}

	//modifie un user dans la source de donnee
	@Override
	public void modifierUser(User user) throws MetierException {
		try {
			daoUser.update(user);
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
		
	}

	//retourne la liste de tous les user presents dans notre source de donnees
	@Override
	public List<User> listeUsers() throws MetierException {
		try {
			return daoUser.list();
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
	}

	//Retrouve un user presents dans notre source de donnees
	@Override
	public User rechercherUser(int id) throws MetierException {
		try {
			return (User) daoUser.read(id);
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
	}

	//Desactive un bien immobilier dans la source de donnees
	@Override
	public void desactiverBI(int id) throws MetierException {
		try {
			 daoDivers.desactiverBI(id);
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
	}

	//Ajoute un bien immobilier dans la source de donnees
	@Override
	public void ajouterBI(BienImmobilier bImmobilier) throws MetierException {
		try {
			daoBI.create(bImmobilier);
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
	}

	//Modifie un bien immobilier dans la source de donnees
	@Override
	public void modifierBI(BienImmobilier bImmobilier) throws MetierException {
		try {
			daoBI.update(bImmobilier);
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
		
	}

	//Retourne la liste de tous les biens immobiliers dans la source de donnees
	@Override
	public List<BienImmobilier> listeBI() throws MetierException {
		try {
			return daoBI.list();
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}	}

	//Retourne un bien immobilier dans la source de donnees 
	@Override
	public BienImmobilier rechercherBI(int id) throws MetierException {
		try {
			return daoBI.read(id);
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
	}

	//Libere un bien immobilier dans la source de donnees
	@Override
	public void libererBI(int idBI, int idLoc) throws MetierException {
		try {
			 daoDivers.libererBI(idBI);
			 daoLocataire.delete(idLoc);
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
		
	}
	
	
	/*
	 * Ajoute un locataire dans la source de donnees
	 * Affecte un bien immobilier dans la source de donnees
	 */
	@Override
	public void affecterBI(Locataire locataire) throws MetierException {
		try {
			
			daoLocataire.create(locataire);
			daoDivers.affecterBI(locataire.getIdBI());
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
	}


	//Retourne la liste des locataires dans la source de donnees
	@Override
	public List<Locataire> listeLocataires() throws MetierException {
		try {
			return daoLocataire.list();
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
	}

	//Supprime un payement dans la source de donnees
	@Override
	public void supprimerPayement(int id) throws MetierException {
		try {
			daoPayement.delete(id);
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
	}

	//Ajoute un payement dans la source de donnees
	@Override
	public void ajouterPayement(Payement payement) throws MetierException {
		try {
			daoPayement.create(payement);
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
	}

	//Modifie un payement dans la source de donnees
	@Override
	public void modifierPayement(Payement payement) throws MetierException {
		try {
			 daoPayement.update(payement);
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
		
	}

	//Retourne la liste des payements dans la source de donnees
	@Override
	public List<Payement> listePayements() throws MetierException {
		try {
			return daoPayement.list();
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
	}

	//Retourne un payement dans la source de donnees
	@Override
	public Payement rechercherPayement(int id) throws MetierException {
		try {
			return daoPayement.read(id);
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
	}

	//Retourne la liste des biens immobilier dispo
	@Override
	public List<BienImmobilier> listeBIDisponible() throws MetierException {
		try {
			return daoDivers.listBienDispo();
		} catch (DAOException e) {
			throw new MetierException(e.getMessage());
		}
	}	
}
