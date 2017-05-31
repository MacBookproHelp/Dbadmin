# Dbadmin
=====================================================
GraphNet project
=====================================================
This repository contains the project GraphNet developed using java EE 
We are using Netbeans for developing this environment
——————————————


Requirements
————————
Glass fish Server 4.1.2
Netbeans 8.2


Start the Project and clone the dbadmin and Projectantwerp from repository 

https://github.com/MacBookproHelp/GraphNet
https://github.com/MacBookproHelp/Dbadmin

For the database run the SQL.txt file for graphNet , gnSlave, gnMaster, Databases, you will eventually see UAC table, Edge,graph,prop,node in all the databases

First check if the pool connection is set for the graphnet and if not right click on the server and open the admin console and in JDBC Resources create pool name as graph and create the connection using JNDI give jdbc/graphnet and then in property add column User and Password, Both have same password test and then just have 5 rows port number,User,Password,database name -> graphnet
, Servername ->localhost.

Now its all set to start the project since graphnet and projectantwerp both are decoupled so run the graphnet first and then a web browser opens and login with exiting user or register 

under the tab graph there are lots of things like import graph create graph and delete graph, View graph 
for import graph a sample file (.graph) is available and you can upload it and see the graph uploaded.

under the tab create graph you have an option of creating your own graph by clicking on the following description given there we can follow it to create a beautiful graph and then download it or save it in your computer by clicking save button and running the algorithm it will be also available in the dashboard.

You have a Dashboard tab and Credits tab to explain something about this project.
there is also possibility to add, remove, delete, modify edges and nodes for create graph and import graph.

You can get the size of the graph(node and edge) in the table of graphnet.
——————————————
Dbadmin
——————————————

Right click on Dbadmin and run the project and you see an admin page available and you can add the user by clicking on the manage user tab and you will be seeing AddUser, Update User, Delete User
You can now Register the Node and Remove the node and sync the database by using Sync DB. In the Register node you follow the URL format as jdbc:derby://192.168.1.6:1527/gnSlave. Probably replace the port and host with the other slaves.
