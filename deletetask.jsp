<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ToDoList</title>
</head>

<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="mui/mui.min.css">

<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="//cdn.muicss.com/mui-0.9.9-rc1/css/mui.min.css" rel="stylesheet" type="text/css" />
<script src="//cdn.muicss.com/mui-0.9.9-rc1/js/mui.min.js"></script>

<style>
    html, body, .login {
        height: 100%;
        overflow: hidden;
    }

    h2{
        color: darkslategray;
    }

        font-size: 20px;
        background: white;
        width: 250px!important;
    }

    .mui-divider{
        width: 250px!important;
        margin-bottom: 25px!important;
    }

    .login, .register{
        z-index: 2;
        position: relative;
    }
    .btn {
        font-size: 20px;
    }

    .bkImg {
        position: fixed;
        height: 100%;
        width: 100%;
        opacity: 0.15;
        pointer-events: none;
        top: -25px;
    }
</style>


<body>
<h1>Delete task: </h1>

<BR>


<form action="/ToDoList/Controller/DeleteTask" method="post" style="text-align:center" name="search">
          <fieldset>
    	  <BR>
    	  <label>Task Name To Delete: </label>
    	  <input type="text" name="taskToDelete">
          <BR>
          <button type="submit" >Delete Task</button>
          <BR>
  		</fieldset>
      	</form>    

</html>





	