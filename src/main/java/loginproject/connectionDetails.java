package loginproject;
import java.sql.*;
public class connectionDetails {

	 public final  static String  load_driver = "com.mysql.cj.jdbc.Driver";
	    public final static String  url = "jdbc:mysql://localhost:3306/userdb";
	    public final static String username = "root";
	    public final static String password = "root";

	    public static Connection getConnection() throws Exception{


	            Class.forName(load_driver);
	            return DriverManager.getConnection(url, username, password);

	    }
}
