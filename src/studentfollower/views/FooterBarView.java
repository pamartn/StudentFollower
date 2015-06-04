package studentfollower.views;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class FooterBarView extends JPanel {

	private JButton groupes,cours;
	
	public FooterBarView(ActionListener customActionListener) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		groupes = new JButton("Groupes");
		cours = new JButton("Cours");
		groupes.addActionListener(customActionListener);
		cours.addActionListener(customActionListener);
		add(groupes);
		add(cours);
	}

	public JButton getBoutonGroupe() {
		return groupes;
	}

	public JButton getBoutonHoraire() {
		return cours;
	}

}
