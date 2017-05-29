<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Admin Console</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title> GraphNet DB admin</title>
        <%@include file="headers/header.jsp" %>
    </head>
    <body>     
        <div class="jumbotron">

            <!-- Main component for a primary marketing message or call to action -->

            <div class="container">
                <div class="row">
                    <form name="registerdb" action="adddbNode" method="POST">
            <table  align="center">
                <tbody>
                    
                    <tr>
                        <td>DB Name</td>
                        <td><input type="text" name="dbname"  /></td>
                    </tr>
                
                    <tr>
                        <td>DB URL</td>
                        <td><input type="text" name="url"  /></td>
                    </tr>
                
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="username"  /></td>
                    </tr>
                   
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password"  /></td>
                    </tr>
                  
                    <tr>
                        <td colspan="2" align="center"><input type="submit" class="btn btn-primary" value="Register" /></td>                        
                    </tr>    
                </tbody>
            </table>

        </form>
                     <br>
            <%
                    if(session.getAttribute("addnode")=="success"){
                    %>
                        <div class="alert alert-success" role="alert">Node registered Successfully</div>
                        <% session.removeAttribute("addnode");}
                %>
                    <div>
                    </div>
                </div>
            </div>            
        </div>       
    </body>
</html>

