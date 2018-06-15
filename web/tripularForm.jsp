<%-- 
    Document   : tripularForm
    Created on : 15-jun-2018, 14:55:23
    Author     : daw2
--%>

<%@page import="obj.Mision"%>
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
        <h1>Send Mission Form</h1>
        <%
            List<Mision> list = (List<Mision>) request.getAttribute("allMision");
            if (list.isEmpty()) {
        %>
        <h2> No hay Registros de Misiones activas </h2>
        <%
        } else {
        %>
        <p>
        <form method="POST" action="RegisterPersonal">
            <p>Tipo de Mision: <select name="tipo">
                    <%
                    for (Mision m : list) {
                    %>
                        <option value="<%=m.getTipo()%>" name="tipo"><%=m.getTipo()%></option>
                    <%
                    }
                    %>
                </select>
            </p>
            <p><input type="submit" value="Alta"></p>
        </form>
    </p>
    <%
        }
    %>
</body>
</html>
