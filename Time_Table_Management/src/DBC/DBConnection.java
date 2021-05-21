package DBC;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DBConnection {
	
	    
	    public static Connection connect(){
	         Connection conn = null;
	        try{
	        	Class.forName("org.sqlite.JDBC");
	        	
				conn=DriverManager.getConnection("jdbc:sqlite:ITPM.db");
	            System.out.println("Connected!");
	        }catch(Exception e){
	            JOptionPane.showMessageDialog(null, e);
	            return null;
	        }
			return conn;
	        
	    }

}