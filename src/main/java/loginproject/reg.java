package loginproject;

import jakarta.servlet.ServletConfig;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet("/reg")
public class reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reg() {
        super();
        // TODO Auto-generated constructor stub
    }
    Connection connection;
	
	public void init(ServletConfig config) throws ServletException {
		try {
			connection = connectionDetails.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		          String fname =   request.getParameter("fname");
		          String lname =   request.getParameter("lname");
		          String mail =   request.getParameter("mail");
		          String pword =   request.getParameter("pword");
		          
		          String query = "insert into userinfo values (?,?,?,?)";
		          try {
					PreparedStatement  ps = connection.prepareStatement(query);
					ps.setString(1, fname);
					ps.setString(2, lname);
					ps.setString(3, mail);
					ps.setString(4, pword);
					PrintWriter pw = response.getWriter();
					
			  ps.executeUpdate();
					
					
					String ss = "Registerd successfully..";
					
					 pw.println("<html>");
				        pw.println("<head>");
				        pw.println("<title>Hello Page</title>");
				        
				        // Adding some internal CSS for styling
				        pw.println("<style>");
				        pw.println("body {"
				                + " font-family: Arial, sans-serif;"
				                + " background-color: #f4f4f9;"
				                + " margin: 0;"
				                + " padding: 0;"
				                + " display: flex;"
				                + " flex-direction: column;"
				                + " justify-content: center;"
				                + " align-items: center;"
				                + " height: 100vh;"
				                + "}");
				        pw.println("h1 {"
				                + " color: #333;"
				                + " background-color: #00a8e8;"
				                + " padding: 20px;"
				                + " border-radius: 10px;"
				                + " box-shadow: 0px 4px 10px rgba(0,0,0,0.1);"
				                + " margin-bottom: 20px;"
				                + "}");
				        pw.println("button {"
				                + " padding: 10px 20px;"
				                + " font-size: 16px;"
				                + " background-color: #00a8e8;"
				                + " color: white;"
				                + " border: none;"
				                + " border-radius: 5px;"
				                + " cursor: pointer;"
				                + " box-shadow: 0px 2px 5px rgba(0,0,0,0.2);"
				                + "}");
				        pw.println("button:hover {"
				                + " background-color: #0077b6;"
				                + "}");
				        pw.println("</style>");
				        
				        pw.println("</head>");
				        pw.println("<body>");
				        pw.println("<h1>");
				        pw.println(ss);
				        	pw.println("</h1>");
				        
				        // Adding a button to go back to the login page
				        pw.println("<a href='login.html'>");
				        pw.println("<button>Back to Login</button></a>");
				        
				        pw.println("</body>");
				 
				        pw.println("</html>");
					
			  
			  
			 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		          
		            
		         
	
	}
	
	
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
