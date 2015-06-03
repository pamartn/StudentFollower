package studentfollower.modele;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SFConnection {
	
	private String url = "jdbc:sqlite:test.db";
	private static Connection connection;
	private static SFConnection instance = new SFConnection();
	
	public SFConnection(){
		try {
			connection = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getInstance(){
		return instance.getInstanceLoaded();
	}
	
	public Connection getInstanceLoaded(){
		return connection;
	}
	
}
