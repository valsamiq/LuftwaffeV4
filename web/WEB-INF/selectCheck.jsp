<%-- 
    Document   : selectCheck
    Created on : 15-jun-2018, 19:39:50
    Author     : daw2
--%>

<%@page import="java.util.List"%>
<%@page import="obj.Tripulacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Send Mission Form</h1>
        <%
            List<Tripulacion> list = (List<Tripulacion>) request.getAttribute("allTrip");
            if (list.isEmpty()) {
        %>
        <h2> No hay Registros de Misiones activas </h2>
        <%
        } else {
        %>
        <p>
        <form method="POST" action="CheckExit">
            <p>Mision a Checkear: <select name="id">
                    <%
                        for (Tripulacion m : list) {
                    %>
                        <option value="<%=m.getId()%>" name="id"><%=m.getId()%></option>
                    <%
                        }
                    %>
                </select>
            </p>
            <p><input type="submit" value="Siguiente"></p>
        </form>
    </p>
        <%
            }
        %>
        
    </body>
</html>
