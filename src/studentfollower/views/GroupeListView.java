package studentfollower.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;

import studentfollower.controller.GroupeListController;
import studentfollower.modele.Groupe;
import studentfollower.modele.Professeur;

public class GroupeListView extends ListView {

	
	private Professeur prof;
	private HashMap<JButton, Groupe> mapGroupes;
	private GroupeListController groupeListController;
	
	public GroupeListView(Professeur prof, GroupeListController groupeListController) {
		this.prof = prof;
		
		this.groupeListController = groupeListController;
	}
	
	public void loadUI(List<Groupe> listGroupes){
		removeAll();
		invalidate();
		revalidate();
		
		mapGroupes = new HashMap<JButton, Groupe>();
		BoutonListener l = new BoutonListener();
		for(Groupe g : listGroupes){
			JButton b = new JButton("Groupe : " + g.getNom());
			b.addActionListener(l);
			mapGroupes.put(b, g);
			add(b);
		}
		repaint();
	}
	
	public class BoutonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			groupeListController.changeMiddleView(mapGroupes.get(e.getSource()));
		}
		
	}

}
