package studentfollower.views;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import studentfollower.modele.SFConnection;
import studentfollower.modele.dao.DAOFactory;



public class Fenetre extends JFrame {

	private CardLayout centerLayout;
	public String[] cardsName = new String[]{"etudiants","cours","groupes","profil","recherche"};
	private JButton groupes,cours;
	private JPanel center;
	public static double scale = 1;
	
	public Fenetre(int largeur, int hauteur) {
		super("Student Follower");
		
		
		setPreferredSize(new Dimension(largeur, hauteur));
		
		add(new NavigationBar(this), BorderLayout.NORTH);
		
		Horaire h = new Horaire(new Date(2015, 10, 22, 10, 30), new Date(2015, 10, 22, 12, 00));
		
		center = new JPanel();
		centerLayout = new CardLayout();
		center.setLayout(centerLayout);
		add(center, BorderLayout.CENTER);
		
		String[] nomsEtu = new String[]{"Abdoulah", "Paul Durant", "Pierre Dupond", "Claire Martin", "Jacques Richard", "Jeanne Robin", "Pamart Nicolas", "Laude Vincent", "Huth Glenn", "Hachemi Sonia", "Jacques Richard", "Jeanne Robin"};
		String[] nomsGroupe = new String[]{"I","J","C","F","F","F","F","F","F","F","F"};
		
		
		ListeEtudiants list = new ListeEtudiants(nomsEtu);
		JScrollPane p = new JScrollPane(list);
		center.add(p, cardsName[0]);
		centerLayout.show(center, cardsName[0]);
		
		
		center.add(new ListeCours(), cardsName[1]);
		
		p = new JScrollPane(new ListeGroupes(nomsGroupe));
		center.add(p, cardsName[2]);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		groupes = new JButton("Groupes");
		groupes.addActionListener(new CustomActionListener());
		cours = new JButton("Cours");
		cours.addActionListener(new CustomActionListener());
		panel.add(cours);
		panel.add(groupes);
		add(panel, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}

	public void changeCard(String card){
		centerLayout.show(center, card);
	}
	
	public class CustomActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == cours){
				changeCard(cardsName[1]);
			} else if (e.getSource() == groupes){
				changeCard(cardsName[2]);
			}
		}
		
	}
	
	/**
	 * @param args
	 */
	/*
	public static void main(String[] args) {
		scale = (double)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/1280.0;
		new Fenetre((int)(scale*320.0), (int)(scale*480.0));
	}*/
	
	 public static void main( String args[] )
	  {
		 
		 
		 
	    Connection c = null;
	    Statement stmt = null;
	    try {
	      //Class.forName("org.sqlite.JDBC");
	     
	    	c = SFConnection.getInstance();
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

		  System.out.println("Table created successfully");
		    
		    
		    
	      stmt.close();
	      

		    System.out.println(DAOFactory.getEtudiantDAO().find(1));
	      
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    
	
	    
	  }

}
