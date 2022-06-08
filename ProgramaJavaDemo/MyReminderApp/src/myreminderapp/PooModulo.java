/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myreminderapp;

/**
 * Clase de objeto modulo
 * @author 1erDAM
 */
public class PooModulo {
    
    private int idModulo;
    private int idUsuario;
    private String titulo;
    private float notaFinal;

    /**
     * Constructor del modulo con parametros
     * @param idModulo id del modulo creado
     * @param idUsuario id del usuario al que se asigna
     * @param titulo titulo del modulo
     * @param notaFinal valor de nota calculada entre las evaluaciones
     */
    public PooModulo(int idModulo, int idUsuario, String titulo, float notaFinal) {
        this.idModulo = idModulo;
        this.idUsuario = idUsuario;
        this.titulo = titulo;
        this.notaFinal = notaFinal;
    }

    public PooModulo() {
    }

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(float notaFinal) {
        this.notaFinal = notaFinal;
    }
    
    
}
