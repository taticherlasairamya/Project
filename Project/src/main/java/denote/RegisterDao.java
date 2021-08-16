package denote;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

public class RegisterDao 
{ 
     public String registerUser(Register register)
     {
         String name = register.getName();
         String password = register.getPassword();
         String email = register.getEmail();
         String phoneno = register.getPhoneno();      
         Connection con = null;
         PreparedStatement preparedStatement = null;         
         try
         {
             con = DBConnect.createConnection();
             String query = "insert into user(name,password,email,phoneno) values (?,?,?,?)";
             preparedStatement = con.prepareStatement(query);
             preparedStatement.setString(1, name);
             preparedStatement.setString(2, password);
             preparedStatement.setString(3, email);
             preparedStatement.setString(4, phoneno);                         
             int i= preparedStatement.executeUpdate();             
             if (i!=0)  
             return "SUCCESS"; 
         }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
         return "Oops.. Something went wrong there..!"; 
     }
     public String editUser(Register edit)
     {
         String name = edit.getName();
         String email = edit.getEmail();
         String phoneno = edit.getPhoneno();      
         String gender = edit.getGender();
         String dob = edit.getDob();      
         Connection con = null;
         PreparedStatement preparedStatement = null;         
         try
         {
        	 
             con = DBConnect.createConnection();
             PreparedStatement ps=con.prepareStatement(  
                     "update user set name=?,phoneno=?,gender=?,dob=? where email=?");  
             ps.setString(1,edit.getName());  
             ps.setString(2,edit.getPhoneno());  
             ps.setString(3,edit.getGender());  
             ps.setString(4,edit.getDob());  
             ps.setString(5,edit.getEmail());  
             int i= ps.executeUpdate();             
             if (i!=0)  
             return "SUCCESS"; 
         }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
         return "Oops.. Something went wrong there..!"; 
     }
 
     
}
