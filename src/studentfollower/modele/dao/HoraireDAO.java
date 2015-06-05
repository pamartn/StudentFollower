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

	@Override
	public Horaire find(int id) {
		Horaire horaire = null;
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Horaire WHERE num_horaire=" + id);
			if(result.next()){
				Date dateDebut = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").parse(result.getString("date_debut"));
				Date dateFin = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").parse(result.getString("date_fin"));
				horaire = new Horaire(id, dateDebut, dateFin);
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ParseException e) {
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
			System.out.println(sql);
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY)
					.executeQuery(sql);
			if(result.next()){
				//System.out.println("next");
				Date dateDebut = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").parse(result.getString("date_debut"));
				Date dateFin = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").parse(result.getString("date_fin"));
				
				horaire = new Horaire(result.getInt("num_horaire"), dateDebut, dateFin);
				System.out.println("Found result : id n°"+horaire.getNum_horaire()+ " " + horaire.getDate_debut() + " / " + horaire.getDate_fin());
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return horaire;
	}
	
	
}
