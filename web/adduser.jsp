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
           <form name="register" action="addUser" method="POST">
            <table  align="center">
                <tbody>
                    
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="firstname"  /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lastname"  /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="regemail"  /></td>
                    </tr>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="regusername"  /></td>
                    </tr>
                    
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="regpassword" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Register" /></td>                        
                    </tr>    
                </tbody>
            </table>

        </form>
                    <br>
            <%
                    if(session.getAttribute("add")=="success"){
                    %>
                        <div class="alert alert-success" role="alert">User Created Successfully</div>
                        <% session.removeAttribute("add");}
                %>
                    <div>
                    </div>
                </div>
            </div>            
        </div>       
    </body>
</html>
