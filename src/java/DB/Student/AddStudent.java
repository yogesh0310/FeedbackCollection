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
public class AddStudent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        try
        {
            Connection con=Database.connect();
            PreparedStatement st = con.prepareStatement("insert into users values(?,?,?,?,?)");
            st.setString(1,req.getParameter("uname"));
            st.setString(2,req.getParameter("uemail"));
            st.setString(3,req.getParameter("udept"));
            st.setString(4,req.getParameter("username"));
            st.setString(5,req.getParameter("pass"));
            st.executeUpdate();
            out.println("<html>");
            out.println("<body>");
            out.println("<h1 style='margin-left:auto;margin-right:auto;'>Student Successfully Added</h1>");
            out.println("</body>");
            out.println("</html");
            out.println("<p><a href=\"student.html\">Return" + "</a> to login page</p>");   
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
}
