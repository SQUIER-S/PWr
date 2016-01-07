<%--
  Created by IntelliJ IDEA.
  User: SQUIER
  Date: 2015-12-04
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-2" pageEncoding="ISO-8859-2"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<link>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>my-blog</title>
    <link href="<c:url value='/static/css/home.css' />" rel="stylesheet" >
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

    <script>
        $(document).ready(function(){
            $("#signIn").click(function(){
                $("#loginForm").slideToggle("fast");
            });
        });
        $(document).ready(function(){
            $("#signUp").click(function(){
                $("#req").hide();
                $("#registrationForm").show();
            });
        });
    </script>
<body>
<div class="main_container">

    <div class="navigation">

        <div class="logo">

        </div>

        <div class="menu">

            <div id="signIn" class="option">
                <span class="glyphicon glyphicon-user"></span>
                &nbsp;&nbsp;Sign In
            </div>
            <div id="signUp" class="option">
                <span class="glyphicon glyphicon-plus"></span>
                &nbsp;&nbsp;Sign Up
            </div>

        </div>

    </div>

    <div id="loginForm">

        <form:form action="/login" method="post">
            <div class="form-group">
                <input name="uLogin" type="text" class="form-control" id="uLogin" placeholder="login">
            </div>
            <div class="form-group">
                <input name="uPass" type="password" class="form-control" id="uPass" placeholder="password">
            </div>
            <button type="submit" class="btn btn-default">Login</button>
        </form:form>

    </div>

    <div class="hello-box">
        <h1 id="topic">Hello! Welcome to my-blog!</h1>
        <div class="sub-header">Share your thoughts around the world.</div>

        <div id="req" class="register">
            <br><br>All you need to do to get started is registration!
        </div>
        <div id="registrationForm">
            <form:form action="/register_new_user" modelAtribute="regForm" method="post">
                <div class="form-group">
                    <table class="regTable">
                        <tr>
                            <td width="50%">Select your login: </td>
                            <td width="50%"><input name="login" type="text" class="form-control" id="login" placeholder="User Name"/></td>
                        </tr>
                    </table>
                </div>
                <div class="form-group">
                    <table class="regTable">
                        <tr>
                            <td width="50%">Your e-mail address: </td>
                            <td width="50%"><input name="email" type="email" class="form-control" id="userEmail" placeholder="Email"/></td>
                        </tr>
                    </table>
                </div>
                <div class="form-group">
                    <table class="regTable">
                        <tr>
                            <td width="50%">Select your password: </td>
                            <td width="50%"><input name="password" type="password" class="form-control" id="password" placeholder="Password"/></td>
                        </tr>
                    </table>
                </div>
                <div class="form-group">
                    <table class="regTable">
                        <tr>
                            <td width="50%">Repeat your password: </td>
                            <td width="50%"><input name="rPassword" type="password" class="form-control" id="repeatedPassword" placeholder="Repeat password"/></td>
                        </tr>
                    </table>
                </div>
                <table class="regTable">
                    <tr>
                        <td width="100%" style="text-align: center">
                            <button type="submit" class="btn btn-default">REGISTER</button></td>
                    </tr>
                </table>

            </form:form>
        </div>
    </div>

</div>
</body>
</html>
