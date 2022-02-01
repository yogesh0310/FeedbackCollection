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
public class Feedback extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PrintWriter out=resp.getWriter();
        String s=req.getParameter("faculty");
        try
        {
            Connection con=Database.connect();
            PreparedStatement st=con.prepareStatement("select * from feedback where faculty=?");
            st.setString(1,s);
            ResultSet rs=st.executeQuery();
            out.println("<html>");
            out.println("<body>");
            out.println("<title>Feedback</title>\n" +
"        <meta charset=\"UTF-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n" +
"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n" +
"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
            out.println("<style>h1{font-family:Times New Roman;} body{background-image: linear-gradient(-20deg, #ddd6f3 0%, #faaca8 100%, #faaca8 100%);} </style>");
            out.println("<h1 style='color:White; text-align:center;'>Feedback Details</h1>");
            out.println("<div class='container'>");
            out.println("<table class='table table-bordered'>");
            out.println("<thead class='thead-dark'><tr><th scope='col'>Faculty Name</th><th scope='col'>Subject</th><th scope='col'>Were objectives clear to you?:</th><th scope='col'>How do you rate the content of the course?</th><th scope='col'>Are the course contents met with your expectations?</th><th scope='col'>The content sequence was well planned.</th><th scope='col'>The course exposed you to new knowledge, skills and practices.</th><th scope='col'>The course material handed out was adequate.</th><th scope='col'>Percentage coverage of the course Syllabus in the class.</th><th scope='col'>Overall Experience with Assessment and Evaluation</th><th scope='col'>Overall satisfaction of the course content, conduction and assessment.</th></tr></thead>");
            while(rs.next())
            {              
                String fName=rs.getString(1);
                String sub=rs.getString(2);
                String q1=rs.getString(3);
                String q2=rs.getString(4);
                String q3=rs.getString(5);
                String q4=rs.getString(6);
                String q5=rs.getString(7);
                String q6=rs.getString(8);
                String q7=rs.getString(9);
                String q8=rs.getString(10);
                String q9=rs.getString(11);
                out.println("<tr><td>" + fName+ "</td><td>" + sub + "</td><td>" + q1 + "</td><td>"+q2+"</td><td>"+q3+"</td><td>"+q4+"</td><td>"+q5+"</td><td>"+q6+"</td><td>"+q7+"</td><td>"+q8+"</td><td>"+q9+"</td><tr>");   
                
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
