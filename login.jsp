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

    <img class="bkImg" src="http://learningworksforkids.com/wp-content/uploads/to-do-list-list-notepad.jpg">

		<form action="/ToDoList/Controller/Youtube">
		<br>
		<button type="submit" class="mui-btn mui-btn--primary">What is ToDo List</button>
		</form>
    <div class="login" align="center" style="margin-top: 250px; position: relative;" >
		

		
		<form action="/ToDoList/Controller/Login" method="post">
        <h2>Please Login</h2>
        <div class="mui-divider"></div>

        <div class="mui-textfield mui-textfield--float-label" style="width: 33%;">
            <input type="text" name="userName">
            <label>User Name</label>
        </div>

        <div class="mui-textfield mui-textfield--float-label" style="width: 33%;">
            <input type="password" name="password">
            <label>Password</label>
        </div>


        <br/> <br/>
        <button type="submit" class="mui-btn mui-btn--primary" onclick="login()">Login</button>
        <button type="button" class="mui-btn mui-btn--primary" onclick="showRegister()">Register Now</button>
        
		</form>

    </div>
    <div class="register" align="center" style="padding-top: 37vh;">
    
    <form action="/ToDoList/Controller/Register" method="post">

        <h2>Please Register</h2>

        <div class="mui-divider"></div>


        <div class="mui-textfield mui-textfield--float-label" style="width: 33%;">
            <input type="text" name="userName">
            <label>User Name</label>
        </div>


        <div class="mui-textfield mui-textfield--float-label" style="width: 33%;">
            <input type="email" name="email">
            <label>User Email</label>
        </div>


        <div class="mui-textfield mui-textfield--float-label" style="width: 33%;">
            <input type="password" name="password">
            <label>Password</label>	
        </div>


        <div class="mui-textfield mui-textfield--float-label" style="width: 33%;">
            <input type="password" name="repassword">
            <label>Re-Enter Password</label>
        </div>

        <br/> <br/>
        <button type="submit" class="mui-btn mui-btn--primary" " >Register</button>
        <button type="button" class="mui-btn mui-btn--primary" onclick="showLogin()">Login Now</button>
        
        </form>

    </div>

</body>

<script>


    function register(){
    }

    function login() {
        $('.alert-success').animate({'opacity': 1}, 400);

        setTimeout(function () {
            $('.alert-success').animate({'opacity': 0}, 400);
        }, 2000);
    }

    function showRegister() {
        $('.login').animate({'margin-top': '-900px'}, 400);
    }
    function showLogin() {
        $('.login').animate({'margin-top': '250px'}, 400);
    }

    
    
    </script>

</html>





	