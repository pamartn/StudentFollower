package studentfollower.views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import studentfollower.controller.FenetreController;
import studentfollower.modele.Cours;
import studentfollower.modele.Professeur;
import studentfollower.views.components.CustomFont;


public class NavigationBarView extends JPanel {

	
	private JButton home, search;
	private JLabel nom;
	
	private ImageIcon imgHome,imgSearch;
	
	private JTextField textField;
	
	
	
	public NavigationBarView() {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		imgHome = new ImageIcon("res/homeicon.png");
		home = new JButton(new ImageIcon(imgHome.getImage().getScaledInstance( 40, 40, java.awt.Image.SCALE_SMOOTH )));
		
		ImageIcon imgSearch = new ImageIcon("res/search.png");
		search = new JButton(new ImageIcon(imgSearch.getImage().getScaledInstance( 40, 40, java.awt.Image.SCALE_SMOOTH )));
		
		
		textField = new JTextField();
		textField.setBorder(BorderFactory.createLineBorder(Color.RED, 10));
		textField.setFont(new CustomFont());
		textField.setText("search");
		
		setVisible(true);
	}
	
	public void loadUI(Cours cours,Professeur prof, ActionListener l, KeyListener textL){
		removeAll();
		invalidate();
		revalidate();
		
		
		setLayout(new BorderLayout());
		home.addActionListener(l);
		nom = new JLabel(prof.getPrenom() +" "+ prof.getNom(), SwingConstants.CENTER);
		nom.setFont(nom.getFont().deriveFont(20f * (float)FenetreController.scale));
		
		add(home, BorderLayout.WEST);
		add(nom, BorderLayout.CENTER);
		search.addActionListener(new SearchListener());
		add(search,BorderLayout.EAST);
		textField.addKeyListener(textL);
		textField.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
			}
		});
		try{
			String dateD = cours.getHoraire().getDate_debut().getHours()+":"+
					cours.getHoraire().getDate_debut().getMinutes();
			String dateF = cours.getHoraire().getDate_fin().getHours()+":"+
					cours.getHoraire().getDate_fin().getMinutes();
			
			add(new JLabel(cours.getMatiere() + " en salle " + cours.getSalle() + " de " + dateD + " à " + dateF, SwingConstants.CENTER), BorderLayout.SOUTH);
			
		} catch(Exception e){
			add(new JLabel("Aucun cours sélectionné", SwingConstants.CENTER),BorderLayout.SOUTH);
			
		}

		repaint();
	}

	
	
	public class SearchListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			nom.setVisible(false);
			add(textField,BorderLayout.CENTER);
			repaint();
		}
		
	}



	public String getSearchText() {
		return textField.getText();
	}

}
