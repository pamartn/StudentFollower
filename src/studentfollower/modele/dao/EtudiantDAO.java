package studentfollower.modele.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import studentfollower.modele.Etudiant;
import studentfollower.modele.Groupe;
import studentfollower.views.ListeEtudiants;

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

	public List<Etudiant> findAllByGroupe(Groupe groupe) {
		List<Etudiant> listEtu = new ArrayList<Etudiant>();
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Etudiant WHERE num_groupe=" + groupe.getNum_groupe());
			while(result.next()){
				listEtu.add(new Etudiant(
						result.getInt("num_etu"),
						result.getString("nom"),
						result.getString("prenom"),
						result.getInt("sexe"),
						DAOFactory.getGroupeDAO().find(result.getInt("num_groupe"))));
			
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		}
		return listEtu;	
	}
}