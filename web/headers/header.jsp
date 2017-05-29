<%-- 
    Document   : header.jsp
    Created on : Apr 8, 2017, 2:48:17 PM
    Author     : Keerthana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="resources/css/bootstrapà-theme.min.css" rel="stylesheet">
        <link href="resources/css/signin.css" rel="stylesheet">
	<nav	class="navbar navbar-default"	role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="index.jsp">
					<img class="img" src="resources/images/ua.png" alt="lion" style="width:105px;height:32px">
				</a>
				<a	class="navbar-brand" href="index.jsp">GraphNet Application</a>
				<button	type="button"	class="navbar-toggle collapsed"	data-toggle="collapse"	data-target="#autonavbar" aria-expanded="false"	aria-controls="navbar">
					<span class="sr-only">Toggle Navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				
			</div>
			<div id="autonavbar" class="navbar-collapse	collapse">
				<ul class="nav navbar-nav">
					<li	class=""><a href="index.jsp" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span> Dashboard <span class="caret"></span></a>
                                         <ul class="dropdown-menu">
                                                <li><a href="registerdb.jsp">Register Node</a></li>
                                                <li><a href="removedb.jsp">Remove Node</a></li>
                                                <li><a href="updatedb.jsp">Sync DB</a></li>                                                
                                            </ul>
                                            
					<li	class=""><a href="" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <span class="glyphicon glyphicon-pushpin" aria-hidden="true"></span> Manage Users<span class="caret"></span></a>
                                            <ul class="dropdown-menu">
                                                <li><a href="adduser.jsp">Add User</a></li>
                                                <li><a href="updateuser.jsp">Update User</a></li>
                                                <li><a href="deleteuser.jsp">Delete User</a></li>                                                
                                            </ul>
                                        </li>
                                        <li	class=""><a href="credits.jsp"> <span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> Credits</a></li>
				</ul>
                        </div>
		</div>
	</nav>      
    </head>
    <body>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="resources/js/bootstrap.min.js"></script>        
    </body>
</html>
