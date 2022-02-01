/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.Admin;

import DB.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author Yogesh
 */
public class ViewStudents extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        
        try
        {
            Connection con=Database.connect();
            PreparedStatement st = con.prepareStatement("select * from users");
            ResultSet rs=st.executeQuery();
            out.println("<html>");
            out.println("<body>");
            out.println("<title>Feedback</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n" +
"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n" +
"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
            out.println("<style> body{background-image: linear-gradient(to top, #9795f0 0%, #fbc8d4 100%);} </style>");
            out.println("<h1 style='color:white; font-family:Times New Roman; text-align:center;'>Student Details</h1>");
            out.println("<div class='container'>");
            out.println("<table class='table table-bordered'>");
            out.println("<thead class='thead-dark'><tr><th scope='col'>Student Name</th><th scope='col'>Email</th><th scope='col'>Department</th></thead>");
            while(rs.next())
            {              
                
                String fID=rs.getString(1);
                String fName=rs.getString(2);
                String fDept=rs.getString(3);
                out.println("<tr><td>" + fID + "</td><td>" + fName + "</td><td>" + fDept + "</td><tr>");   
                
            }
            
            out.println("</table>");
            out.println("</div>");
            out.println("</body>");
            out.println("<p><a href=\"adminDash.html\">Return" + "</a> to main page</p>");   
            out.println("</html");
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    
}
