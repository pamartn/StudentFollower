package studentfollower.modele.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import studentfollower.modele.Etudiant;
import studentfollower.modele.Groupe;

public class EtudiantDAO extends DAO<Etudiant> {

	public EtudiantDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Etudiant obj) {
		return false;
	}

	public boolean delete(Etudiant obj) {
		return false;
	}

	public boolean update(Etudiant obj) {
		return false;
	}
	
	public Etudiant find(int id) {
		Etudiant etu = null;
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Etudiant WHERE num_etu=" + id);
			if(result.next()){
				etu = new Etudiant(
						id,
						result.getString("nom"),
						result.getString("prenom"),
						result.getInt("sexe"),
						DAOFactory.getGroupeDAO().find(result.getInt("num_groupe")));
			
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		}
		return etu;	
	}
}