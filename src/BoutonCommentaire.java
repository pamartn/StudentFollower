import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class BoutonCommentaire extends JPanel {
	
	JButton enregistrer;
	
	public BoutonCommentaire(){
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
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
}
