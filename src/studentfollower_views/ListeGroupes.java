package studentfollower_views;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class ListeGroupes extends JPanel {
	
	String[] groupes;
	ArrayList<BoutonGroupe> listBoutons;
	
	public ListeGroupes(String[] groupes){
		super();
		this.groupes = groupes;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		listBoutons = new ArrayList<BoutonGroupe>();
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		for(int i = 0; i < groupes.length; i++){
			BoutonGroupe b = new BoutonGroupe(groupes[i]);
			listBoutons.add(b);
			add(b);
		}
		
		setVisible(true);
	}
}
