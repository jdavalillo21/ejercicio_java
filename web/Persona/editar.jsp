<%-- 
    Document   : editar
    Created on : 22-02-2023, 13:40:05
    Author     : jpdav
--%>

<%@page import="Modelo.Persona"%>
<%@page import="ModeloDAO.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar persona</h1>
        
        <%
            PersonaDAO pd = new PersonaDAO();
            int id = Integer.parseInt((String) request.getAttribute("idPersona"));
            Persona p = (Persona)pd.list(id);
        %>
        
        
        <form action="PersonaControlador" method="post">
            <input type="hidden" name="txtId" value="<%= p.getId() %>" />
            <label>Dni:</label><br />
            <input type="text" name="txtDni" value="<%= p.getDni() %>" /><br /><br />
            <label>Nombre:</label><br />
            <input type="text" name="txtNombre" value="<%= p.getNombre() %>" /><br /><br />
            <label>Apellido:</label><br />
            <input type="text" name="txtApellido" value="<%= p.getApellido() %>" /><br /><br />
            <label>Tel&eacute;fono:</label><br />
            <input type="text" name="txtTelefono" value="<%= p.getTelefono() %>" /><br /><br />
            <label>E-Mail:</label><br />
            <input type="text" name="txtEmail" value="<%= p.getEmail() %>" /><br /><br />
            <label>Direcci&oacute;n:</label><br />
            <input type="text" name="txtDireccion" value="<%= p.getDireccion() %>" />
            <br /><br />
            <input type="submit" name="accion" value="Actualizar" />
            
        </form>
    </body>
</html>
