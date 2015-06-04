package studentfollower.modele;

public class Cours {
	private int num_cours;
	private String matiere;
	private String salle;
	private Groupe groupe;
	private Professeur prof;
	private Horaire horaire;
	
	
	public Cours(int num_cours, String matiere,String salle,Groupe groupe,Professeur prof,Horaire horaire){
		setNum_cours(num_cours);
		setMatiere(matiere);
		setSalle(salle);
		setGroupe(groupe);
		setProf(prof);
		setHoraire(horaire);
	}


	public int getNum_cours() {
		return num_cours;
	}


	public void setNum_cours(int num_cours) {
		this.num_cours = num_cours;
	}


	public String getMatiere() {
		return matiere;
	}


	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}


	public String getSalle() {
		return salle;
	}


	public void setSalle(String salle) {
		this.salle = salle;
	}


	public Groupe getGroupe() {
		return groupe;
	}


	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}


	public Professeur getProf() {
		return prof;
	}


	public void setProf(Professeur prof) {
		this.prof = prof;
	}


	public Horaire getHoraire() {
		return horaire;
	}


	public void setHoraire(Horaire horaire) {
		this.horaire = horaire;
	}


	
}
