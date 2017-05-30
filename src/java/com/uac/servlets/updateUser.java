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


public class updateUser extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        int a;
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");   
         HttpSession session = request.getSession();
        
        String regusername = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String regemail = request.getParameter("email");
        
        String url = "jdbc:derby://localhost:1527/graphnet;user=test;password=test";
        String query = "UPDATE UACUSER SET firstname=?, lastname=?, email=? WHERE username=?";
       
        Connection con = DriverManager.getConnection(url);
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,firstname);
        ps.setString(2,lastname);
        ps.setString(3,regemail);
        ps.setString(4,regusername);
       
        a = ps.executeUpdate();
        if(a==1){
             session.setAttribute("updateuser", "success");
             response.sendRedirect("updateuser.jsp");
        }                  
        else{
            response.sendRedirect("updateuser.jsp");
            }     
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(updateUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updateUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
