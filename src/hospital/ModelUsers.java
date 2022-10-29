/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

import db_connection.Conection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author wilme
 */
public class ModelUsers {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public ResultSet selectAllUser(){
        String query = "SELECT * FROM user WHERE rol = 2";
        try{
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return rs;
    }
}
