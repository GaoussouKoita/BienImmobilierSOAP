package sn.app.sgl.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sn.app.gsl.ws.BienImmobilier;
import sn.app.gsl.ws.Locataire;
import sn.app.gsl.ws.Payement;
import sn.app.gsl.ws.User;
import sn.app.gsl.ws.WSAppGSL;
import sn.app.gsl.ws.WSAppGSLService;

public class ControllerView {
	
	//Declaration des 3 fenetres de l'application
	private UIConnexion viewConnexion;
	private UIAdministrateur viewAdministrateur;
	private UIGestionnaire viewGestionnaire;
	
	//Declaration du proxy et du stub
	private WSAppGSLService proxy;
	private WSAppGSL stub;
	
	public ControllerView(UIConnexion viewConnexion, UIAdministrateur viewAdministrateur, UIGestionnaire viewGestionnaire) {
		//Initialisation des vues, du proxy et du stub
		this.viewConnexion = viewConnexion ;
		this.viewAdministrateur =viewAdministrateur;
		this.viewGestionnaire =  viewGestionnaire;
		
		proxy = new WSAppGSLService();
		stub = proxy.getWSAppGSLPort();
		
		//Ajout des ecouteurs sur certains composants des fenetres
		addListerners();
	}

	
	private void addListerners() {
		
		//Ajout d'ecouteur sur le bouton connexion de la fenetre principale
		viewConnexion.addBtnConnexionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					onClickConnexion();
				} catch (RuntimeException e) {
					viewConnexion.showMessage("Verifier le Login et/ou le password", 
							"Echec d'Authentification", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		//Ajout d'ecouteur sur le bouton sauvegarderUser de la fentetre Administrateur
		viewAdministrateur.addBtnSauvegarderUserListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					onClickSauvegarderUser();
				} catch (RuntimeException e) {
					viewConnexion.showMessage("Veuillez renseigner le(s) champ(s) obligatoire(s)", 
							"Echec", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		//Ajout d'ecouteur sur le bouton supprimerUser de la fentetre Administrateur
		viewAdministrateur.addBtnSupprimerUserListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					onClickSuppUser();
				} catch (Exception e) {
					viewConnexion.showMessage("Veuillez renseigner le(s) champ(s) obligatoire(s)", 
							"Echec", JOptionPane.ERROR_MESSAGE);
				}	
			}
		});
		
		
		//Ajout d'ecouteur sur le bouton actualiserUser de la fentetre Administrateur
		viewAdministrateur.addBtnActualiserUserListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				onClickActualiserUser();
				
			}
		});
		
		
		//Ajout d'ecouteur sur le bouton rechercherUser de la fentetre Administrateur
		viewAdministrateur.addBtnRechercherUserListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					onClickRechercherUser();
				} catch (Exception e) {
					viewConnexion.showMessage("Veuillez renseigner le(s) champ(s) obligatoire(s)", 
							"Echec", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		
		//Ajout d'ecouteur sur le bouton deonnexionUser de la fentetre Administrateur
		viewAdministrateur.addBtnDeconnexionUserListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onClickDeconnexion(viewAdministrateur, viewConnexion);					
			}
		});
		
		//Ajout d'ecouteur sur le bouton sauvegarderBI de la fentetre Administrateur
		viewAdministrateur.addBtnSauvegarderBIListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					onClickSauvegarderBien();
				} catch (Exception e) {
					viewConnexion.showMessage("Veuillez renseigner le(s) champ(s) obligatoire(s)", 
							"Echec", JOptionPane.ERROR_MESSAGE);
				}		
			}
		});
		
		//Ajout d'ecouteur sur le bouton desactiverUser de la fentetre Administrateur
		viewAdministrateur.addBtnDesactiverBIListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					onClickDesactiver();
				} catch (Exception e) {
					viewConnexion.showMessage("Veuillez renseigner le(s) champ(s) obligatoire(s)", 
							"Echec", JOptionPane.ERROR_MESSAGE);
				}	
					
			}
		});
		
		
		//Ajout d'ecouteur sur le bouton actualiserUser de la fentetre Administrateur
		viewAdministrateur.addBtnActualiserBIListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onClickActualiserBI();				
			}
		});
		
		
		//Ajout d'ecouteur sur le bouton recherherUser de la fentetre Administrateur
		viewAdministrateur.addBtnRechercherBIListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					onClickRechercherBI();
				} catch (Exception e) {
					viewConnexion.showMessage("Veuillez renseigner le(s) champ(s) obligatoire(s)", 
							"Echec", JOptionPane.ERROR_MESSAGE);
				}	
								
			}
		});
		
		
		//Ajout d'ecouteur sur le bouton deconnexionUser de la fentetre Administrateur
		viewAdministrateur.addBtnDeconnexionBIListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onClickDeconnexion(viewAdministrateur, viewConnexion);				
			}
		});
		
		
		//Ajout d'ecouteur sur le bouton sauvegarderLocataire de la fentetre Gestionnaire
		viewGestionnaire.addSauvegarderLocListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					onClickSauvegarderLoc();	
				} catch (Exception e) {
					viewConnexion.showMessage("Veuillez renseigner le(s) champ(s) obligatoire(s)", 
							"Echec", JOptionPane.ERROR_MESSAGE);
				}	
						
			}
		});
		
		//Ajout d'ecouteur sur le bouton libererBien de la fentetre Gestionnaire
		viewGestionnaire.addLibererBienListerner(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					onClickLibererBienLoc();
				} catch (Exception e) {
					viewConnexion.showMessage("Veuillez renseigner le(s) champ(s) obligatoire(s)", 
							"Echec", JOptionPane.ERROR_MESSAGE);
				}	
				
			}
		});
		
		//Ajout d'ecouteur sur le bouton actualiserLocataire de la fentetre Gestionnaire
		viewGestionnaire.addActualiserLocListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onClickActualiserLoc();
				
			}
		});
		
		
		//Ajout d'ecouteur sur le bouton deconnexion de la fentetre Gestionnaire
		viewGestionnaire.addDeconnexionLocListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onClickDeconnexion(viewGestionnaire, viewConnexion);	
				
			}
		});
		
		//Ajout d'ecouteur sur le bouton actualiserBienDispo de la fentetre Gestionnaire
		viewGestionnaire.addActualiserBienDispoListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onClickActualiserBienDispo();				
			}
		});
		
		//Ajout d'ecouteur sur le bouton deconnexionBienDispo de la fentetre Gestionnaire

		viewGestionnaire.addDeconnexionBIDispoListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onClickDeconnexion(viewGestionnaire, viewConnexion);
			}
		});
		
		//Ajout d'ecouteur sur le bouton sauvegarderPayement de la fentetre Gestionnaire
		viewGestionnaire.addSauvegarderPayementListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					onClickSauvegarderPayement();
				} catch (Exception e) {
					viewConnexion.showMessage("Veuillez renseigner le(s) champ(s) obligatoire(s)", 
							"Echec", JOptionPane.ERROR_MESSAGE);
				}	
				
			}
		});
		
		//Ajout d'ecouteur sur le bouton supprimer de la fentetre Gestionnaire
		viewGestionnaire.addSupprimerPayementListerner(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					onClickSupprimerPayement();
				} catch (Exception e) {
					viewConnexion.showMessage("Veuillez renseigner le(s) champ(s) obligatoire(s)", 
							"Echec", JOptionPane.ERROR_MESSAGE);
				}	
				
			}
		});
		
		//Ajout d'ecouteur sur le bouton actualiserPayement de la fentetre Gestionnaire
		viewGestionnaire.addActualiserPayementListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onClickActualiserPayement();
			}
		});
		
		//Ajout d'ecouteur sur le bouton rechercherPayement de la fentetre Gestionnaire
		viewGestionnaire.addRechercherPayementListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					onClickRechercherPayement();
				} catch (Exception e) {
					viewConnexion.showMessage("Veuillez renseigner le(s) champ(s) obligatoire(s)", 
							"Echec", JOptionPane.ERROR_MESSAGE);
				}	
				
				
			}
		});
		
		//Ajout d'ecouteur sur le bouton deconnexionPayement de la fentetre Gestionnaire
		viewGestionnaire.addDeconnexionPayementListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onClickDeconnexion(viewGestionnaire, viewConnexion);
				
			}
		});
		
		//Ajout d'ecouteur sur le clic d'une ligne sur la tableUser de la fentetre Administrateur
		viewAdministrateur.addSelectLineTableUserListerner(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				viewAdministrateur.selectLineInTableUsers();
			}			
		});
		
		//Ajout d'ecouteur sur le clic d'une ligne sur la tableBien de la fentetre Administrateur
		viewAdministrateur.addSelectLineTableBienListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				viewAdministrateur.selectLineInTableBI();
			}			
		});
		
		//Ajout d'ecouteur sur le clic d'une ligne sur la tablePayement de la fentetre Gestionnaire
		viewGestionnaire.addSelectLineTablePayementListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				viewGestionnaire.selectLineInTablePayement();
			}
		});
		
		//Ajout d'ecouteur sur le clic d'une ligne sur la tableLocataire de la fentetre Gestionnaire
		viewGestionnaire.addSelectLineTableLocataireListener(new MouseAdapter() {
	
			@Override
			public void mouseClicked(MouseEvent arg0) {
				viewGestionnaire.selectLineInTableLocataire();
			}
			
		});
}
	
	
	//le controller lance la vue connexion qui sera visible
	public void run() {
		viewConnexion.run();
	}
	
	//Mehode a invoque lors de l'appui sur le bouton connexion
	private void onClickConnexion()  {
		
		User user = new User();
		user.setLogin(viewConnexion.getLoginTF());
		user.setPassword(viewConnexion.getPasswordTF());
		
		String typeCompte = stub.authentification(user);
		if (typeCompte.isEmpty()) {

			throw new RuntimeException();
		}
		if (typeCompte.equals("Administrateur")) {			
			viewAdministrateur.run();
			viewConnexion.exitView();
		} else {
			viewGestionnaire.run();
			viewConnexion.exitView();
		}
		
		viewConnexion.clearTF();
	}

	//Mehode a invoque lors de l'appui sur le bouton sauvegarderUser
	private void onClickSauvegarderUser() {
		User user = new User();
		user.setId(viewAdministrateur.getIdUserTF());
		user.setNom(viewAdministrateur.getNomUserTF());
		user.setPrenom(viewAdministrateur.getPrenomUserTF());
		user.setContact(viewAdministrateur.getContactUserTF());
		user.setEmail(viewAdministrateur.getEmailUserTF());
		user.setDateNaissance(viewAdministrateur.getDateNaissanceUserTF());
		user.setSexe(viewAdministrateur.getCombUserSexe());
		user.setAdresse(viewAdministrateur.getAdresseUserTF());
		user.setLogin(viewAdministrateur.getLoginUserTF());
		user.setPassword(viewAdministrateur.getPasswordUserTF());
		user.setTypeCompte(viewAdministrateur.checkAdminSelected());
		
		if(viewAdministrateur.checkUpdateUser()) {
			stub.modifierUser(user);
			viewConnexion.showMessage("Mise à jour effectuée avec succes", 
					"Succes", JOptionPane.INFORMATION_MESSAGE);
			}else {
			stub.ajouterUser(user);
			viewConnexion.showMessage("Ajout effectué avec succes", 
					"Succes", JOptionPane.INFORMATION_MESSAGE);
			}
		viewAdministrateur.clearTF();
	}

	//Mehode a invoque lors de l'appui sur le bouton supprimerUser
	private void onClickSuppUser() {
		
		int id = viewAdministrateur.getIdUserTF();
		if(viewAdministrateur.conifrmeSuppression()) {
			stub.supprimerUser(id);
			viewAdministrateur.clearTF();
		}
	}

	//Mehode a invoque lors de l'appui sur tous les boutons DECONNEXION
	private void onClickDeconnexion(JFrame vue, UIConnexion vueCnx) {
		
		vue.dispose();
		vueCnx.run();
	}

	//Mehode a invoque lors de l'appui sur le bouton desactiverBien
	private void onClickDesactiver() {
		
		int id = viewAdministrateur.getIdTFBI();
		if(viewAdministrateur.conifrmeSuppression()) {
			stub.desactiverBI(id);
			viewAdministrateur.clearTF();
		}
	}

	//Mehode a invoque lors de l'appui sur le bouton sauvegarderBien
	private void onClickSauvegarderBien() {
		BienImmobilier bien = new BienImmobilier();
		bien.setId(viewAdministrateur.getIdTFBI());
		bien.setAdresse(viewAdministrateur.getAdresseTFBI());
		bien.setNbrePiece(viewAdministrateur.getNbrePiecesBI());
		bien.setLoyer(viewAdministrateur.getLoyerBI());
		bien.setDetails(viewAdministrateur.getDetailsTFA());
		bien.setMeuble(viewAdministrateur.getComboMeuble());
		bien.setTypeBI(viewAdministrateur.getComboTypeBI());
		bien.setStatus(viewAdministrateur.getComboStatus());
		
		if(viewAdministrateur.checkUpdateBI()){
			stub.modifierBI(bien);
			viewConnexion.showMessage("Mise à jour effectuée avec succes", 
					"Succes", JOptionPane.INFORMATION_MESSAGE);
			
		}else {
			stub.ajouterBI(bien);
			viewConnexion.showMessage("Ajout effectué avec succes", 
					"Succes", JOptionPane.INFORMATION_MESSAGE);
		}
		
		viewAdministrateur.clearTF();
	}

	//Mehode a invoque lors de l'appui sur le bouton sauvegarderLocataire
	private void onClickSauvegarderLoc() {
		Locataire locataire = new Locataire();
		locataire.setId(viewGestionnaire.getIdLoc());
		locataire.setNom(viewGestionnaire.getNomLoc());
		locataire.setPrenom(viewGestionnaire.getPrenomLoc());
		locataire.setContact(viewGestionnaire.getContactLoc());
		locataire.setEmail(viewGestionnaire.getEmailLoc());
		locataire.setDateNaissance(viewGestionnaire.getDateNaissanceLoc());
		locataire.setSexe(viewGestionnaire.getSexeLoc());
		locataire.setNumCIN(viewGestionnaire.getNumCINLoc());
		locataire.setTypeLocation(viewGestionnaire.getTypeLoc());
		locataire.setIdBI(viewGestionnaire.getIdBienLoc());
		
		
		stub.affecterBI(locataire);
		viewConnexion.showMessage("Ajout effectué avec succes", 
				"Succes", JOptionPane.INFORMATION_MESSAGE);
		viewGestionnaire.clearTF();
	}

	//Mehode a invoque lors de l'appui sur le bouton libererBienLocataire
	private void onClickLibererBienLoc() {
		int idBI = viewGestionnaire.getIdBienLoc();
		int idLoc = viewGestionnaire.getIdLoc();
		if(viewAdministrateur.conifrmeSuppression()) {
			stub.libererBI(idBI, idLoc);
			viewGestionnaire.clearTF();
		}
	}

	//Mehode a invoque lors de l'appui sur le bouton sauvegarderPayement
	private void onClickSauvegarderPayement() {
		Payement payement = new Payement();
		payement.setId(viewGestionnaire.getIdPayement());
		payement.setDatePayement(viewGestionnaire.getDatePayement());
		payement.setMontant(viewGestionnaire.getMontantPayement());
		payement.setNomLocataire(viewGestionnaire.getNomLocPayement());
		payement.setPrenomLocataire(viewGestionnaire.getPrenomLocPayement());
		payement.setIdBI(viewGestionnaire.getIdBienPayement());
		
		if(viewGestionnaire.checkUpdatePayement()) {
			stub.modifierPayement(payement);
			viewConnexion.showMessage("Mise à jour effectuée avec succes", 
					"Succes", JOptionPane.INFORMATION_MESSAGE);

		}else {
			stub.ajouterPayement(payement);
			viewConnexion.showMessage("Ajout effectué avec succes", 
					"Succes", JOptionPane.INFORMATION_MESSAGE);
		}
		
		viewGestionnaire.clearTF();
	}
	
	//Mehode a invoque lors de l'appui sur le bouton rechercherPayement
	private void onClickRechercherPayement() {
		
		int id = viewGestionnaire.getRecherchePayement();
		viewGestionnaire.initTablePayement();
		viewGestionnaire.showInTablePayement(stub.rechercherPayement(id));
		viewGestionnaire.clearTF();
	}	

	//Mehode a invoque lors de l'appui sur le bouton actualiserPayement
	private void onClickActualiserPayement() {
		viewGestionnaire.clearTF();
		viewGestionnaire.initTablePayement();
		for (Payement payement : stub.listePayements()) {
			viewGestionnaire.showInTablePayement(payement);
		}
	}

	//Mehode a invoque lors de l'appui sur le bouton supprimerPayement
	private void onClickSupprimerPayement() {
		int id = viewGestionnaire.getIdPayement();
		if(viewAdministrateur.conifrmeSuppression()) {
			stub.supprimerPayement(id);
			viewGestionnaire.clearTF();
		}
	}
	
	//Mehode a invoque lors de l'appui sur le bouton actualiserPayement
	private void onClickActualiserLoc() {
		viewGestionnaire.clearTF();
		viewGestionnaire.initTableLocataire();
		for (Locataire locataire : stub.listeLocataires()) {
			viewGestionnaire.showInTableLocataire(locataire);
		}
	}

	//Mehode a invoque lors de l'appui sur le bouton actualiserBienDispo
	private void onClickActualiserBienDispo() {
		viewGestionnaire.clearTF();
		viewGestionnaire.initTableBien();
		for (BienImmobilier bien : stub.listeBIDisponible()) {
			viewGestionnaire.showInTableBienDispo(bien);
		}
	}

	//Mehode a invoque lors de l'appui sur le bouton actualiserBI
	private void onClickActualiserBI() {
		viewAdministrateur.clearTF();
		viewAdministrateur.initTableBI();
		for (BienImmobilier bien : stub.listeBI()) {
			viewAdministrateur.showInTableBienDispo(bien);
		}
	}

	//Mehode a invoque lors de l'appui sur le bouton recherherBI
	private void onClickRechercherBI() {
		viewAdministrateur.initTableBI();
		int id = viewAdministrateur.getRechercheTFBI();
		BienImmobilier bien = stub.rechercherBI(id);
		viewAdministrateur.showInTableBienDispo(bien);
		viewAdministrateur.clearTF();
	}

	//Mehode a invoque lors de l'appui sur le bouton actualiserUser
	private void onClickActualiserUser() {
		viewAdministrateur.clearTF();
		viewAdministrateur.initTableUsers();
		for (User user : stub.listeUsers()) {
			viewAdministrateur.showInTableUser(user);
		}
	}

	//Mehode a invoque lors de l'appui sur le bouton rechercherUser
	private void onClickRechercherUser() {
		viewAdministrateur.initTableUsers();
		int id = viewAdministrateur.getRechercheTFUser();
		User user = stub.rechercherUser(id);
		viewAdministrateur.showInTableUser(user);
		viewAdministrateur.clearTF();
	}
}