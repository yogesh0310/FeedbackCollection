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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author Yogesh
 */
public class SubmitFeedback extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PrintWriter out=resp.getWriter();
        
        try
        {
            Connection con=Database.connect();
            PreparedStatement st=con.prepareStatement("insert into feedback values(?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, req.getParameter("faculty"));
            st.setString(2, req.getParameter("sub"));
            st.setString(3, req.getParameter("q1"));
            st.setString(4, req.getParameter("q2"));
            st.setString(5, req.getParameter("q3"));
            st.setString(6, req.getParameter("q4"));
            st.setString(7, req.getParameter("q5"));
            st.setString(8, req.getParameter("q6"));
            st.setString(9, req.getParameter("q7"));
            st.setString(10, req.getParameter("q8"));
            st.setString(11, req.getParameter("q9"));
            int i=st.executeUpdate();
            if(i>0)
            {
                out.println("<html>");
                out.println("<body>");
                out.println("<h1 style='margin-left:auto;margin-right:auto;'>Feedback Submitted Successfully</h1>");
                out.println("</body>");
                out.println("</html");
                out.println("<p><a href=\"studentDash.html\">Return" + "</a> to main page</p>");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
}
