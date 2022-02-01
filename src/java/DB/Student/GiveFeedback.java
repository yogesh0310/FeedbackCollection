/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.Student;

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
public class GiveFeedback extends HttpServlet {

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
        out.println("<style> h1{font-family:Times New Roman;} body{background-color: #FFDEE9;\n" +
"background-image: linear-gradient(0deg, #FFDEE9 0%, #B5FFFC 100%);} </style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1 align='center' style='color:red'>Feedback Form</h1><br><br>");
        out.println("<form action='SubmitFeedback' method='post'>");
        out.println("<div class='form-group'>");
        out.println("<h4>Select Faculty:</h4> <select class='form-control' name='faculty'");
        out.println("");
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
        out.println("<h4>Enter Subject Name:</h4>");
        out.println("<input type='text' class='form-control' placeholder='Subject Name' name='sub' required><br>");
        out.println("<h4>Were objectives clear to you?:</h4>");
        out.println("<input type='text' class='form-control' placeholder='Completely/Partially/Not Clear' name='q1' required><br>");
        out.println("<h4>How do you rate the content of the course?</h4>");
        out.println("<input type='text' class='form-control' placeholder='Excellent/Very Good/Moderate/Satisfactory' name='q2' required><br>");
        out.println("<h4>Are the course contents met with your expectations?</h4>");
        out.println("<input type='text' class='form-control' placeholder='Strongly Agree/Agree/Disagree' name='q3' required><br>");
        out.println("<h4>The content sequence was well planned.</h4>");
        out.println("<input type='text' class='form-control' placeholder='Strongly Agree/Agree/Disagree' name='q4' required><br>");
        out.println("<h4>The course exposed you to new knowledge, skills and practices.</h4>");
        out.println("<input type='text' class='form-control' placeholder='Strongly Agree/Agree/Disagree' name='q5' required><br>");
        out.println("<h4>The course material handed out was adequate.</h4>");
        out.println("<input type='text' class='form-control' placeholder='Strongly Agree/Agree/Disagree' name='q6' required><br>");
        out.println("<h4>Percentage coverage of the course Syllabus in the class.</h4>");
        out.println("<input type='text' class='form-control' placeholder='30% to 100%' name='q7' required><br>");
        out.println("<h4>Overall Experience with Assessment and Evaluation</h4>");
        out.println("<input type='text' class='form-control' placeholder='Excellent/Very Good/Moderate/Satisfactory' name='q8' required><br>");
        out.println("<h4>Overall satisfaction of the course content, conduction and assessment.</h4>");
        out.println("<input type='text' class='form-control' placeholder='Scale of (1-5)' name='q9' required><br>");
        out.println("<input type='submit' class='btn btn-success' value='Submit'>");
        out.println("</form");
        out.println("</div>");  
        out.println("</body>");
        out.println("</html>");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
//        out.println("");
       
    }

    
    
}
