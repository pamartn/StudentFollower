package studentfollower.controller;

import studentfollower.modele.Cours;
import studentfollower.modele.Professeur;
import studentfollower.modele.dao.DAOFactory;
import studentfollower.views.EtudiantListView;
import studentfollower.views.MiddleView;

public class MiddleViewController {

	
	private MiddleView middleView;
	private EtudiantListController etudiantListController;
	private GroupeListController groupeListController;
	private CoursListController coursListController;
	
	public MiddleViewController(Professeur prof){
		middleView = new MiddleView();
		Cours cours = DAOFactory.getCoursDAO().findCurrentCours(prof);
		etudiantListController = new EtudiantListController(cours);
		groupeListController = new GroupeListController(DAOFactory.getProfesseurDAO().find(1));
		coursListController = new CoursListController(DAOFactory.getProfesseurDAO().find(1));
		
		middleView.addUI(groupeListController.getView(), "groupe");
		middleView.addUI(etudiantListController.getView(), "liste");
		middleView.addUI(coursListController.getView(), "cours");
		
		
		actionAcceuil();
	}
	
	public void actionAcceuil(){
		middleView.loadUI("liste");
	}
	
	public void actionCours(){
		middleView.loadUI("cours");
	}
	
	public void actionGroupe(){
		middleView.loadUI("groupe");
	}
	
	public MiddleView getView() {
		return middleView;
	}

}
