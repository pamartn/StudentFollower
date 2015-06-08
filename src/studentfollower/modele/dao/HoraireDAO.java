package studentfollower.modele.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import studentfollower.modele.Horaire;
import studentfollower.modele.Professeur;


public class HoraireDAO extends DAO<Horaire> {

	public HoraireDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Horaire obj) {
		return false;
	}

	@Override
	public boolean delete(Horaire obj) {
		return false;
	}

	@Override
	public boolean update(Horaire obj) {
		return false;
	}

	private Calendar getCalendar(String s){
		Calendar c = new GregorianCalendar();
		try {
			c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s));
		} catch (ParseException e) {
		}
		return c;
	}
	
	@Override
	public Horaire find(int id) {
		Horaire horaire = null;
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Horaire WHERE num_horaire=" + id);
			if(result.next()){
				horaire = new Horaire(id, getCalendar(result.getString("date_debut")), getCalendar(result.getString("date_fin")));
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return horaire;
	}

	public Horaire getCurrentHoraire() {
		Horaire horaire = null;
		String timeStamp = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		try{
			String sql = "SELECT * FROM Horaire WHERE Datetime('"+timeStamp+"') >= date_debut AND Datetime('"+timeStamp+"') <= date_fin";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY)
					.executeQuery(sql);
			if(result.next()){
				horaire = new Horaire(result.getInt("num_horaire"), getCalendar(result.getString("date_debut")), getCalendar(result.getString("date_fin")));
			}
				
		} catch(Exception e){
			e.printStackTrace();
		}
		return horaire;
	}
	
	
}
