package studentfollower.modele;

public class Groupe {
	private int num_groupe;
	private String nom;
	
	
	public Groupe(int num_groupe, String nom){
		setNum_groupe(num_groupe);
		setNom(nom);
	}
	
	public int getNum_groupe() {
		return num_groupe;
	}
	public void setNum_groupe(int num_groupe) {
		this.num_groupe = num_groupe;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}
