/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBConnection.ConnectionDB;
import Models.UserModel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author juanB
 */
public class UserDAO {

    private final String SAVE_USER = "{call GuardaUsuario(?,?,?,?)}";

    private Connection cnx;
    ConnectionDB connection = new ConnectionDB();

    public UserDAO() {
        this.cnx = connection.GetConnection();
    }

    public boolean CreateUser(UserModel newUser) {
        ResultSet rs = null;
        CallableStatement st = null;

        try {
            st = cnx.prepareCall(SAVE_USER);
            st.setString(1, newUser.getName());
            st.setString(2, newUser.getLastName());
            st.setString(3, newUser.getEmail());
            st.setString(4, newUser.getPsw());
            rs = st.executeQuery();
            
            connection.CloseConnection();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error in: " + ex.getClass() + " " + ex.getSQLState() );
            return false;
        }

    }

}
