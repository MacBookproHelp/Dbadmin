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


public class addUser extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        int a;
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");   
         HttpSession session = request.getSession();
        
        String regusername = request.getParameter("regusername");
        String regpassword = request.getParameter("regpassword");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String regemail = request.getParameter("regemail");
        
        String url = "jdbc:derby://localhost:1527/graphnet;user=test;password=test";
        String query = "INSERT INTO UACUSER (username,password,firstname, lastname,email) VALUES (?,?,?,?,?)";
       
        Connection con = DriverManager.getConnection(url);
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,regusername);
        ps.setString(2,regpassword);
        ps.setString(3,firstname);
        ps.setString(4,lastname);
        ps.setString(5,regemail);
        a = ps.executeUpdate();
        if(a==1){
             session.setAttribute("add", "success");
             response.sendRedirect("adduser.jsp");
        }                  
        else{
            response.sendRedirect("adduser.jsp");
            }     
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(addUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(addUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
