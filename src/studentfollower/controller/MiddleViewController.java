package studentfollower.controller;

import studentfollower.modele.Cours;
import studentfollower.modele.Groupe;
import studentfollower.modele.Professeur;
import studentfollower.modele.dao.DAOFactory;
import studentfollower.views.EtudiantListView;
import studentfollower.views.MiddleView;

public class MiddleViewController {

	
	private MiddleView middleView;
	private EtudiantListController etudiantListController;
	private GroupeListController groupeListController;
	private CoursListController coursListController;
	private FenetreController fenetreController;
	private String currentView;
	
	public MiddleViewController(Cours cours, Professeur prof, FenetreController fenetreController){
		middleView = new MiddleView();
		this.fenetreController = fenetreController;
		etudiantListController = new EtudiantListController(cours, prof);
		groupeListController = new GroupeListController(prof, this);
		coursListController = new CoursListController(prof, this);
		
		middleView.addUI(groupeListController.getView(), "groupe");
		middleView.addUI(etudiantListController.getView(), "liste");
		
		middleView.addUI(coursListController.getView(), "cours");
		
		
		actionAcceuil();
	}
	
	public void refreshListCours(Groupe groupe){
		coursListController.refreshView(groupe);

		fenetreController.getNavBar().refreshView(null);
		actionCours();
	}
	
	public void refreshListEtudiant(Cours cours){
		etudiantListController.refreshView(cours, false);
		fenetreController.getNavBar().refreshView(cours);
		actionAcceuil();
	}
	
	public void sendSearch(String searchText) {
		if(currentView.equals("liste")){
			etudiantListController.showSearch(searchText);
		} else if(currentView.equals("groupe")){
			groupeListController.showSearch(searchText);
		} else {
			coursListController.showSearch(searchText);
		}
	}
	
	public void actionAcceuil(){
		currentView = "liste";
		middleView.loadUI(currentView);
	}
	
	public void actionCours(){
		currentView = "cours";
		middleView.loadUI(currentView);
	}
	
	public void actionGroupe(){
		currentView = "groupe";
		middleView.loadUI(currentView);
	}
	
	public MiddleView getView() {
		return middleView;
	}

}
