package Controlador;

import Modelo.Persona;
import ModeloDAO.PersonaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.ir.RuntimeNode;

public class PersonaControlador extends HttpServlet {

    String listado = "Persona/listado.jsp";
    String nuevo = "Persona/nuevo.jsp";
    String editar = "Persona/editar.jsp";
    Persona p = new Persona();
    PersonaDAO pd = new PersonaDAO();
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PersonaControlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PersonaControlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            String acceso = "";
            String action = request.getParameter("accion");
            if(action.equalsIgnoreCase("verListado")){
                acceso = listado;
            }else if(action.equalsIgnoreCase("add")){
                //Para acceder al formulario
                acceso = nuevo;
            }else if(action.equalsIgnoreCase("editar")){
                //Se envía el id al formulario
                request.setAttribute("idPersona", request.getParameter("id"));
                acceso = editar;
            }else if(action.equalsIgnoreCase("eliminar")){
                //Se envía el id al formulario
                int id = Integer.parseInt(request.getParameter("id"));
                pd.eliminar(id);
                acceso = listado;
            }
            
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            String acceso = "";
            String action = request.getParameter("accion");
            
            if(action.equalsIgnoreCase("Guardar")){
                //Se envía el formulario y se capturan los valores del mismo
                String dni = request.getParameter("txtDni");
                String nombre = request.getParameter("txtNombre");
                String apellido = request.getParameter("txtApellido");
                String telefono = request.getParameter("txtTelefono");
                String email = request.getParameter("txtEmail");
                String direccion = request.getParameter("txtDireccion");
                
                //Se agregan los valores al objeto de persona
                p.setDni(dni);
                p.setNombre(nombre);
                p.setApellido(apellido);
                p.setTelefono(telefono);
                p.setEmail(email);
                p.setDireccion(direccion);

                //Se carga el objeto en el modelo de persona para almacenar en la BBDD
                pd.add(p);
                acceso = listado;
            
            }else if(action.equalsIgnoreCase("Actualizar")){
                //Se envía el formulario y se capturan los valores del mismo
                int id = Integer.parseInt(request.getParameter("txtId"));
                String dni = request.getParameter("txtDni");
                String nombre = request.getParameter("txtNombre");
                String apellido = request.getParameter("txtApellido");
                String telefono = request.getParameter("txtTelefono");
                String email = request.getParameter("txtEmail");
                String direccion = request.getParameter("txtDireccion");
                
                p.setId(id);
                p.setDni(dni);
                p.setNombre(nombre);
                p.setApellido(apellido);
                p.setTelefono(telefono);
                p.setEmail(email);
                p.setDireccion(direccion);

                //Se carga el objeto en el modelo de persona para almacenar en la BBDD
                pd.edit(p);
                acceso = listado;
            }
            
            RequestDispatcher vista = request.getRequestDispatcher(acceso);
            vista.forward(request, response);
    }
 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
