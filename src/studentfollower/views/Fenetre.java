package studentfollower.views;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowListener;

import javax.swing.JFrame;



public class Fenetre extends JFrame {

	public static Color blueColor = new Color(3, 139, 153);
	private CardLayout centerLayout;
	public String[] cardsName = new String[]{"etudiants","cours","groupes","profil","recherche"};
	
	public Fenetre(int largeur, int hauteur, WindowListener l) {
		super("Student Follower");
		setPreferredSize(new Dimension(largeur, hauteur));
		pack();
		setVisible(true);
		addWindowListener(l);
	}

	public void loadUI(NavigationBarView navigationBar, MiddleView middleView, FooterBarView footerBar) {
		
		setLayout(new BorderLayout());
		add(navigationBar, BorderLayout.NORTH);
		add(middleView, BorderLayout.CENTER);
		add(footerBar,BorderLayout.SOUTH);
		pack();
		setVisible(true);
		repaint();
	}
	
	


}
