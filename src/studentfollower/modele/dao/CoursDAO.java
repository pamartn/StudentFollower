package studentfollower.modele.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import studentfollower.modele.Cours;
import studentfollower.modele.Etudiant;

public class CoursDAO extends DAO<Cours> {

	public CoursDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Cours obj) {
		return false;
	}

	@Override
	public boolean delete(Cours obj) {
		return false;
	}

	@Override
	public boolean update(Cours obj) {
		return false;
	}

	@Override
	public Cours find(int id) {
		Cours cours = null;
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Cours WHERE num_cours=" + id);
			if(result.next()){
				cours = new Cours(id, 
						result.getString("matiere"), 
						result.getString("salle"), 
						DAOFactory.getGroupeDAO().find(result.getInt("num_groupe")),
						DAOFactory.getProfesseurDAO().find(result.getInt("num_prof")),
						DAOFactory.getHoraireDAO().find(result.getInt("num_horaire")));
			
			}
				
		} catch(Exception e){
			e.printStackTrace();
		}

		System.out.println(cours);
		return cours;	
	}

}
