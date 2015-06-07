package studentfollower.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.sun.org.apache.xpath.internal.operations.VariableSafeAbsRef;

import studentfollower.modele.Cours;
import studentfollower.modele.Professeur;
import studentfollower.modele.dao.DAOFactory;
import studentfollower.views.MiddleView;
import studentfollower.views.NavigationBarView;

public class NavBarController {

	
	private NavigationBarView navBar;
	private FenetreController fenetreController;
	private Professeur prof;
	private CustomActionListener l;
	private KeyListener keyL;
	
	public NavBarController(FenetreController f, Cours cours, Professeur prof) {
		this.fenetreController = f;
		this.prof = prof;
		navBar = new NavigationBarView();
		l = new CustomActionListener();
		keyL =new SearchListener();
		navBar.loadUI(cours,prof, l,keyL);
	}
	
	public NavigationBarView getView(){
		return navBar;
	}
	public class SearchListener implements KeyListener {

		public void keyTyped(KeyEvent e) {
		}
		public void keyPressed(KeyEvent e) {	
		}
		public void keyReleased(KeyEvent e) {
			fenetreController.getMiddleView().sendSearch(navBar.getSearchText());
		}
		
	}
	
	public class CustomActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			fenetreController.getMiddleView().refreshListEtudiant(DAOFactory.getCoursDAO().findCurrentCours(prof));
			fenetreController.getMiddleView().actionAcceuil();
		}
		
	}

	public void refreshView(Cours cours) {
		navBar.loadUI(cours, prof, l, keyL);
	}

}
