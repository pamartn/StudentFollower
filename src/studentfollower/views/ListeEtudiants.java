package studentfollower.views;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class ListeEtudiants extends JPanel {

	
	private String matiere;
	private char groupe;
	private Horaire horaire;
	ArrayList<BoutonEtudiant> listBoutons;
	String[] nomsEtu;
	JScrollPane scroll;
	
	public ListeEtudiants(String[] nomsEtu) {
		super();

		
		this.nomsEtu = nomsEtu;
		listBoutons = new ArrayList<BoutonEtudiant>();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		for(int i = 0; i < nomsEtu.length; i++){
			BoutonEtudiant b = new BoutonEtudiant(nomsEtu[i], true);
			listBoutons.add(b);
			add(b);
		}
	}
	
	public String toString(){
		return matiere + " - Groupe " + groupe;
	}

}
