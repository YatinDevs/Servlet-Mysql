package Pack1;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.security.PublicKey;
// mysql lib
import java.sql.*;

public class DatabaseConfig {
   
	Connection con;
	Statement s;
	ResultSet rs;
	public DatabaseConfig()
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); // loading Driver
			con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/clubhouses","root","cdac");
			s=con.createStatement();
			
		    } catch (Exception f) {	System.out.println("error occurred" + f.getMessage()); }
	}
	
		public Statement getS()
		{
			return s;
		}
		public Connection getCon() { return con;}
		
}

