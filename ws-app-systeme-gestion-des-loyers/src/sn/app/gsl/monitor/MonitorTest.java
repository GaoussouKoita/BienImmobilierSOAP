package sn.app.gsl.monitor;

import com.grak.javaws.monitor.Monitor;

import sn.app.gsl.server.ServerSGL;

public class MonitorTest {

	//Methode Principale dans le projet web services de l'application SGL
	public static void main(String[] args) {
		
		//Declaration et initialisation d'un monitor servant a piloter le serveur
		Monitor monitor = new Monitor(new ServerSGL(), "Serveur Systeme de Gestion de Loyer");
		
		//Execution du monitor
		monitor.run();

	}

}
