package studentfollower.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import studentfollower.controller.CoursListController;
import studentfollower.controller.FenetreController;
import studentfollower.modele.Cours;
import studentfollower.views.components.CoursBouton;

public class CoursListView extends ListView {

	
	private HashMap<CoursBouton, Cours> mapCours;
	private HashMap<Calendar, ArrayList<Cours>> mapDate;
	private CoursListController coursListController;
	
	public CoursListView(CoursListController coursListController) {
		super();
		this.coursListController = coursListController;

		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	}

	public void loadUI(List<Cours> listCours) {
		removeAll();
		invalidate();
		revalidate();
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		mapDate = new HashMap<Calendar, ArrayList<Cours>>();
		BoutonListener l = new BoutonListener();
		
		mapCours = new HashMap<CoursBouton, Cours>();
		for(Cours c : listCours){
			Calendar date = new GregorianCalendar();
			date.set(c.getHoraire().getCalendar_debut().get(Calendar.YEAR),
					c.getHoraire().getCalendar_debut().get(Calendar.MONTH),
					c.getHoraire().getCalendar_debut().get(Calendar.DAY_OF_MONTH),
					0,0,0);
			Calendar emplacement = null;
			boolean contient = false;
			for(Calendar d : mapDate.keySet()){
				if(d.get(Calendar.DAY_OF_YEAR) == date.get(Calendar.DAY_OF_YEAR)){
					emplacement = d;
					contient = true;
				}
			}
			if(contient){
				mapDate.get(emplacement).add(c);
			} else {
				ArrayList<Cours> list = new ArrayList<Cours>();
				list.add(c);
				mapDate.put(date, list);
			}
		}
		
		
		
		for(ArrayList<Cours> list : mapDate.values()){
			boolean fini = false;
			while(!fini){
				fini = true;
				for(int i = 0; i < list.size()-1; i++){
					if(list.get(i).getHoraire().inferiorTo(list.get(i+1).getHoraire())){
						fini = false;
						Cours c = list.get(i);
						list.set(i, list.get(i+1));
						list.set(i+1, c);
					}
				}
			}
		}

		for(Calendar d : mapDate.keySet()){
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(mapDate.get(d).size(),1));
			p.setBorder(BorderFactory.createTitledBorder(d.get(Calendar.DATE) + "/" + d.get(Calendar.MONTH) + "/" + d.get(Calendar.YEAR)));
			((TitledBorder)p.getBorder()).setTitleFont(p.getFont().deriveFont((float)FenetreController.scale*15f));
			((TitledBorder)p.getBorder()).setTitleColor(Fenetre.blueColor);
			for(Cours c : mapDate.get(d)){
				CoursBouton b = new CoursBouton(c.getMatiere() + " "+ c.getSalle() +" "+ c.getHoraire().getHeureDebut() +" "+ c.getHoraire().getHeureFin());
				b.addActionListener(l);
				b.setBackground(Fenetre.blueColor);
				b.setForeground(Color.white);
				b.setFont(b.getFont().deriveFont((float)FenetreController.scale*10f));
				mapCours.put(b, c);
				p.add(b);
			}
			contentPane.add(p);
		}

		JScrollPane pane = new JScrollPane(contentPane);
		add(pane);
		
		repaint();
	}
	
	public class BoutonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			coursListController.changeMiddleView(mapCours.get(e.getSource()));
		}
		
	}
	
	
}
