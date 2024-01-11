
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juanB
 */
public class PruebaConexion {
    String bd = "ProyectoPasteles";
    String url = "jdbc:mysql://localhost:3306/";
    String usr = "root";
    String password = "nomelo666";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;
    
    public PruebaConexion(){
    }
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+bd, usr, password);
            System.out.println("Conectado a la base de datos");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("No se conecto a la base de datos");
            Logger.getLogger(PruebaConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }
    
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(PruebaConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
        PruebaConexion con = new PruebaConexion();
        con.conectar();
    
    
    }
    
    
    
}
