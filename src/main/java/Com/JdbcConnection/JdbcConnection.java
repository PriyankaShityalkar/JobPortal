package Com.JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection 
{
	public static Connection con;
	
	public static Connection getConnection() 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jobportal","root","root");	
		}
		catch(Exception e)
		{
			
		}
		return con;
	}

}
