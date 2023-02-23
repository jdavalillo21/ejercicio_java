<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
        <div id="listado">
            <h1>Listado de Contactos</h1>
            <a href="PersonaControlador?accion=add" style="text-decoration: none; padding: 15px 18px; border:none; background-color: #333333; color: white; margin-bottom: 25px;">Nuevo contacto</a>
            
            <br />
            <br />
            <hr />
            
            <table border="0" style="width: 100%;">
                <thead>
                    <tr>
                        <th>Dni</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Tel&eacute;fono</th>
                        <th>Email</th>
                        <th>Direcci&oacute;n</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                
                <tbody>
                    <% 
                        PersonaDAO pd = new PersonaDAO();
                        List<Persona>list = pd.listado();
                        Iterator<Persona> iter = list.iterator();
                        Persona per = null;
                        while(iter.hasNext()){
                            per = iter.next();
                        
                    %>
                    <tr>
                        <td style="text-align: center"><%= per.getDni() %></td>
                        <td style="text-align: center"><%= per.getNombre() %></td>
                        <td style="text-align: center"><%= per.getApellido() %></td>
                        <td style="text-align: center"><%= per.getTelefono() %></td>
                        <td style="text-align: center"><%= per.getEmail()%></td>
                        <td style="text-align: center"><%= per.getDireccion()%></td>
                        <td style="text-align: center">
                            <a href="PersonaControlador?accion=editar&id=<%=per.getId()%>" style="color:blue; text-decoration: none;">Editar</a>
                            &nbsp;&nbsp;
                            <a href="PersonaControlador?accion=eliminar&id=<%=per.getId()%>"  style="color:red; text-decoration: none;">Eliminar</a>
                        </td>
                    </tr>
                    <% } %> 
                </tbody>
            </table>

        </div>
    </body>
</html>
