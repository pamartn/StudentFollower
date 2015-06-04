package studentfollower.controller;

import java.awt.Toolkit;

import javax.swing.JPanel;

import studentfollower.modele.Professeur;
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
		Professeur prof = DAOFactory.getProfesseurDAO().find(1);
		navBarController = new NavBarController(this,prof);
		midViewControl = new MiddleViewController(prof);
		footerBarControl = new FooterBarController(this, prof);
		
		
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
