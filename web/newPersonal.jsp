<%-- 
    Document   : newPersonal
    Created on : 14-jun-2018, 16:24:48
    Author     : daw2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Personal</title>
    </head>
    <body>
        <h1>Alta de nuevo personal</h1>
        <form method="POST" action="RegisterPersonal">
            <p>Nombre:<input type="text" name="nombre" required></p>
            <p>Apellido:<input type="text" name="apellido" required></p>
            <p>Rango: <select name="rank">
                    <option value="Comandante" name="rank">Comandante</option>
                    <option value="PrimerOficial" name="rank">PrimerOficial</option>
                    <option value="Comandante" name="rank">Aviador</option>
                </select> (Este campo es indiferente)
            </p>
            <p>Especialidad: <select name="especialidad">
                    <option value="Comandante" name="especialidad">Comandante</option>
                    <option value="Ingeniero" name="especialidad">Ingeniero</option>
                    <option value="PilotoLigero" name="especialidad">PilotoLigero</option>
                </select>
            </p>
            <p><input type="submit" value="Alta"></p>
        </form>
    </body>
</html>
