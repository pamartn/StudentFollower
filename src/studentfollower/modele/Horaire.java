package studentfollower.modele;

import java.util.Calendar;
import java.util.Calendar;

public class Horaire {

	private int num_horaire;
	private Calendar Calendar_debut;
	private Calendar Calendar_fin;
	
	
	public Horaire(int num_horaire, Calendar CalendarDebut,Calendar CalendarFin){
		setNum_horaire(num_horaire);
		setCalendar_debut(CalendarDebut);
		setCalendar_fin(CalendarFin);
	}

	public int getNum_horaire() {
		return num_horaire;
	}


	public void setNum_horaire(int num_horaire) {
		this.num_horaire = num_horaire;
	}


	public Calendar getCalendar_debut() {
		return Calendar_debut;
	}


	public void setCalendar_debut(Calendar CalendarDebut) {
		this.Calendar_debut = CalendarDebut;
	}


	public Calendar getCalendar_fin() {
		return Calendar_fin;
	}


	public void setCalendar_fin(Calendar CalendarFin) {
		this.Calendar_fin = CalendarFin;
	}

	public String getHeureFin() {
		return Calendar_fin.get(Calendar.HOUR_OF_DAY) +":" +Calendar_fin.get(Calendar.MINUTE);
	}
	public String getHeureDebut() {
		return Calendar_debut.get(Calendar.HOUR_OF_DAY)+":"+ Calendar_debut.get(Calendar.MINUTE);
	}

	public boolean inferiorTo(Horaire h) {
		return h.getCalendar_debut().before(getCalendar_debut());
	}
}