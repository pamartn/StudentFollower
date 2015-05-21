import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NavigationBar extends JPanel {

	
	private Fenetre fenetre;
	private JButton home;
	
	public NavigationBar(Fenetre f) {
		super();
		this.fenetre = f;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		ImageIcon img = new ImageIcon("res/homeicon.png");
		home = new JButton(new ImageIcon(img.getImage().getScaledInstance( 40, 40, java.awt.Image.SCALE_SMOOTH )));
		home.addActionListener(new CustomActionListener());
		p.add(home, BorderLayout.WEST);
		
		p.add(new JLabel("Gery Casiez"), BorderLayout.CENTER);
		add(p);
		
		JTextField textField = new JTextField();
		textField.setBorder(BorderFactory.createLineBorder(Color.RED, 10));
		textField.setFont(new CustomFont());
		textField.setText("search");
		add(textField);
		

		add(new JLabel("IHM - Groupe J - 13H30 - 15H30"));
		
		
		setVisible(true);
	}

	public class CustomActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			fenetre.changeCard(fenetre.cardsName[0]);
		}
		
	}

}
