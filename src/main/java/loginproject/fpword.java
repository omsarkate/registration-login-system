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


@WebServlet("/fpword")
public class fpword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public fpword() {
        super();
       
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
		
		String mail = request.getParameter("mail");
		String npword = request.getParameter("pword");
		
	          
	          
	          try {
	        	  String query = "update  userinfo set pword = ? where mail = ?";
				PreparedStatement ps = connection.prepareStatement(query);
				  ps.setString(1, npword);
				  ps.setString(2, mail);
				  
				  PrintWriter pw = response.getWriter();
				
				 if (  ps.executeUpdate() == 1) {
					 
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
				                + " background-color: yellow;"
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
				        pw.println("New password updated successfully..");
				        	pw.println("</h1>");
				        
				        // Adding a button to go back to the login page
				        pw.println("<a href='login.html'>");
				        pw.println("<button>Back to Login</button></a>");
				        
				        pw.println("</body>");
				 
				        pw.println("</html>");
					 
				 }
				 else {
					
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
				                + " background-color: pink;"
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
				        pw.println("Invalid User..");
				        	pw.println("</h1>");
				        
				        // Adding a button to go back to the login page
				        pw.println("<a href='login.html'>");
				        pw.println("<button>Back to Login</button></a>");
				        
				        pw.println("</body>");
				 
				        pw.println("</html>");
				 }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	public void destroy() {
		// TODO Auto-generated method stub
	}
}
