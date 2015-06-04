package studentfollower.modele;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Horaire {

	private int num_horaire;
	private SimpleDateFormat date_debut;
	private SimpleDateFormat date_fin;
	
	
	public Horaire(int num_horaire, SimpleDateFormat dateDebut,SimpleDateFormat dateFin){
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


	public SimpleDateFormat getDate_debut() {
		return date_debut;
	}


	public void setDate_debut(SimpleDateFormat dateDebut) {
		this.date_debut = dateDebut;
	}


	public SimpleDateFormat getDate_fin() {
		return date_fin;
	}


	public void setDate_fin(SimpleDateFormat dateFin) {
		this.date_fin = dateFin;
	}
}