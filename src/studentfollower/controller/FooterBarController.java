package studentfollower.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import studentfollower.modele.Professeur;
import studentfollower.views.FooterBarView;

public class FooterBarController {
	
	
	FooterBarView footerBarView;
	FenetreController fenetreController;
	
	public FooterBarController(FenetreController f){
		footerBarView = new FooterBarView(new CustomActionListener());
		fenetreController = f;
	}
	
	public FooterBarView getView(){
		return footerBarView;
	}
	
	public class CustomActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == footerBarView.getBoutonGroupe()){
				fenetreController.getMiddleView().actionGroupe();
			} else if (e.getSource() ==  footerBarView.getBoutonCours()){
				fenetreController.getMiddleView().refreshListCours(null);
				fenetreController.getMiddleView().actionCours();
			} 
		}
		
	}
}
