package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conexion {
    private static final String drv = "com.mysql.jdbc.Driver";
    private static final String db = "jdbc:mysql://localhost:3306/ejercicio_crud";
    private static final String user = "root";
    private static final String pass = "";
    private Connection ct;
    private Statement st;
    
    public Conexion(){
        try{
                Class.forName(drv);
                ct = DriverManager.getConnection(db, user, pass);
                st = ct.createStatement();
                //System.out.println("Conexión exitosa");
        }catch(Exception e){
                System.out.println("Error de conexión");
                e.printStackTrace();
        }
    }
    
    public Statement getSt(){
        return st;
    }

    public Connection getCon(){
        return ct;
    }
    
    
    
}
