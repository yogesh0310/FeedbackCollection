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
import javax.servlet.http.HttpSession;
/**
*
* @author Yogesh
*/
public
class AdminLogin extends HttpServlet {

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    String login = request.getParameter("login");  
    String pass = request.getParameter("pass");
    
    String uname="admin",upass="admin";
    
    if(login.equals(uname) && pass.equals(upass))
    {
        HttpSession session = request.getSession(true);
        session.setAttribute("uname", uname);
        session.setAttribute("upass", upass);
        response.sendRedirect("adminDash.html");
    }
        
    else
    {
        out.println("<h3 style='color:red;'>Login FAILED!<br>");
//        String newURL = response.encodeURL("GetSession"); 
        out.println("Click <a href='admin.html'>here</a> for login page<br> ");
        out.println("Click <a href='index.html'>here</a> for main page<br> ");
    }
        
        

}


}
