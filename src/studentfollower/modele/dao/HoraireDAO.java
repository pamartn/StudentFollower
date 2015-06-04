package studentfollower.modele.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

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
				horaire = new Horaire(id, result.getDate("date_debut"), result.getDate("date_fin"));
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		}
		return horaire;
	}
	
	
}
