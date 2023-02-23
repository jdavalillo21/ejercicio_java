<%-- 
    Document   : nuevo
    Created on : 22-02-2023, 13:39:55
    Author     : jpdav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Agregar persona</h1>
        <form action="PersonaControlador" method="post">
            <label>Dni:</label><br />
            <input type="text" name="txtDni" /><br /><br />
            <label>Nombre:</label><br />
            <input type="text" name="txtNombre" /><br /><br />
            <label>Apellido:</label><br />
            <input type="text" name="txtApellido" /><br /><br />
            <label>Tel&eacute;fono:</label><br />
            <input type="text" name="txtTelefono" /><br /><br />
            <label>E-Mail:</label><br />
            <input type="text" name="txtEmail" /><br /><br />
            <label>Direcci&oacute;n:</label><br />
            <input type="text" name="txtDireccion" />
            <br /><br />
            <input type="submit" name="accion" value="Guardar" />
            
        </form>
    </body>
</html>
