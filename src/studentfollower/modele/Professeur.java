package studentfollower.modele;

public class Professeur {
	private int num_prof;
	private String prenom;
	private String nom;
	
	
	public Professeur(int num_prof,String prenom,String nom){
		setNum_prof(num_prof);
		setNom(nom);
		setPrenom(prenom);
	}


	public int getNum_prof() {
		return num_prof;
	}


	public void setNum_prof(int num_prof) {
		this.num_prof = num_prof;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
}
