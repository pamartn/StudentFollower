package studentfollower.views;

import javax.swing.JLabel;

import studentfollower.modele.Professeur;

public class GroupeListView extends ListView {

	
	
	public GroupeListView(Professeur prof) {
		add(new JLabel("groupe"));
	}

}
