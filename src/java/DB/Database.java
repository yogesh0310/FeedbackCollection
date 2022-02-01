/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import javax.servlet.http.HttpServlet;
import java.sql.*;
import java.lang.*;
import java.util.*;
/**
 *
 * @author Yogesh
 */
public class Database extends HttpServlet {

    public static Connection connect() throws Exception
    {
        String jdbcDriver="com.mysql.jdbc.Driver";
        String dbURL="jdbc:mysql://localhost:3306/feedback_project?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String dbName="feedback_project";
        String username="root";
        String password="";
        Class.forName(jdbcDriver);
        Connection con=DriverManager.getConnection(dbURL,username,password);
        
        
        return con;
    }
}
