<%-- 
    Document   : newNave
    Created on : 14-jun-2018, 18:29:50
    Author     : DAM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Nave</title>
    </head>
    <body>
        <h1>New Nave!</h1>
        <form method="POST" action="RegisterNave">
            <p>Fabricante<input type="text" name="fabricante" required></p>
            <p>Modelo<input type="text" name="modelo" required></p>
            <p>Tipo<input type="text" name="tipo" required></p>
            <p><input type="submit" value="Alta"></p>
        </form>
    </body>
</html>
