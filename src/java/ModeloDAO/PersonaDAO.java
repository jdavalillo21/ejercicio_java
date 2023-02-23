package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Persona;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;


public class PersonaDAO implements CRUD{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement st;
    CallableStatement cs;
    ResultSet rs;
    Persona p = new Persona();

    

    @Override
    public List listado() {
        ArrayList<Persona>list = new ArrayList<>();
        try {
            String query = "CALL getpersonas()";
            con = cn.getCon();
            st = con.prepareStatement(query);
            rs = st.executeQuery();
            while(rs.next()){
                Persona per = new Persona();
                per.setId(rs.getInt("id"));
                per.setDni(rs.getString("dni"));
                per.setNombre(rs.getString("nombre"));
                per.setApellido(rs.getString("apellido"));
                per.setTelefono(rs.getString("telefono"));
                per.setEmail(rs.getString("email"));
                per.setDireccion(rs.getString("direccion"));
                list.add(per);
            }
            
        } catch (Exception e) {
        }
        
        return list;
        
    }

    @Override
    public Persona list(int id) {
        String query = "CALL encontrar_persona('"+id+"')";
        try {
            st = cn.getCon().prepareStatement(query);
            rs = st.executeQuery();
            while(rs.next()){
                p.setId(id);
                p.setDni(rs.getString("dni"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setTelefono(rs.getString("telefono"));
                p.setEmail(rs.getString("email"));
                p.setDireccion(rs.getString("direccion"));
            }
        } catch (Exception e) {
        }
        
        return p;
    }

    @Override
    public boolean add(Persona per) {
        String query = "CALL new_persona(?,?,?,?,?,?)";
        try {
            CallableStatement cs = cn.getCon().prepareCall(query);
            cs.setString(1, per.getDni());
            cs.setString(2, per.getNombre());
            cs.setString(3, per.getApellido());
            cs.setString(4, per.getTelefono());
            cs.setString(5, per.getEmail());
            cs.setString(6, per.getDireccion());
            cs.executeUpdate();
            
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
        
    }

    @Override
    public boolean edit(Persona per) {
        boolean respuesta;
        String query = "CALL editar_persona(?,?,?,?,?,?,?)";
        try {
            CallableStatement cs = cn.getCon().prepareCall(query);
            cs.setInt(1, per.getId());
            cs.setString(2, per.getDni());
            cs.setString(3, per.getNombre());
            cs.setString(4, per.getApellido());
            cs.setString(5, per.getTelefono());
            cs.setString(6, per.getEmail());
            cs.setString(7, per.getDireccion());
            cs.executeUpdate();
            respuesta = true;
        } catch (Exception e) {
            e.printStackTrace();
            respuesta = false;
        }
        
        return respuesta;
    }

    @Override
    public boolean eliminar(int id) {
        boolean respuesta = true;
        String query = "CALL eliminar_persona(?)";
        try {
            CallableStatement cs = cn.getCon().prepareCall(query);
            cs.setInt(1, id);
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            respuesta = false;
        }
        return respuesta;
    }
    
}
