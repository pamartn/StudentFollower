package studentfollower.controller;

import studentfollower.modele.Professeur;
import studentfollower.views.CoursListView;

public class CoursListController {
	
	private CoursListView coursListView;
	
	public CoursListController(Professeur prof){
		coursListView = new CoursListView(prof);
	}
	
	public CoursListView getView(){
		return coursListView;
	}
}
