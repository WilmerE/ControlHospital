/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author wilme
 */
public class ModelAlergiaUser {
    private final String HOST = "localhost";
    private final String PUERTO = "5432";
    private final String DB = "hospital";
    private final String USER = "postgres";
    private final String PASSWORD = "root";
    
    private static Connection conn;
    private static Statement state;
    private static ResultSet rs;
    
    public Connection getConexion(){
        
        try {
            Class.forName("org.postgresql.Driver");
            String url ="jdbc:postgresql://"+HOST+":"+PUERTO+"/"+DB;
            conn = DriverManager.getConnection(url, USER, PASSWORD);
            //JOptionPane.showMessageDialog(null, "conexion exitosa");
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return conn;
    }
    
    public void insert(int id_user, int id_alergia)throws SQLException{
        String query = "INSERT INTO public.user_alergia(id_user, id_alergia) VALUES ("+id_user+",'"+id_alergia+"')";
        state = conn.createStatement();
        state.executeQuery(query);
    }
}
