<%-- 
    Document   : DisplayImg
    Created on : 6 Apr, 2019, 11:36:44 AM
    Author     : Priti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Image Page</title>
    </head>
    <body>
        <br>
        
        <form method="post" action="UpdatePhoto" enctype="multipart/form-data">
            <img src="assets/Images/<%= request.getParameter("filename")%>" alt="Abe Yaar" width="104" height="104"><br><br>
            <label name="photo"><%= request.getParameter("filename")%></label><br><br>
            <input type="text" value="<%= request.getParameter("filename")%>"><br><br>
            Change Photo:<input type="file" name="file"><br><br>
            <input type="hidden" name="username" value="<%= request.getParameter("username")%>"><br>
            <input type="submit" name="btnupdate" value="UPDATE">
        </form>
    </body>
</html>
