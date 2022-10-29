/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author wilme
 */
public class UserLog {
    
    private int id_user;
    private int rol;
    private String nombres;
    private String apellidos;
    private boolean genero;
    
    public UserLog(){}
    
    public UserLog(int id, int rol, String nombres, String apellidos, boolean genero){
        this.id_user = id;
        this.rol = rol;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.genero = genero;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }
    
    
}
