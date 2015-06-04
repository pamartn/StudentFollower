package studentfollower.modele.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;

import studentfollower.modele.SFConnection;

public class DAOFactory {

	  protected static final Connection conn = SFConnection.getInstance();   

	  public static EtudiantDAO getEtudiantDAO(){
		  return new EtudiantDAO(conn);
	  }
	  public static GroupeDAO getGroupeDAO(){
		  return new GroupeDAO(conn);
	  }
	  public static HoraireDAO getHoraireDAO(){
		  return new HoraireDAO(conn);
	  }
	  public static ProfesseurDAO getProfesseurDAO(){
		  return new ProfesseurDAO(conn);
	  }
	public static CoursDAO getCoursDAO() {
		return new CoursDAO(conn);
	}
	
	public static void initDB(){
		 Statement stmt = null;
		    try {
		      //Class.forName("org.sqlite.JDBC");
		     
		    Connection	c = conn;
		      System.out.println("Opened database successfully");

		      stmt = c.createStatement();
		      StringBuilder req = new StringBuilder();
		      
		      try{
		    	  FileReader reader = new FileReader(new File("res/createBase.sql"));
		    	 BufferedReader  f = new BufferedReader(reader);
		    	 String s = ""; 
		    	 while((s = f.readLine()) != null){
		    		 req.append(s + "\n");
		    	 }
		    	  
		      } catch(Exception e){
		    	  System.out.println("Problem loading file");
		      }
		      System.out.println(req);
		      
		      stmt.executeUpdate(req.toString());
		      stmt.close();

		      stmt = c.createStatement();
		      try{
		    	  FileReader reader = new FileReader(new File("res/fullBase.sql"));
		    	 BufferedReader  f = new BufferedReader(reader);
		    	 String s = ""; 
		    	 while((s = f.readLine()) != null){
		    		 req.append(s + "\n");
		    	 }
		      } catch(Exception e){
		    	  System.out.println("Problem loading file");
		      }
		      System.out.println(req);
		      stmt.executeUpdate(req.toString());

			  System.out.println("Table created and fulled succesfully");
			   stmt.close();
			    
		      
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
	}
}