package studentfollower.controller;

import java.awt.Toolkit;

import javax.swing.JPanel;

import studentfollower.modele.dao.DAOFactory;
import studentfollower.views.Fenetre;

public class FenetreController {

	private Fenetre fenetre;
	private NavBarController navBarController;
	private MiddleViewController midViewControl;
	private FooterBarController footerBarControl;
	
	public static double scale = 1;
	
	public FenetreController() {
		fenetre = new Fenetre((int)(scale*320.0), (int)(scale*480.0));
		navBarController = new NavBarController(this,1);
		midViewControl = new MiddleViewController();
		footerBarControl = new FooterBarController(this);
		
		fenetre.loadUI(navBarController.getView(),midViewControl.getView(), footerBarControl.getView());
	}
	
	
	
	public void actionCours(){
		
	}
	
	public void actionGroupe(){
		
	}
	
	public static void main(String args[]){
		//DAOFactory.initDB();
		scale = (double)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/1280.0;
		new FenetreController();
	}



	public MiddleViewController getMiddleView() {
		return midViewControl;
	}

}
