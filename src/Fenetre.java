import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Fenetre extends JFrame {

	private CardLayout centerLayout;
	public String[] cardsName = new String[]{"etudiants","cours","groupes","profil","recherche"};
	private JButton groupes,cours;
	private JPanel center;
	
	public Fenetre(int largeur, int hauteur) {
		super("Student Follower");
		
		
		setPreferredSize(new Dimension(largeur, hauteur));
		
		add(new NavigationBar(this), BorderLayout.NORTH);
		
		Horaire h = new Horaire(new Date(2015, 10, 22, 10, 30), new Date(2015, 10, 22, 12, 00));
		
		center = new JPanel();
		centerLayout = new CardLayout();
		center.setLayout(centerLayout);
		add(center, BorderLayout.CENTER);
		
		String[] nomsEtu = new String[]{"Abdoulah", "Paul Durant", "Pierre Dupond", "Claire Martin", "Jacques Richard", "Jeanne Robin", "Pamart Nicolas", "Laude Vincent", "Huth Glenn", "Hachemi Sonia", "Jacques Richard", "Jeanne Robin"};
		String[] nomsGroupe = new String[]{"I","J","C","F","F","F","F","F","F","F","F"};
		
		
		ListeEtudiants list = new ListeEtudiants(nomsEtu);
		JScrollPane p = new JScrollPane(list);
		center.add(p, cardsName[0]);
		centerLayout.show(center, cardsName[0]);
		
		
		center.add(new ListeCours(), cardsName[1]);
		
		p = new JScrollPane(new ListeGroupes(nomsGroupe));
		center.add(p, cardsName[2]);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		groupes = new JButton("Groupes");
		groupes.addActionListener(new CustomActionListener());
		cours = new JButton("Cours");
		cours.addActionListener(new CustomActionListener());
		panel.add(cours, BorderLayout.WEST);
		panel.add(groupes, BorderLayout.EAST);
		add(panel, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}

	public void changeCard(String card){
		centerLayout.show(center, card);
	}
	
	public class CustomActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == cours){
				changeCard(cardsName[1]);
			} else if (e.getSource() == groupes){
				changeCard(cardsName[2]);
			}
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Fenetre(320, 480);
	}

}
