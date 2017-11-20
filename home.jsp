<%@ page import="java.util.ArrayList" import="il.hit.model.User"  import="java.util.List" import="il.hit.model.Items" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
List<Items> list = new ArrayList<Items>();
 list = (List<Items>)session.getAttribute("allDoList");
 %>
 
<html lang="en">
<head>


<script>
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>


  <title>To Do List</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></script>
   <script src="https://cdn.datatables.net/1.10.13/css/dataTables.bootstrap.min.css"></script>
   
   
   <script src="https://code.jquery.com/jquery-1.12.4.js"></script> 
   <script src="https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script> 
   <script src="https://cdn.datatables.net/1.10.13/js/dataTables.bootstrap.min.js"></script>


</head>
<body>


<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">To Do List</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">


            <form class="navbar-form navbar-left" action="/ToDoList/Controller/UpdateTask" method="post" style="text-align:center"
                  name="search">
                <button type="submit" class="btn btn-default">Update Task</button>
            </form>

            <form class="navbar-form navbar-left" action="AddTask" method="post" style="text-align:center"
                  name="search">
                <button type="submit" class="btn btn-default">Add Task</button>
            </form>


            <ul class="nav navbar-nav navbar-right">
                <li>
                    <form class="navbar-form navbar-left" action="Logout" method="post">
                        <button type="submit" class="btn btn-default">Logout</button>
                    </form>
                </li>

            </ul>
        </div>
    </div>
</nav>

      	
<div class="container">
  <h1>To Do List</h1>
  <h2>Hello ${name} , manage your tasks simply!</h2>

  <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
      <tr>
      	<th>ID</th>
      	<th>Task Name</th>
      	<th>User Name</th>
      	<th>Status</th>
        <th>Priority</th>
        <th>Date</th>
        <th>Note</th>
        <th>Actions</th>   
      </tr>
    </thead>
    <tbody>
    
      
    <%
    
	int mone=1;
    for(int j=0;j<list.size();j++){	
    %>
    
    
    
    <tr class="<%= 
    
    		list.get(j).getPriority().equals("High")? "danger":
    		(list.get(j).getPriority().equals("Medium")? "warning": 
    		(list.get(j).getPriority().equals("Low")? "success": ""))
    %> ">
    		<th><%=mone %></th>
    		
    		<%
    		mone++;
    		 
    		  %> <th><%= list.get(j).getItemName() %> </th><% 
              %> <th><%= list.get(j).getUserName() %> </th><%
              %> <th><%= list.get(j).getStatus() %> </th><%
              %> <th><%= list.get(j).getPriority() %> </th><%
              %> <th><%= list.get(j).getDueDate() %> </th><%       
          	  %> <th><%= list.get(j).getNote() %> </th>
           
				<th>
                <div class="btn-group">
                    <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                        <span class="caret"></span>
                        <span class="sr-only">Toggle Dropdown</span>
                    </button>
                    <ul class="dropdown-menu">																											
                        <li><a href="/ToDoList/Controller/Home" onclick="$.post('/ToDoList/Controller/Delete',{taskToDelete : '<%= list.get(j).getItemName() %>'}, function(){document.location.reload()})">Delete Task</a></li>
                    </ul>
                </div>
            	</th>
	
    			</tr>
	<% } %>
    
    
       </tbody>
  </table>
</div>



 
</body>
</html>