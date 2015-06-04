package studentfollower.modele.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import studentfollower.modele.Absence;
import studentfollower.modele.Etudiant;

public class AbsenceDAO extends DAO<Absence> {

	public AbsenceDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Absence obj) {
		return false;
	}

	@Override
	public boolean delete(Absence obj) {
		return false;
	}

	@Override
	public boolean update(Absence obj) {
		return false;
	}

	public Absence findByEtudiant(Etudiant etu){
		Absence absence = null;
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Absence WHERE num_etu=" + etu.getNum_etu());
			if(result.next()){
				absence = new Absence(DAOFactory.getEtudiantDAO().find(etu.getNum_etu()),
						DAOFactory.getCoursDAO().find(result.getInt("num_cours")));
			
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		}
		return absence;
	}
	
	
	@Override
	public Absence find(int id) {
		return null;
	}

}
