package studentfollower.modele.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import studentfollower.modele.Etudiant;
import studentfollower.modele.Groupe;

public class GroupeDAO extends DAO<Groupe> {

	public GroupeDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Groupe obj) {
		return false;
	}

	public boolean delete(Groupe obj) {
		return false;
	}

	public boolean update(Groupe obj) {
		return false;
	}

	@Override
	public Groupe find(int id) {
		Groupe groupe = null;
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Groupe WHERE num_groupe=" + id);
			if(result.next()){
				groupe = new Groupe(result.getInt("num_groupe"), result.getString("nom_groupe"));
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return groupe;	
	}

}
