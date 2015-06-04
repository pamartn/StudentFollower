package studentfollower.modele.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import studentfollower.modele.Etudiant;
import studentfollower.modele.Professeur;

public class ProfesseurDAO extends DAO<Professeur> {

	public ProfesseurDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Professeur obj) {
		return false;
	}

	@Override
	public boolean delete(Professeur obj) {
		return false;
	}

	@Override
	public boolean update(Professeur obj) {
		return false;
	}

	@Override
	public Professeur find(int id) {
		Professeur prof = null;
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Professeur WHERE num_prof=" + id);
			if(result.next()){
				prof = new Professeur(
						id,
						result.getString("prenom"),
						result.getString("nom"));
			
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		}
		return prof;
	}

}
