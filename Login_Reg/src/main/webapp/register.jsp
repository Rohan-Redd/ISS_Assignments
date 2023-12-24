<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Registration for New Users</title>
      <link rel="stylesheet" href="style.css">
   </head>
   <body>
      <div class="wrapper">
         <div class="title">
            Registration Form
         </div>
         <form action="regForm" method="post">
            <div class="field">
               <input type="text" name="name0" required>
               <label>Name</label>
            </div>
            <div class="field">
               <input type="text" name="mail0" required>
               <label>Email Address</label>
            </div>
            <div class="field">
               <input type="password" name="pass0" required>
               <label>New Password</label>
            </div>
            <div class="field">
               <input type="submit" value="Register">
            </div>
         </form>
      </div>
   </body>
</html>

