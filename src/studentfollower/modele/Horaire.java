package studentfollower.modele;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Horaire {

	private int num_horaire;
	private Date date_debut;
	private Date date_fin;
	
	
	public Horaire(int num_horaire, Date dateDebut,Date dateFin){
		setNum_horaire(num_horaire);
		setDate_debut(dateDebut);
		setDate_fin(dateFin);
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


	public void setDate_debut(Date dateDebut) {
		this.date_debut = dateDebut;
	}


	public Date getDate_fin() {
		return date_fin;
	}


	public void setDate_fin(Date dateFin) {
		this.date_fin = dateFin;
	}

	public String getHeureFin() {
		return date_fin.getHours() + ":" +date_fin.getMinutes();
	}
	public String getHeureDebut() {
		return date_debut.getHours() +":"+ date_debut.getMinutes();
	}
}