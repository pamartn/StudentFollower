import javax.swing.JButton;
import javax.swing.JPanel;


public class BoutonEtudiant extends JPanel {

	public BoutonEtudiant(String etudiant) {
		super();
		add(new JButton(etudiant));
		
	}

}
