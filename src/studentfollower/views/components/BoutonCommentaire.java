package studentfollower.views.components;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import studentfollower.controller.FenetreController;
import studentfollower.views.Fenetre;



public class BoutonCommentaire extends JPanel {
	
	JButton enregistrer;
	JLabel retardLabel;
	JTextArea commentaire;
	Boolean effacer = true;
	
	public BoutonCommentaire(){
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		retardLabel = new JLabel();
		retardLabel.setVisible(false);
		add(retardLabel);
		commentaire = new JTextArea("Entrez un commentaire");
		commentaire.setRows(2);
		commentaire.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {	
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseClicked(MouseEvent e) { 
				if(effacer)
				commentaire.setText("");
				effacer = false;
			}
		});
		commentaire.setFont(commentaire.getFont().deriveFont(10f*(float)FenetreController.scale));
		commentaire.setBackground(Color.white);
		commentaire.setForeground(Fenetre.blueColor);
		add(commentaire, BorderLayout.NORTH);
		
		enregistrer = new JButton("Enregistrer");
		enregistrer.setFont(enregistrer.getFont().deriveFont(12f*(float)FenetreController.scale));
		enregistrer.setBackground(Fenetre.blueColor);
		enregistrer.setForeground(Color.white);
		enregistrer.addActionListener(new CustomListener());
		add(enregistrer, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public class CustomListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == enregistrer){
				setVisible(false);
			}
			
		}

		
		
	}

	public void setRetard(int retard) {
		if(retard > 0){
			retardLabel.setText("En retard de " + retard + " minutes !");
			retardLabel.setVisible(true);
		} else {
			retardLabel.setVisible(false);
		}
	}
}
