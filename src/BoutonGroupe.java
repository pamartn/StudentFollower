import javax.swing.JButton;
import javax.swing.JPanel;


public class BoutonGroupe extends JPanel {
	public BoutonGroupe(String nom){
		super();
		add(new JButton("Groupe : " + nom));
		
	}
}
