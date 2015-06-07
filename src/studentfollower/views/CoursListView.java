package studentfollower.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import studentfollower.controller.CoursListController;
import studentfollower.modele.Cours;
import studentfollower.views.components.CoursBouton;

public class CoursListView extends ListView {

	
	private HashMap<CoursBouton, Cours> mapCours;
	private CoursListController coursListController;
	
	public CoursListView(CoursListController coursListController) {
		super();
		this.coursListController = coursListController;
	}

	public void loadUI(List<Cours> listCours) {
		removeAll();
		invalidate();
		revalidate();
		setLayout(new BorderLayout());
		JPanel p = new JPanel();
		BoutonListener l = new BoutonListener();
		
		p.setLayout(new GridLayout(10,1));
		mapCours = new HashMap<CoursBouton, Cours>();
		for(Cours c : listCours){
			CoursBouton b = new CoursBouton(c.getMatiere() + " "+ c.getSalle() +" "+ c.getHoraire().getHeureDebut() +" "+ c.getHoraire().getHeureFin());
			b.addActionListener(l);
			mapCours.put(b, c);
			p.add(b);
		}

		JScrollPane pane = new JScrollPane(p);
		add(pane,BorderLayout.CENTER);
		repaint();
	}
	
	public class BoutonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			coursListController.changeMiddleView(mapCours.get(e.getSource()));
		}
		
	}
	
	
}
