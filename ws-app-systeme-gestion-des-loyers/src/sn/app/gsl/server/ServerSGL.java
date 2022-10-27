package sn.app.gsl.server;

import javax.xml.ws.Endpoint;

import com.grak.javaws.serveur.IServeurServiceWeb;

import sn.app.gsl.ws.WSAppGSL;


public class ServerSGL implements IServeurServiceWeb {
	
	private Endpoint endpoint=null;
	public static final String WS_URL = "http://localhost/8181";
	

	//Verification de la publication du web service
	@Override
	public boolean isPublished() {
		
		try {
			return endpoint.isPublished();
		} catch (NullPointerException e) {
			
		}
		return false;
	}

	/*
	 * Publication du web service
	 * cree une instance su web service puis 
	 * publie le web service en l'aide de son URL
	 */
	@Override
	public void publish() {
		try {
			
		endpoint = Endpoint.create(new WSAppGSL());
		endpoint.publish(WS_URL);
		} catch (NullPointerException e) {
			
		}
	}

	//Arret de la publication du web service 
	@Override
	public void stopPublishing() {
		try {
		endpoint.stop();
		} catch (NullPointerException e) {
			
		}
	}

}
