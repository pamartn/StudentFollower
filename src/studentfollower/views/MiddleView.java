package studentfollower.views;

import java.awt.CardLayout;
import java.util.HashMap;

import javax.swing.JPanel;


public class MiddleView extends JPanel {

	
	private CardLayout layout;
	
	public MiddleView(){
		super();
		layout = new CardLayout();
		setLayout(layout);
		setVisible(true);
	}

	public void loadUI(String name) {
		layout.show(this, name);
		System.out.println(name);
		repaint();
	}

	public void addUI(ListView view, String name) {
		add(view,name);
	}
}
