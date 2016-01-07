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


<body>
<div class="main_container">

    <div class="navigation">

        <div class="logo">

        </div>

        <div class="menu">

            <div id="signIn" class="option">
                Logged in as: user
            </div>
            <div id="signUp" class="option">
                <span class="glyphicon glyphicon-minus"></span>
                &nbsp;&nbsp;Log out
            </div>

        </div>

    </div>

    <div class="hello-box">
        <h1 id="topic">Hello userName Welcome to my-blog!</h1>
        <div class="sub-header">Share your thoughts around the world.</div>

        <div id="req" class="register">
            <br><br>What do you want to do now?
        </div>
        <div class="choice-table">
            <table class="choices">

                <tr>
                    <td width="33%">You can add a new note</td>
                    <td width="33%">Or edit existing ones</td>
                    <td width="33%">Or delete notes you don't want to have</td>
                </tr>
                <tr><td><br></td><td><br></td><td><br></td></tr>
                <tr>
                    <td width="33%"><a class="btn btn-default" href="/notes/addNote" role="button">Add note!</a></td>
                    <td width="33%"><a class="btn btn-default" href="/notes/editNote" role="button">Edit note!</a></td>
                    <td width="33%"><a class="btn btn-default" href="/notes/deleteNote" role="button">Delete note</a></td>
                </tr>

            </table>
        </div>

    </div>

</div>
</body>
</html>
