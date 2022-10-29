/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import static hospital.Encryptor.getMd5;
import vistas.Home;

/**
 *
 * @author wilme
 */
public class LoginClass {
    private ResultSet rs;
    private String query;
    private String pass_crypt;
    private int id_user;
    private boolean genero;
    private String nombres;
    private int rol;
    
    ModelUser userc = new ModelUser();
    
    public void auth(String username, String pass){
        pass_crypt = getMd5(pass);
        try{
            userc.getConexion();
            this.query = "SELECT id_user, genero, nombres, rol FROM \"user\" WHERE \"username\" = '"+username+"' AND \"pass\" = '"+pass_crypt+"' AND \"status\" = true";
            this.rs = userc.verificar(this.query);
            
            while (this.rs.next()) {
                this.id_user = rs.getInt(1);
                this.genero = rs.getBoolean(2);
                this.nombres = rs.getString(3);
                this.rol = rs.getInt(4);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error en la petición: "+e.getMessage());
        }
        
        if(this.id_user == 0){
            JOptionPane.showMessageDialog(null, "Usuario o contraseña inválido");
        } else {
            Home h = new Home();
            h.setVisible(true);
            
            String b = (this.genero) ? "Bienvenido "+this.nombres : "Bienvenida "+this.nombres;
            String r = (this.rol == 1) ? "Admin" : "Paciente";
            h.lb_welcome.setText(b);
            h.lb_rol.setText(r);
        }
    }
}
