package studentfollower.views;

import javax.swing.JPanel;


public class MiddleView extends JPanel {
	
	
	
	
	public MiddleView(){
		super();
		setVisible(true);
	}
	
	public void loadUI(ListView view){
		add(view);
		repaint();
	}
}
