package studentfollower.modele;

public class Etudiant {
	
	private int num_etu;
	private String nom;
	private String prenom;
	private int sexe;
	private Groupe groupe;
	
	public Etudiant(int num_etu, String nom, String prenom, int sexe, Groupe groupe){
		setNum_etu(num_etu);
		setNom(nom);
		setPrenom(prenom);
		setSexe(sexe);
		setGroupe(groupe);
	}

	public int getNum_etu() {
		return num_etu;
	}

	public void setNum_etu(int num_etu) {
		this.num_etu = num_etu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getSexe() {
		return sexe;
	}

	public void setSexe(int sexe) {
		this.sexe = sexe;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	
}
