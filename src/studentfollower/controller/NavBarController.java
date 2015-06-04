package studentfollower.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import studentfollower.modele.Professeur;
import studentfollower.modele.dao.DAOFactory;
import studentfollower.views.NavigationBarView;

public class NavBarController {

	
	private NavigationBarView navBar;
	private FenetreController fenetreController;
	
	
	
	public NavBarController(FenetreController f, int idProf) {
		this.fenetreController = f;
		Professeur professeur = DAOFactory.getProfesseurDAO().find(idProf);
		navBar = new NavigationBarView(professeur, new CustomActionListener());
	}
	
	public NavigationBarView getView(){
		return navBar;
	}
	
	public class CustomActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			fenetreController.actionCours();
		}
		
	}

}
