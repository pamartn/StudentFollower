package studentfollower.controller;

import javax.swing.text.html.ListView;

import studentfollower.modele.Cours;
import studentfollower.views.EtudiantListView;

public class EtudiantListController {
	
	
	private EtudiantListView etudiantListView;
	
	public EtudiantListController(Cours cours){
		etudiantListView = new EtudiantListView(cours);
		
	}
	
	public EtudiantListView getView(){
		return etudiantListView;
	}
	
}
