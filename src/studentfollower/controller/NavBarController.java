package studentfollower.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import studentfollower.modele.Professeur;
import studentfollower.modele.dao.DAOFactory;
import studentfollower.views.NavigationBarView;

public class NavBarController {

	
	private NavigationBarView navBar;
	private FenetreController fenetreController;
	
	
	
	public NavBarController(FenetreController f, Professeur prof) {
		this.fenetreController = f;
		navBar = new NavigationBarView(prof, new CustomActionListener());
	}
	
	public NavigationBarView getView(){
		return navBar;
	}
	
	public class CustomActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			fenetreController.getMiddleView().actionAcceuil();
		}
		
	}

}
