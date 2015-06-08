package studentfollower.controller;

import java.util.ArrayList;

import studentfollower.modele.Cours;
import studentfollower.modele.Groupe;
import studentfollower.modele.Professeur;
import studentfollower.modele.dao.DAOFactory;
import studentfollower.views.CoursListView;

public class CoursListController {
	
	private CoursListView coursListView;
	private Professeur prof;
	private MiddleViewController middleViewController;
	private Groupe currentGroupe;
	private ArrayList<Cours> listCours;
	
	public CoursListController(Professeur prof, MiddleViewController middleViewController){
		this.prof = prof;
		this.middleViewController = middleViewController;
		coursListView = new CoursListView(this);
		refreshView(null);
	}
	
	public void changeMiddleView(Cours cours){
		middleViewController.refreshListEtudiant(cours);
	}
	
	public void refreshView(Groupe groupe){
		currentGroupe = groupe;
		if(groupe != null){
			listCours = DAOFactory.getCoursDAO().findByGroupeAndProf(groupe,prof);
		} else {
			listCours = DAOFactory.getCoursDAO().findByProf(prof);
		}
		coursListView.loadUI(listCours);
	}
	
	
	public CoursListView getView(){
		return coursListView;
	}

	public void showSearch(String searchText) {
		ArrayList<Cours> searchResult=new ArrayList<Cours>();
		searchText = new String(searchText).toLowerCase();
		
		for(Cours c : listCours){
			String text = c.getMatiere()+c.getSalle()+c.getHoraire().getHeureDebut()+c.getHoraire().getHeureFin();
			text = text.toLowerCase();
			if(searchText.length() == 0 || text.contains(searchText)){
				searchResult.add(c);
			}
		}
		
		coursListView.loadUI(searchResult);
	}
}
