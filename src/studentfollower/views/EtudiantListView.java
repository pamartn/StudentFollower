package studentfollower.views;

import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import studentfollower.modele.Etudiant;
import studentfollower.views.components.BoutonEtudiant;

public class EtudiantListView extends ListView {

	private String matiere;
	private char groupe;
	HashMap<BoutonEtudiant, Etudiant> listBoutons;
	JScrollPane scroll;

	public EtudiantListView() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
	}
	
	public void loadUI(List<Etudiant> etudiants, boolean appel){
		removeAll();
		invalidate();
		revalidate();
		if(etudiants != null && etudiants.size() > 0){
			listBoutons = new HashMap<BoutonEtudiant,Etudiant>();
			for(Etudiant e : etudiants){
				BoutonEtudiant b = new BoutonEtudiant(e.getNom() + " " + e.getPrenom(), appel);
				listBoutons.put(b,e);
				add(b);
			}
		} else {
			add(new JLabel("Vous n'avez pas cours"));
		}
		repaint();
	}
}
