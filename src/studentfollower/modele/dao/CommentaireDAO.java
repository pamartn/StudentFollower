package studentfollower.modele.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import studentfollower.modele.Commentaire;
import studentfollower.modele.Cours;
import studentfollower.modele.Etudiant;

public class CommentaireDAO extends DAO<Commentaire> {

	public CommentaireDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Commentaire obj) {
		return false;
	}

	@Override
	public boolean delete(Commentaire obj) {
		return false;
	}

	@Override
	public boolean update(Commentaire obj) {
		return false;
	}

	public Commentaire findByEtudiant(Etudiant etu){
		Commentaire com =null;
		try{
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Commentaire WHERE num_etu=" + etu.getNum_etu());
			if(result.next()){
				com = new Commentaire(DAOFactory.getEtudiantDAO().find(etu.getNum_etu()),
						DAOFactory.getCoursDAO().find(result.getInt("num_cours")),
						DAOFactory.getProfesseurDAO().find(result.getInt("num_prof")),
						result.getString("texte"),
						result.getInt("avis"));
			
			}
				
		} catch(SQLException e){
			e.printStackTrace();
		}
		return com;
		
	}
	
	@Override
	public Commentaire find(int id) {
		return null;
	}

}
