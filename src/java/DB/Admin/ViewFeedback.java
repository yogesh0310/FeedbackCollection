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
public class ViewFeedback extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PrintWriter out=resp.getWriter();
        
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Feedback</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n" +
"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n" +
"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
        out.println("<style> h1{font-family:Times New Roman;} body{background-image: linear-gradient(to top, #88d3ce 0%, #6e45e2 100%); color:white;} </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1 align='center' style='color:white'>Feedback Details</h1><br><br>");;
        out.println("<form action='Feedback' method='post'>");
        out.println("<div class='form-group'>");
        out.println("<h4>Select Faculty:</h4> <select class='form-control' name='faculty'");
        try
        {
            Connection con=Database.connect();
            PreparedStatement st=con.prepareStatement("select faculty_name from faculty");
            ResultSet rs=st.executeQuery();
            while(rs.next())
            {
                String name=rs.getString(1);
                out.println("<option value='"+name+"'>"+name+"</option>");
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        out.println("</select><br>");
        out.println("</div>");
        out.println("<input type='submit' class='btn btn-success' value='Submit'>");
        out.println("</form");
        out.println("</div>");  
        out.println("</body>");
        out.println("</html>");
        
        }
        
        
    }

