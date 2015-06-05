package studentfollower.controller;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;

import javax.swing.JPanel;

import studentfollower.modele.Professeur;
import studentfollower.modele.SFConnection;
import studentfollower.modele.dao.DAO;
import studentfollower.modele.dao.DAOFactory;
import studentfollower.views.Fenetre;

public class FenetreController {

	private Fenetre fenetre;
	private NavBarController navBarController;
	private MiddleViewController midViewControl;
	private FooterBarController footerBarControl;
	
	public static double scale = 1;
	
	public FenetreController() {
		fenetre = new Fenetre((int)(scale*320.0), (int)(scale*480.0), new FenetreListener());
		Professeur prof = DAOFactory.getProfesseurDAO().find(1);
		navBarController = new NavBarController(this,prof);
		midViewControl = new MiddleViewController(prof);
		footerBarControl = new FooterBarController(this, prof);
		
		
		fenetre.loadUI(navBarController.getView(),midViewControl.getView(), footerBarControl.getView());
	}
	
	
	
	public void actionCours(){
		
	}
	
	public void actionGroupe(){
		
	}

	
	public static void main(String args[]){
		DAOFactory.initDB();
		scale = (double)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/1280.0;
		new FenetreController();
	}



	public MiddleViewController getMiddleView() {
		return midViewControl;
	}

	
	public class FenetreListener implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {
		}

		@Override
		public void windowClosing(WindowEvent e) {
			try {
				SFConnection.getInstance().close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		@Override
		public void windowClosed(WindowEvent e) {
		}

		@Override
		public void windowIconified(WindowEvent e) {
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
		}

		@Override
		public void windowActivated(WindowEvent e) {
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
		}
		
	}
}
