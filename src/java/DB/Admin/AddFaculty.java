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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 *
 * @author Yogesh
 */
public class AddFaculty extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        PrintWriter out=response.getWriter();
        HttpSession session = request.getSession(true);
        try
        {
            Connection con=Database.connect();
            PreparedStatement st = con.prepareStatement("insert into faculty values(?,?,?)");
            st.setString(1,request.getParameter("fid"));
            st.setString(2,request.getParameter("fname"));
            st.setString(3,request.getParameter("fdept"));
            int i=st.executeUpdate();
            if(i >= 1)
            {
                out.println("<html>");
                out.println("<body>");
                out.println("<h1 style='margin-left:auto;margin-right:auto;'>Facutly Added Successfully</h1>");
                out.println("</body>");
                out.println("</html");
                out.println("<p><a href=\"adminDash.html\">Return" + "</a> to main page</p>");
            }
            else
            {
                out.println("<html>");
                out.println("<body>");
                out.println("<h1 style='margin-left:auto;margin-right:auto;'>Please check the details and add again.</h1>");
                out.println("</body>");
                out.println("</html");
                out.println("<p><a href=\"addFaculty.html\">Return" + "</a> to main page</p>");
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
    
    
}
