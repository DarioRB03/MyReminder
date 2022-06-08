/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myreminderapp;

/**
 *
 * @author 1erDAM
 */
public class PooUsuario {
    
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String nick;
    private String password;

    /**
     * Constructor de usuario con parametros
     * @param idUsuario id del usuario creado
     * @param nombre nombre del usuario
     * @param apellido apellido(s) del usuario
     * @param nick nick del usuario
     * @param password contraseña del usuario
     */
    public PooUsuario(int idUsuario, String nombre, String apellido, String nick, String password) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nick = nick;
        this.password = password;
    }

    public PooUsuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
