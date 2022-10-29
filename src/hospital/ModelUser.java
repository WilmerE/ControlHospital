/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author wilme
 */
public class ModelUser {
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
    
    public static ResultSet verificar(String sql)throws SQLException{
        state = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
        rs = state.executeQuery(sql);
        return rs;
    }
    
    public static ResultSet selectAll()throws SQLException{
        String query = "SELECT * FROM public.user WHERE rol = 2";
        state = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
        rs = state.executeQuery(query);
        return rs;
    }
    
    public int insert(String username, String pass, String correlativo, String pApellido, String sApellido, String nombres, String dpi, String genero, String fNacimiento, String lNacimiento, int tipoSangre, int grupoEt, int nivelEsc, int profesion, int dept, int muni, String residencia, String status, String rol) throws SQLException{
        
        String estado = (status.equals("Activo")) ? "true" : "false";
        String gen = (status.equals("M")) ? "true" : "false";
        int rol2 = (status.equals("Administrador")) ? 1 : 2;
        String passEcrypt = Encryptor.getMd5(pass);
        
        String query = "INSERT INTO public.\"user\"(\n" +
"	username, pass, correlativo, primer_apellido, segundo_apellido, nombres, dpi, genero, fecha_nacimiento, lugar_nacimiento, id_tipo_sangre, id_grupo_etnico, id_nivel_escolar, id_profesion, id_dept, id_municipio, residencia, status, rol)\n" +
"	VALUES ('"+username+"', '"+passEcrypt+"', '"+correlativo+"', '"+pApellido+"', '"+sApellido+"', '"+nombres+"', '"+dpi+"', "+gen+", '"+fNacimiento+"', '"+lNacimiento+"', '"+tipoSangre+"', '"+grupoEt+"', '"+nivelEsc+"', '"+profesion+"', '"+dept+"', '"+muni+"', '"+residencia+"', "+estado+", "+rol2+") RETURNING id_user";
        state = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
        rs = state.executeQuery(query);
        rs.next();
        return rs.getInt(1);
    }
}
