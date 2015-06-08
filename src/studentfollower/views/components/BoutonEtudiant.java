package studentfollower.views.components;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import studentfollower.controller.FenetreController;
import studentfollower.views.Fenetre;


public class BoutonEtudiant extends JPanel {

	
	private int state;
	private JButton bWest, bMilieu, bEast;
	private BoutonCommentaire commentaire;
	private Color[] colorList = new Color[]{Color.green,Color.red,Color.orange};
	private int retard = 5;
	
	
	public BoutonEtudiant(String etudiant, boolean appel) {
		super();
		setLayout(new BorderLayout());
		ImageIcon img = new ImageIcon("res/eleve.png");
		
		bWest = new JButton(new ImageIcon(img.getImage().getScaledInstance( 40, 40, java.awt.Image.SCALE_SMOOTH )));
		add(bWest, BorderLayout.WEST);
		
		bMilieu = new JButton(etudiant);
		add(bMilieu, BorderLayout.CENTER);
		bMilieu.setFont(bMilieu.getFont().deriveFont((float)FenetreController.scale*15f));
		ImageIcon img2 = new ImageIcon("res/down.png");
		bEast = new JButton(new ImageIcon(img2.getImage().getScaledInstance( 40, 40, java.awt.Image.SCALE_SMOOTH)));
		bEast.setSize(new Dimension(40,40));
		bEast.addActionListener(new CustomListener());
		add(bEast, BorderLayout.EAST);
		
		bEast.setBackground(Color.white);
		bEast.setForeground(Fenetre.blueColor);
		bWest.setBackground(Color.WHITE);
		bMilieu.setBackground(Color.WHITE);
		bMilieu.setForeground(Fenetre.blueColor);
		
		bWest.setForeground(Fenetre.blueColor);
		if(appel){
			bMilieu.setForeground(Color.white);
			bMilieu.setBackground(Color.green);
			bMilieu.addActionListener(new CustomListener());
		}
		
		commentaire = new BoutonCommentaire();
		commentaire.setVisible(false);
		add(commentaire, BorderLayout.SOUTH);
		
	}
	
	public int getRetard(){
		return retard;
	}
	
	public int getState(){
		return state;
	}

	private void changeStateColor() {
		bMilieu.setBackground(colorList[state]);
	}
	
	public class CustomListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == bMilieu){
				state = state < colorList.length-1 ? state +1 : 0;
				changeStateColor();
				if(colorList[state] == Color.orange){
					commentaire.setRetard(retard);
				} else {
					commentaire.setRetard(0);
				}
				
			} else if (e.getSource() == bEast){
				commentaire.setVisible(!commentaire.isVisible());
			}
			
		}

		
		
	}
	
}
