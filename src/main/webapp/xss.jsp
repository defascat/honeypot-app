<%-- 
    Document   : xss
    Created on : Mar 5, 2015, 1:42:41 PM
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
        <form action="add" method="POST">
            POST FORM<br/>
            <input name="text"/>
            <input type="submit"/>
        </form>
        <form action="add" method="GET">
            GET FORM<br/>
            <input name="text"/>
            <input type="submit"/>
        </form>
    </body>
</html>
