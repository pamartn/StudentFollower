import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;


public class Fenetre extends JFrame {

	public Fenetre(int largeur, int hauteur) {
		super("Student Follower");
		
		
		setPreferredSize(new Dimension(largeur, hauteur));
		
		add(new NavigationBar(), BorderLayout.NORTH);
		
		
		
		
		pack();
		setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Fenetre(320, 480);
	}

}
