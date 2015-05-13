import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class NavigationBar extends JPanel {

	
	
	
	public NavigationBar() {
		super();
		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.WEST;
		c.anchor = GridBagConstraints.WEST;
		c.gridwidth = 1;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		ImageIcon img = new ImageIcon("res/homeicon.png");
		add(new JButton(new ImageIcon(img.getImage().getScaledInstance( 40, 40, java.awt.Image.SCALE_SMOOTH ))), c);
		
		c.fill = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		c.gridwidth = 1;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 1;
		add(new JLabel("Gery Casiez"), c);

		
		JTextField textField = new JTextField();
		textField.setText("search");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(10,0,0,0);  //top padding
		add(textField, c);
		
		
		c.fill = GridBagConstraints.CENTER;
		c.anchor = GridBagConstraints.CENTER;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(10,0,0,0);  //top padding
		add(new JLabel("IHM - Groupe J - 13H30 - 15H30"), c);
		
		
		
		setVisible(true);
	}

	

}
