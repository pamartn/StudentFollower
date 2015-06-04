package studentfollower.modele;

public class Cours {
	private int num_cours;
	private String matiere;
	private String salle;
	private int num_groupe;
	private int num_prof;
	private int num_horaire;
	
	
	public Cours(){
		
	}


	public int getNum_cours() {
		return num_cours;
	}


	public void setNum_cours(int num_cours) {
		this.num_cours = num_cours;
	}
}
