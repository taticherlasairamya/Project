package denote;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
 
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
   
    //PrintWriter out = response.getWriter();
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    
    Connection con = null;
    try {
      
    	 con = DBConnect.createConnection();
    	Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select email,password from user where email='"+email+"' and password='"+password+"'");
      
      if(rs.next()) {
        response.sendRedirect("HomePage.jsp");
        String Email = rs.getString("email");
       HttpSession session = request.getSession();
       session.setAttribute("email", Email);
        
        
      }else {
        response.sendRedirect("LoginError.jsp");
      }
      
      
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
    
  }
}
