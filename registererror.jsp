<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="mui/mui.min.css">

<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="//cdn.muicss.com/mui-0.9.9-rc1/css/mui.min.css" rel="stylesheet" type="text/css" />
<script src="//cdn.muicss.com/mui-0.9.9-rc1/js/mui.min.js"></script>
<title>Login Error</title>
</head>
<body>

<br><br><br><br><br>
			<div class="alert alert-danger" role="alert">
  			<strong>Please choose another user name</strong>, and then retry register again</div>
			
			
			  <form class="navbar-form navbar-left" action="/ToDoList/Controller/LoginAgain" method="post">
                        <button type="submit" class="btn btn-default">Register again</button>
             </form>

</body>
</html>