<%-- 
    Document   : altaMisiones
    Created on : 14-jun-2018, 19:26:54
    Author     : DAM
--%>

<%@page import="obj.Nave"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alta de Mision</h1>
        <%
        List<Nave> allNaves =(List<Nave>) request.getAttribute("allNaves");
        %>
        
        <form method="POST" action="RegisterMision">
            <p>Nombre: <input type="text" name="nombre" required></p>
            <p>Clasificacion: <input type="number" name="clasificacion" min="0" max="10" required></p>
            <p>Tipo: <input type="text" name="tipo" required></p>
            <p>Zona: <input type="text" name="zona" required></p>
            <p>Nave: <select name="nave">
                    <% for(Nave nave: allNaves){%>
                    <option value="<%= nave.getId()%>" name="nave"><%= nave.getModelo()%></option>
                    <% } %>
            <p><input type="submit" value="Alta"></p>
        </form>
        
        
    </body>
</html>
