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
            con1 = DriverManager.getConnection("jdbc:derby://localhost:1527/graphnet;create=true","test","test");
            con3 = DriverManager.getConnection("jdbc:derby://localhost:1527/databases;create=true","test","test");
            Statement getdbs = con3.createStatement();
            ResultSet dbSet = getdbs.executeQuery("select * from dbtable");
            while(dbSet.next()){
                    
                    con2 = DriverManager.getConnection(dbSet.getString("url")+";create=true",dbSet.getString("username"),dbSet.getString("password"));
                    
                    Statement statement1 = con1.createStatement();
                    PreparedStatement clear1 = con2.prepareStatement("truncate table uacuser");
                    PreparedStatement clear2 = con2.prepareStatement("truncate table graph");
                    PreparedStatement clear3 = con2.prepareStatement("truncate table edge");
                    PreparedStatement clear4 = con2.prepareStatement("truncate table node");
                    
                    clear1.execute();
                    clear2.execute();
                    clear3.execute();
                    clear4.execute();
                  
                   
                    PreparedStatement insertStatement1 = con2.prepareStatement("insert into uacuser values(?,?,?,?,?,?)");
                    PreparedStatement insertStatement2 = con2.prepareStatement("insert into graph values(?,?,?,?,?,?,?)");
                    PreparedStatement insertStatement3 = con2.prepareStatement("insert into edge values(?,?,?,?)");
                    PreparedStatement insertStatement4 = con2.prepareStatement("insert into node values(?,?)");
                    
                    ResultSet resultSet1 = statement1.executeQuery("select * from uacuser");
                   
                    
                   

                        while (resultSet1.next())
                        {
                            // Get the values from the table1 record
                            String uname = resultSet1.getString("username");
                            String fname = resultSet1.getString("firstname");
                            String lname = resultSet1.getString("lastname");
                            String utype = resultSet1.getString("usertype");
                            String email = resultSet1.getString("email");
                            String password = resultSet1.getString("password");
                             
                            // Insert a row with these values into table2

                            insertStatement1.clearParameters();
                            insertStatement1.setString(1, uname);
                            insertStatement1.setString(2, fname);
                            insertStatement1.setString(3, lname);
                            insertStatement1.setString(4, utype);
                            insertStatement1.setString(5, email);
                            insertStatement1.setString(6, password);
                            insertStatement1.executeUpdate();
                        }
                        
                        ResultSet resultSet2 = statement1.executeQuery("select * from graph");
                        while (resultSet2.next())
                        {
                            // Get the values from the table1 record
                            String gname = resultSet2.getString("graphname");
                            String descr = resultSet2.getString("description");
                            String tnodes = resultSet2.getString("totalnodes");
                            String tedges = resultSet2.getString("totaledges");
                            String size = resultSet2.getString("gsize");
                            String weight = resultSet2.getString("weighted");
                            String usr = resultSet2.getString("usrname");

                            // Insert a row with these values into table2

                            insertStatement2.clearParameters();
                            insertStatement2.setString(1, gname);
                            insertStatement2.setString(2, descr);
                            insertStatement2.setString(3, tnodes);
                            insertStatement2.setString(4, tedges);
                            insertStatement2.setString(5, size);
                            insertStatement2.setString(6, weight);
                            insertStatement2.setString(7, usr);
                            insertStatement2.executeUpdate();
                        }
                        
                        ResultSet resultSet3 = statement1.executeQuery("select * from edge");
                        while (resultSet3.next())
                        {
                            // Get the values from the table1 record
                            String edge = resultSet3.getString("edgeid");
                            String lnode = resultSet3.getString("leftnode");
                            String rnode = resultSet3.getString("rightnode");
                            String grp = resultSet3.getString("grname");
                            

                            // Insert a row with these values into table2

                            insertStatement3.clearParameters();
                            insertStatement3.setString(1, edge);
                            insertStatement3.setString(2, lnode);
                            insertStatement3.setString(3, rnode);
                            insertStatement3.setString(4, grp);                            
                            insertStatement3.executeUpdate();
                        }
                        
                         ResultSet resultSet4 = statement1.executeQuery("select * from node");
                         while (resultSet4.next())
                        {
                            // Get the values from the table1 record
                            String nodeid = resultSet4.getString("nodeid");
                            String gpname = resultSet4.getString("gpname");
                           
                            // Insert a row with these values into table2

                            insertStatement4.clearParameters();
                            insertStatement4.setString(1, nodeid);
                            insertStatement4.setString(2, gpname);                                               
                            insertStatement4.executeUpdate();
                        }                  
                        
                       
             }
             return true;
            }catch (Exception e){
                 System.out.println("exception is  "+e);
                return false;
            }  
            
            
    }
    
    

    
}
