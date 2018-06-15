<%-- 
    Document   : deletePersonalForm
    Created on : 14-jun-2018, 20:00:46
    Author     : daw2
--%>

<%@page import="obj.Personal"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        List<Personal> list = (List<Personal>) request.getAttribute("allPers");
            if (list.isEmpty()) {
        %>
        No hay personal
        <%
        } else {
        %>
        <%
            for (Personal p : list) {
        %>
            <form action="DeletePersonal" method="POST">
                <input type="hidden" name="idDelete" value="<%=p.getId()%>" />
                <%=p.getNombre()%> <%=p.getApellido()%>, <%=p.getEspecialidad()%> - <%=p.getRank()%><input/>
            </form>
        <%
            }
        %>
        <%
        } 
        %>
    </body>
</html>
