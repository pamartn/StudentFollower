package studentfollower.views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import studentfollower.controller.FenetreController;
import studentfollower.modele.Professeur;


public class NavigationBarView extends JPanel {

	
	private JButton home;
	private JLabel nom;
	
	public NavigationBarView(Professeur prof,ActionListener l) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		ImageIcon img = new ImageIcon("res/homeicon.png");
		home = new JButton(new ImageIcon(img.getImage().getScaledInstance( 40, 40, java.awt.Image.SCALE_SMOOTH )));
		home.addActionListener(l);
		p.add(home, BorderLayout.WEST);
		nom = new JLabel(prof.getPrenom() +" "+ prof.getNom(), SwingConstants.CENTER);
		nom.setFont(nom.getFont().deriveFont(20f * (float)FenetreController.scale));
		p.add(nom, BorderLayout.CENTER);
		
		add(p);
		
		JTextField textField = new JTextField();
		textField.setBorder(BorderFactory.createLineBorder(Color.RED, 10));
		textField.setFont(new CustomFont());
		textField.setText("search");
		add(textField);
		

		add(new JLabel("IHM - Groupe J - 13H30 - 15H30"));
		
		
		setVisible(true);
	}

	public void refreshUI(){
		
	}
	
	

}
