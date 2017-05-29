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
                    <form class ="form-signin" name="registerdb" action="removedbNode" method="POST">
                        <input type="text" class="form-control" placeholder="Enter your db node name" name="dbname"  />
                         <br> <br>
                        <input type="submit" class="btn btn-primary" value="Remove" />            
                    </form>
                     <br>
                 <%
                    if(session.getAttribute("remnode")=="success"){
                    %>
                        <div class="alert alert-success" role="alert">DB removed Successfully</div>
                        <% session.removeAttribute("remnode");}
                %>
                    <div>
                    </div>
                </div>
            </div>            
        </div>       
    </body>
</html>

