/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myremote;

/**
 *
 * @author 1erDAM
 */
public class PooAdministrador {
    
    private int idAdmin;
    private String nombre;
    private String apellido;
    private String nick;
    private String password;

    public PooAdministrador(int idAdmin, String nombre, String apellido, String nick, String password) {
        this.idAdmin = idAdmin;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nick = nick;
        this.password = password;
    }
    
    public PooAdministrador(){
        
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
            
    
    
    
    
    
}
