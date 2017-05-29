/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uac.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class removedbNode extends HttpServlet {
    
    public Connection conn;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        
         int a;
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/databases;create=true","test","test");
        
        HttpSession session = request.getSession();
        
        String dbname = request.getParameter("dbname");        
        
        String query = "delete from dbtable where dbname = '"+dbname+"'";       
        
        PreparedStatement ps = conn.prepareStatement(query);              
        a = ps.executeUpdate();
        if(a==1){
             session.setAttribute("remnode", "success");
             response.sendRedirect("removedb.jsp");
        }                  
        else{
            response.sendRedirect("removedb.jsp");
            }   
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(removedbNode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(removedbNode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
