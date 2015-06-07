package studentfollower.controller;

import java.util.ArrayList;
import java.util.List;

import studentfollower.modele.Cours;
import studentfollower.modele.Etudiant;
import studentfollower.modele.Professeur;
import studentfollower.modele.dao.DAOFactory;
import studentfollower.views.EtudiantListView;

public class EtudiantListController {
	
	
	private EtudiantListView etudiantListView;
	private Professeur prof;
	private List<Etudiant> listEtudiant;
	private boolean appel;
	
	public EtudiantListController(Cours cours, Professeur prof){
		etudiantListView = new EtudiantListView();
		this.prof = prof;
		refreshView(cours, true);
		
	}
	
	public void refreshView(Cours cours, boolean appel){
		try{
			listEtudiant = DAOFactory.getEtudiantDAO().findAllByGroupe(cours.getGroupe());
			Cours currentCours = DAOFactory.getCoursDAO().findCurrentCours(prof);
			appel = currentCours != null && cours.getNum_cours() == currentCours.getNum_cours();
		} catch(Exception e){
			listEtudiant = (DAOFactory.getEtudiantDAO().findAllByGroupe(null));
		}
		this.appel = appel;
		etudiantListView.loadUI(listEtudiant, appel);
	}
	
	public EtudiantListView getView(){
		return etudiantListView;
	}

	public void showSearch(String searchText) {
		List<Etudiant> searchResult = new ArrayList<Etudiant>();
	
		searchText = searchText.toLowerCase();
		for(Etudiant e : listEtudiant){
			if(searchText.length() == 0 || e.getPrenom().toLowerCase().startsWith(searchText) || e.getNom().toLowerCase().startsWith(searchText)){
				searchResult.add(e);
			}
		}
		etudiantListView.loadUI(searchResult, appel);
	}
	
}
