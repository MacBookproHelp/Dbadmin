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
                    <form class ="form-signin" name="deleteuser" action="updateUser" method="POST">
                        <input type="text" class="form-control" placeholder="Enter username, but this will not update" name="username"  />
                        <input type="text" class="form-control" placeholder="Enter Firstname to updte" name="firstname"  />
                        <input type="text" class="form-control" placeholder="Enter Last name to update" name="lastname"  />
                        <input type="text" class="form-control" placeholder="Enter email to update" name="email"  />
                         <br> <br>
                        <input type="submit" class="btn btn-primary" value="Update User" />            
                    </form>
                     <br>
                 <%
                    if(session.getAttribute("updateuser")=="success"){
                    %>
                        <div class="alert alert-success" role="alert">User updated Successfully</div>
                        <% session.removeAttribute("updateuser");}
                %>
                    <div>
                    </div>
                </div>
            </div>           
        </div>       
    </body>
</html>
