<%-- 
    Document   : newKontrol
    Created on : 14-jun-2018, 19:01:53
    Author     : daw2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alta de nuevo personal de Kontrol</h1>
        <form method="POST" action="RegisterKontrol">
            <p>Username:<input type="text" name="username" required></p>
            <p>Password:<input type="password" name="password" required></p>
            <p>Rango: <select name="rank">
                    <option value="Inspector" name="rank">Inspector</option>
                    <option value="Sargento" name="rank">Sargento</option>
                    <option value="Caporal" name="rank">Caporal</option>
                </select>
            </p>
            <p><input type="submit" value="Alta"></p>
        </form>
    </body>
</html>
