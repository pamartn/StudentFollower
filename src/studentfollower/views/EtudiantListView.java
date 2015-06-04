package studentfollower.views;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

import studentfollower.modele.Cours;
import studentfollower.modele.Etudiant;
import studentfollower.modele.Groupe;
import studentfollower.modele.dao.DAOFactory;

public class EtudiantListView extends ListView {

	private String matiere;
	private char groupe;
	ArrayList<BoutonEtudiant> listBoutons;
	String[] nomsEtu;
	JScrollPane scroll;

	public EtudiantListView(Cours cours) {
		super();
		
		listBoutons = new ArrayList<BoutonEtudiant>();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		System.out.println(cours.getGroupe());
		for(Etudiant e : DAOFactory.getEtudiantDAO().findAllByGroupe(cours.getGroupe())){
			BoutonEtudiant b = new BoutonEtudiant(e.getNom() + " " + e.getPrenom(), true);
			listBoutons.add(b);
			add(b);
		}
	}
}
