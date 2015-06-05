package studentfollower.views;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import studentfollower.modele.SFConnection;
import studentfollower.modele.dao.DAOFactory;



public class Fenetre extends JFrame {

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
