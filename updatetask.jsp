<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

    h2 {
        color: darkslategray;
    }

    .mui-divider {
        width: 250px !important;
        margin-bottom: 25px !important;
    }

    .login, .register {
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


<body style="width: 350px; margin-left: calc(50% - 175px); margin-top: 110px">

<h3 align="center">Update Task</h3>

<form action="/ToDoList/Controller/UpdateingTask" method="post" style="text-align:center" name="search">
    <fieldset>


        <div class="mui-textfield mui-textfield--float-label">
            <label>Old Task Name</label>
            <input type="text" name="oldTaskName">
        </div>    
        <div class="mui-textfield mui-textfield--float-label">
            <input type="text" name="newTaskName">
            <label>New Task Name</label>
        </div>

        <div class="mui-select">
            <select name="Priority">
                <option>Low</option>
                <option>Medium</option>
                <option>High</option>
            </select>
            <label>Select Priority</label>
        </div>

        <div class="mui-textfield mui-textfield--float-label">
            <input type="Date" name="Date">
            <label>Date</label>
        </div>

        <div class="mui-select">
            <select name="Status">
                <option>Todo</option>
                <option>InProgress</option>
                <option>Impediment</option>
                <option>Done</option>
            </select>
            <label>Status</label>
        </div>

        <div class="mui-textfield">
            <textarea placeholder="Note" name="Note"></textarea>
        </div>

        <button type="submit" class="mui-btn mui-btn--raised">Update Task</button>

    </fieldset>
</form>




</html>





