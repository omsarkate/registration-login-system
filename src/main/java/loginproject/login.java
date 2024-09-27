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


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public login() {
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

	/**
	 * @see Servlet#destroy()
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		       
		String mail = request.getParameter("mail");
		String pword = request.getParameter("pword");
		
		      try {

		    	  String query =  "select * from userinfo where mail = ? && pword = ?";
			      
		    	  
				PreparedStatement ps = connection.prepareStatement(query);
				  ps.setString(1, mail);
				  ps.setString(2, pword);
				  
				ResultSet  rs =  ps.executeQuery();
				PrintWriter pw = response.getWriter();
		      
				 if (rs.next()) {
					 
					String getfname = rs.getString(1);
					String getlname = rs.getString(2);
					String getmail = rs.getString(3);
					String getpword = rs.getString(4);
					
					 pw.println("<html>");
				        pw.println("<head>");
				        pw.println("<title>User Details</title>");
				        
				        // Adding internal CSS for styling
				        pw.println("<style>");
				        pw.println("body {"
				                + " font-family: Arial, sans-serif;"
				                + " background-color: #f4f4f9;"
				                + " display: flex;"
				                + " justify-content: center;"
				                + " align-items: center;"
				                + " height: 100vh;"
				                + " flex-direction: column;"
				                + "}");
				        pw.println("div {"
				                + " background-color: #fff;"
				                + " padding: 20px;"
				                + " border-radius: 10px;"
				                + " box-shadow: 0px 4px 10px rgba(0,0,0,0.1);"
				                + " display: none;"  // Initially hidden
				                + "}");
				        pw.println("h1 {"
				                + " color: #333;"
				                + " background-color: #00a8e8;"
				                + " padding: 20px;"
				                + " border-radius: 10px;"
				                + " box-shadow: 0px 4px 10px rgba(0,0,0,0.1);"
				                + " margin-bottom: 20px;"
				                + "}");
				        pw.println("h2 {"
				                + " color: #333;"
				                + "}");
				        pw.println("p {"
				                + " font-size: 16px;"
				                + " margin: 10px 0;"
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
				                + " margin-top: 20px;"
				                + "}");
				        pw.println("button:hover {"
				                + " background-color: #0077b6;"
				                + "}");
				        pw.println("</style>");
				        
				        // Adding JavaScript to show the details
				        pw.println("<script>");
				        pw.println("function toggleDetails() {");
				        pw.println("  var details = document.getElementById('userDetails');");
				        pw.println("  var btn = document.getElementById('toggleButton');");
				        pw.println("  if (details.style.display === 'none') {");
				        pw.println("    details.style.display = 'block';");
				        pw.println("    btn.innerText = 'Hide Details';");  // Change button text to "Hide Details"
				        pw.println("  } else {");
				        pw.println("    details.style.display = 'none';");
				        pw.println("    btn.innerText = 'Show Details';");  // Change button text back to "Show Details"
				        pw.println("  }");
				        pw.println("}");
				        pw.println("</script>");
				        
				        pw.println("</head>");
				        pw.println("<body>");
				        
				        pw.println("<h1>"+"Welcome Back " + getfname + " !!"+ "</h1>");
				        
				        // Adding a button to show user details
				        pw.println("<button onclick='toggleDetails()'>Show Details</button>");
				        
				        // Displaying user details (initially hidden)
				        pw.println("<div id='userDetails'>");
				        pw.println("<h2>User Details</h2>");
				        pw.println("<p><strong>First Name:</strong> " + getfname + "</p>");
				        pw.println("<p><strong>Last Name:</strong> " + getlname + "</p>");
				        pw.println("<p><strong>Email:</strong> " + getmail + "</p>");
				        pw.println("<p><strong>Password:</strong> " + getpword + "</p>");
				        
				        pw.println("</div>");
				        
				        pw.println("</body>");
				        pw.println("</html>");
					
					
					
					
					
					
					
				 }
				 
				 else {
					 
					 pw.println("<html>");
				        pw.println("<head>");
				        pw.println("<title>Login Result</title>");
				        
				        // Adding some internal CSS for styling
				        pw.println("<style>");
				        pw.println("body {"
				                + " font-family: Arial, sans-serif;"
				                + " background-color: #f4f4f9;"
				                + " display: flex;"
				                + " justify-content: center;"
				                + " align-items: center;"
				                + " height: 100vh;"
				                + " flex-direction: column;"
				                + "}");
				        
				        pw.println(".error {"
				                + " color: #ff4c4c;"
				                + " font-size: 20px;"
				                + " font-weight: bold;"
				                + "}");
				        pw.println("a {"
				                + " text-decoration: none;"
				                + " color: #0077b6;"
				                + " padding: 10px 20px;"
				                + " display: inline-block;"
				                + " background-color: #00a8e8;"
				                + " border-radius: 5px;"
				                + " margin-top: 20px;"
				                + " font-size: 16px;"
				                + " color: white;"
				                + "}");
				        pw.println("a:hover {"
				                + " background-color: #0077b6;"
				                + "}");
				        pw.println("</style>");
				        
				        pw.println("</head>");
				        pw.println("<body>");
				        pw.println("<div class='message error'>");
			            pw.println("<h2 class='error'>Invalid User</h2>");
			            pw.println("<p>Please enter valid details.</p>");
			            pw.println("<a href='login.html'>Back to Login</a>");
			            pw.println("</div>");
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
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
