import java.util.Date;


public class Horaire {
	
	Date debut;
	Date fin;
	
	public Horaire(Date debut, Date fin){
		this.debut = debut;
		this.fin = fin;
	}
	
	public Date getDebut(){
		return debut;
	}
	
	public Date getFin(){
		return fin;
	}
}
