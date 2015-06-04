package studentfollower.modele;

public class Absence {

	private Etudiant etudiant;
	private Cours cours;
	
	
	public Absence(Etudiant etudiant, Cours cours) {
		setEtudiant(etudiant);
		setCours(cours);
	}


	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	public Cours getCours() {
		return cours;
	}


	public void setCours(Cours cours) {
		this.cours = cours;
	}

}
