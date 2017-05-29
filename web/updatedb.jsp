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

            
            <form action="startdb" method ="POST">
                <input type="submit" class="btn btn-primary" value="Start DB Sync">
            </form> 
            <br>
            <%
                    if(session.getAttribute("connection")=="success"){
                    %>
                        <div class="alert alert-success" role="alert">Updated Successfully</div>
                        <% session.removeAttribute("connection");
                       }
                %>
        </div>       
    </body>
</html>
