package studentfollower.modele;

public class Retard {

	
	private Etudiant etudiant;
	private Cours cours;
	private int minutes;
	
	public Retard(Etudiant etudiant, Cours cours, int minutes) {
		setEtudiant(etudiant);
		setCours(cours);
		setMinutes(minutes);
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

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

}
