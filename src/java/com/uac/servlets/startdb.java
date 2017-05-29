/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uac.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class startdb extends HttpServlet {
    
     public Connection con1,con2,con3;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            if(syncdbs()){
                HttpSession session = request.getSession();
                session.setAttribute("connection", "success");
                System.out.println("success");
            }else{
                 System.out.println("Something wrong at db sync");
            }
          
            response.sendRedirect("updatedb.jsp");
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private boolean syncdbs() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con1 = DriverManager.getConnection("jdbc:derby://localhost:1527/gnMaster;create=true","test","test");
            con3 = DriverManager.getConnection("jdbc:derby://localhost:1527/databases;create=true","test","test");
            Statement getdbs = con3.createStatement();
            ResultSet dbSet = getdbs.executeQuery("select * from dbtable");
            while(dbSet.next()){
                    System.out.println("username is "+dbSet.getString("username"));
                    con2 = DriverManager.getConnection(dbSet.getString("url")+";create=true",dbSet.getString("username"),dbSet.getString("password"));
                    
                    Statement statement1 = con1.createStatement();
                    PreparedStatement clear = con2.prepareStatement("truncate table uacuser");
                    clear.execute();
                    PreparedStatement insertStatement = con2.prepareStatement("insert into uacuser values(?,?,?,?,?)");
                    ResultSet resultSet = statement1.executeQuery("select * from uacuser");

                        while (resultSet.next())
                        {
                            // Get the values from the table1 record
                            String uname = resultSet.getString("username");
                            String password = resultSet.getString("password");
                            String fname = resultSet.getString("firstname");
                            String lname = resultSet.getString("lastname");
                            String email = resultSet.getString("email");

                            // Insert a row with these values into table2

                            insertStatement.clearParameters();
                            insertStatement.setString(1, uname);
                            insertStatement.setString(2, password);
                            insertStatement.setString(3, fname);
                            insertStatement.setString(4, lname);
                            insertStatement.setString(5, email);
                            insertStatement.executeUpdate();
                        }
                       
             }
             return true;
            }catch (Exception e){
                 System.out.println("exception is  "+e);
                return false;
            }  
            
            
    }
    
    

    
}
