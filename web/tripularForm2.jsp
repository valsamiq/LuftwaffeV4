<%-- 
    Document   : tripularForm2
    Created on : 15-jun-2018, 17:51:31
    Author     : daw2
--%>

<%@page import="obj.Personal"%>
<%@page import="obj.Mision"%>
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
            List<Mision> listM = (List<Mision>) request.getAttribute("allMision");
            List<Personal> listP = (List<Personal>) request.getAttribute("allPers");
            if (listM.isEmpty()||listP.isEmpty()) {
        %>
        <h2> No hay Registros de Misiones o Personal </h2>
        <%
        } else {
        %>
        <p>
        <form method="POST" action="NewExecution3">
            <p>Misiones Disponibles: <select name="mision">
                    <%
                    for (Mision m : listM) {
                    %>
                        <option value="<%=m.getNombre()%>" name="mision"><%=m.getNombre()%></option>
                    <%
                    }
                    %>
                </select>
            </p>
            <p>Personal Disponible: <select name="personal">
                    <%
                    for (Personal p : listP) {
                    %>
                        <option value="<%=p.getNombre()%>" name="personal"><%=p.getNombre()%></option>
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
