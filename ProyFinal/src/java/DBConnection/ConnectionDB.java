package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {

    private String bd = "ProyectoPasteles";
    private String url = "jdbc:mysql://localhost:3306/";
    private String usr = "root";
    private String password = "nomelo666";
    private String driver = "com.mysql.cj.jdbc.Driver";
    private Connection cx;

    public ConnectionDB(){
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url + bd, usr, password);
            System.out.println("Conectado a la base de datos");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("No se conecto a la base de datos");
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection GetConnection() {
        return cx;
    }

    public void CloseConnection() throws SQLException {
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Error while closing DB connection");
        }
    }

}
