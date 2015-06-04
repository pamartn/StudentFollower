package studentfollower.modele.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import studentfollower.modele.Etudiant;
import studentfollower.modele.Retard;

public class RetardDAO extends DAO<Retard> {

	public RetardDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Retard obj) {
		return false;
	}

	@Override
	public boolean delete(Retard obj) {
		return false;
	}

	@Override
	public boolean update(Retard obj) {
		return false;
	}

	
	public Retard findByEtudiant(Etudiant etu){
		Retard retard = null;
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Retard WHERE num_etu=" + etu.getNum_etu());
			if(result.next()){
				retard = new Retard(DAOFactory.getEtudiantDAO().find(etu.getNum_etu()),
						DAOFactory.getCoursDAO().find(result.getInt("num_cours")),
						result.getInt("minutes"));
			
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		}
		return retard;
	}
	
	
	@Override
	public Retard find(int id) {
		return null;
	}

}
