package Interfaces;

import Modelo.Persona;
import java.util.List;

public interface CRUD {
    public List listado();
    public Persona list(int id);
    public boolean add(Persona per);
    public boolean edit(Persona per);
    public boolean eliminar(int id);
    
}
