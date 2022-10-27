package sn.app.sgl.presentation;

import sn.app.sgl.ui.ControllerView;
import sn.app.sgl.ui.UIAdministrateur;
import sn.app.sgl.ui.UIConnexion;
import sn.app.sgl.ui.UIGestionnaire;

public class Application {

	//la methode principale dans le Client de l'app Systeme de Gestion de Loyer
	public static void main(String[] args) {
		
		//Declaration et initialisation des 3 vues de l'application
		UIConnexion viewConnexion = new UIConnexion();
		UIAdministrateur viewAdministrateur = new UIAdministrateur();
		UIGestionnaire viewGestionnaire = new UIGestionnaire();
		
		//Declaration et initialisation du Conctroller de l'application
		ControllerView controllerView = new ControllerView(viewConnexion, viewAdministrateur, viewGestionnaire);
		
		//Execution du Controller
		controllerView.run();

	}

}
