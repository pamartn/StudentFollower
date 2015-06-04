package studentfollower.controller;

import studentfollower.modele.Cours;
import studentfollower.modele.dao.DAOFactory;
import studentfollower.views.EtudiantListView;
import studentfollower.views.MiddleView;

public class MiddleViewController {

	
	private MiddleView middleView;
	private EtudiantListController etudiantListController;
	
	
	public MiddleViewController(){
		middleView = new MiddleView();

		Cours cours = DAOFactory.getCoursDAO().find(1);
		etudiantListController = new EtudiantListController(cours);
		actionAcceuil();
	}
	
	public void actionAcceuil(){
		middleView.loadUI(etudiantListController.getView());
	}
	
	public void actionHoraire(){
		
	}
	
	public void actionGroupe(){
		
	}
	
	public MiddleView getView() {
		return middleView;
	}

}
