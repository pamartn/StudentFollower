package studentfollower_views;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class BoutonCommentaire extends JPanel {
	
	JButton enregistrer;
	JLabel retardLabel;
	
	
	public BoutonCommentaire(){
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		retardLabel = new JLabel();
		retardLabel.setVisible(false);
		add(retardLabel);
		add(new JTextArea("Entrez un commentaire"));
		enregistrer = new JButton("Enregistrer");
		enregistrer.addActionListener(new CustomListener());
		add(enregistrer);
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
