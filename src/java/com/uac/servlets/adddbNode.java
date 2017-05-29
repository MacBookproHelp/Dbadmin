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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Teja
 */
public class adddbNode extends HttpServlet {

    public Connection conn;
      
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        
        int a;
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/databases;create=true","test","test");
        
        HttpSession session = request.getSession();
        
        String dbname = request.getParameter("dbname");
        String url = request.getParameter("url");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        String query = "INSERT INTO DBTABLE (dbname,url,username, password) VALUES (?,?,?,?)";       
        
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1,dbname);
        ps.setString(2,url);
        ps.setString(3,username);
        ps.setString(4,password);
        
        a = ps.executeUpdate();
        if(a==1){
             session.setAttribute("addnode", "success");
             response.sendRedirect("registerdb.jsp");
        }                  
        else{
            response.sendRedirect("registerdb.jsp");
            }     
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          try {
              processRequest(request, response);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(adddbNode.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(adddbNode.class.getName()).log(Level.SEVERE, null, ex);
          }
    }

  
}
