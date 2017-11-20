<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>My Youtube JSP Tag</TITLE>
</HEAD>


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

<BODY>
<img class="bkImg" src="http://learningworksforkids.com/wp-content/uploads/to-do-list-list-notepad.jpg">
<%@ taglib uri="/WEB-INF/tlds/mytag.tld" prefix="test" %>
<test:youtubeTag idYoutube="ibGnjSKLqTc" /> 
<br><br>
	<form action="/ToDoList/Controller/LoginAgain">
   				<button type="submit" class="mui-btn mui-btn--primary">Back To Login</button>
			</form>						
 	

</BODY>
</HTML>