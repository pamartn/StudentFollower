package studentfollower.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import studentfollower.controller.FenetreController;
import studentfollower.controller.GroupeListController;
import studentfollower.modele.Groupe;
import studentfollower.modele.Professeur;

public class GroupeListView extends ListView {

	
	private Professeur prof;
	private HashMap<JButton, Groupe> mapGroupes;
	private GroupeListController groupeListController;
	
	public GroupeListView(Professeur prof, GroupeListController groupeListController) {
		this.prof = prof;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.groupeListController = groupeListController;
	}
	
	public void loadUI(List<Groupe> listGroupes){
		removeAll();
		invalidate();
		revalidate();
		mapGroupes = new HashMap<JButton, Groupe>();
		BoutonListener l = new BoutonListener();
		for(Groupe g : listGroupes){
			JPanel p = new JPanel();
			p.setLayout(new BorderLayout());
			JButton b = new JButton("Groupe : " + g.getNom());
			b.setForeground(Color.white);
			b.setBackground(Fenetre.blueColor);
			b.addActionListener(l);
			mapGroupes.put(b, g);
			b.setFont(b.getFont().deriveFont((float)FenetreController.scale*20f));
			p.add(b,BorderLayout.CENTER);
			add(p);
		}
		repaint();
	}
	
	public class BoutonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			groupeListController.changeMiddleView(mapGroupes.get(e.getSource()));
		}
		
	}

}
