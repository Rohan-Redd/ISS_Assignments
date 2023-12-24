<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Login into your Account</title>
      <link rel="stylesheet" href="style.css">
   </head>
   <body>
      <div class="wrapper">
         <div class="title">
            Login Form
         </div>
         <form action="loginForm" method="post">
            <div class="field">
               <input type="text" name="name1" required>
               <label>Name</label>
            </div>
            <div class="field">
               <input type="password" name="pass1" required>
               <label>Password</label>
            </div>
            <div class="field">
               <input type="submit" value="Login">
            </div>
            <div class="signup-link">
               Not a member? <a href="register.jsp">Register now</a>
            </div>
         </form>
      </div>
   </body>
</html>