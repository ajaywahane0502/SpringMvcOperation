<%-- 
    Document   : Form
    Created on : 6 Apr, 2019, 1:15:45 AM
    Author     : Priti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="assets/form.css" rel="stylesheet">
    </head>
    <body>
       <div id="login">
        <h3 class="text-center text-white pt-5">Form</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="form" method="post" enctype="multipart/form-data">
                            <!--<h3 class="text-center text-info">Login</h3>-->
                            <div class="form-group">
                                <label for="username" class="text-info">Username:</label><br>
                                <input type="text" name="username" id="username" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="email" class="text-info">Email:</label><br>
                                <input type="text" name="email" id="email" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="password" name="password" id="password" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="confirmpassword" class="text-info">Confirm Password:</label><br>
                                <input type="password" name="confirmpassword" id="confirmpassword" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="securityquestion" class="text-info">Security Question</label><br>
                                <select name="securityquestion">
                                    <option class="header">Security Question</option>
                                    <option value="What is your nick name?">What is your nick name?</option>
                                    <option value="What is your favourite color?">What is your favourite color?</option>
                                    <option value="Who is your best friend?">Who is your best Friend?</option>
                                </select><br><br>
                                <input type="text" name="answer" id="answer" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="photo" class="text-info">Photo:</label><br>
                                <input type="file" name="photo" id="photo" class="form-control">
                            </div>
                            
                            <div  class="form-group">
                                <input type="submit" name="btnSubmit" value="SUBMIT">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>
