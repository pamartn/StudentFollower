package studentfollower.modele.dao;

import java.sql.Connection;

import studentfollower.modele.SFConnection;

public class DAOFactory {

	  protected static final Connection conn = SFConnection.getInstance();   

	  public static EtudiantDAO getEtudiantDAO(){
		  return new EtudiantDAO(conn);
	  }
	  public static GroupeDAO getGroupeDAO(){
		  return new GroupeDAO(conn);
	  }
}