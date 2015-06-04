package studentfollower.modele;

public class Commentaire {
	
	private Etudiant etu;
	private Cours cours;
	private Professeur prof;
	private String texte;
	private int avis;
	
	public Commentaire(Etudiant etu,Cours cours,Professeur prof,String texte,int avis) {
		setCours(cours);
		setProf(prof);
		setTexte(texte);
		setAvis(avis);
	}

	

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public Professeur getProf() {
		return prof;
	}

	public void setProf(Professeur prof) {
		this.prof = prof;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public int getAvis() {
		return avis;
	}

	public void setAvis(int avis) {
		this.avis = avis;
	}



	public Etudiant getEtu() {
		return etu;
	}



	public void setEtu(Etudiant etu) {
		this.etu = etu;
	}

}
