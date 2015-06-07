package studentfollower.controller;

import java.util.ArrayList;
import java.util.List;

import studentfollower.modele.Groupe;
import studentfollower.modele.Professeur;
import studentfollower.modele.dao.DAOFactory;
import studentfollower.views.GroupeListView;

public class GroupeListController {

	private GroupeListView groupeListView;
	private MiddleViewController middleViewController;
	private List<Groupe> listGroupe;
	
	
	public GroupeListController(Professeur prof,MiddleViewController middleViewController){
		groupeListView = new GroupeListView(prof, this);
		listGroupe = DAOFactory.getGroupeDAO().findByProf(prof);
		groupeListView.loadUI(listGroupe);
		this.middleViewController = middleViewController;
	}
	
	public void changeMiddleView(Groupe groupe){
		middleViewController.refreshListCours(groupe);
	}
	
	public GroupeListView getView() {
		return groupeListView;
	}

	public void showSearch(String searchText) {
		System.out.println(searchText);
		List<Groupe> searchResult = new ArrayList<Groupe>();
		searchText = searchText.toLowerCase();
		for(Groupe g : listGroupe){
			if(searchText.length() == 0 || g.getNom().toLowerCase().contains(searchText)){
				searchResult.add(g);
			}
		}
		
		
		groupeListView.loadUI(searchResult);
		
	}

}
