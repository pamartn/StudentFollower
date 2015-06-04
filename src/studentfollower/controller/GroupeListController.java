package studentfollower.controller;

import studentfollower.modele.Professeur;
import studentfollower.views.GroupeListView;
import studentfollower.views.ListView;

public class GroupeListController {

	private GroupeListView groupeListView;
	
	public GroupeListController(Professeur prof){
		groupeListView = new GroupeListView(prof);
	}
	
	
	public GroupeListView getView() {
		return groupeListView;
	}


}
