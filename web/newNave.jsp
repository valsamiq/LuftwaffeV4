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
            <p>Fabricante: <select name="fabricante" required>
                    <option value="Junkers" name="fabricante">Junkers</option>
                    <option value="Fieseler" name="fabricante">Fieseler</option>
                    <option value="Heinkel" name="fabricante">Heinkel</option>
                    <option value="Messerschmitt" name="fabricante">Messerschmitt</option>
                    <option value="Dornier" name="fabricante">Dornier</option>
                    <option value="Flugzeugwerke" name="fabricante">Flugzeugwerke</option>
                </select>
            </p>
            <p>Modelo<input type="text" name="modelo" required></p>
            <p>Tipo: <select name="tipo" required>
                    <option value="Caza" name="tipo">Caza</option>
                    <option value="Bombardero" name="tipo">Bombardero</option>
                    <option value="Reconocimiento" name="tipo">Reconocimiento</option>
                </select>
            </p>
            <p><input type="submit" value="Alta"></p>
        </form>
    </body>
</html>
