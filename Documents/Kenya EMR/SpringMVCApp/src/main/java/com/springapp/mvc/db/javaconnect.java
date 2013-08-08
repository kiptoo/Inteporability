package com.springapp.mvc.db;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kip
 */

//import java.sql.Connection;
import java.sql.*;
    

public class javaconnect {

   Connection conn=null;
    
    public static Connection connecrDb()
    {
     
                try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            System.out.println("Driver loaded");
            
         Connection conn;
                    //conn= DriverManager.getConnection("jdbc:mysql:project.sql");
                    conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/openmrs", "root", "kipchir");

                System.out.println("Database loaded");
             return conn;   
        } catch (SQLException e) {
            System.out.println("SQL Exception: "+ e.toString());
        } catch (ClassNotFoundException cE) {
            System.out.println("Class Not Found Exception: "+ cE.toString());
        }
                
     return null;
        
    }
    
}
