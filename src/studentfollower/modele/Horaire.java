package studentfollower.modele;

import java.sql.Date;

public class Horaire {

	private int num_horaire;
	private Date date_debut;
	private Date date_fin;
	
	
	public Horaire(int num_horaire, Date date_debut,Date date_fin){
		setNum_horaire(num_horaire);
		setDate_debut(date_debut);
		setDate_fin(date_fin);
	}

	public int getNum_horaire() {
		return num_horaire;
	}


	public void setNum_horaire(int num_horaire) {
		this.num_horaire = num_horaire;
	}


	public Date getDate_debut() {
		return date_debut;
	}


	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}


	public Date getDate_fin() {
		return date_fin;
	}


	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
}