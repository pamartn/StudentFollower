package studentfollower.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import studentfollower.controller.FenetreController;

public class FooterBarView extends JPanel {

	private JButton groupes,cours;
	
	public FooterBarView(ActionListener customActionListener) {
		super();
		setLayout(new GridLayout(1,2));
		
		groupes = new JButton("Groupes");
		cours = new JButton("Cours");
		groupes.setFont(groupes.getFont().deriveFont((float)FenetreController.scale*20f));
		cours.setFont(cours.getFont().deriveFont((float)FenetreController.scale*20f));
		groupes.addActionListener(customActionListener);
		cours.addActionListener(customActionListener);
		add(groupes);
		add(cours);
		groupes.setBackground(Fenetre.blueColor);
		groupes.setForeground(Color.white);

		cours.setBackground(Fenetre.blueColor);
		cours.setForeground(Color.white);
	}

	public JButton getBoutonGroupe() {
		return groupes;
	}

	public JButton getBoutonCours() {
		return cours;
	}

}
