/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myremote;

/**
 *
 * @author 1erDAM
 */
public class PooTarea {
    
    private int idTarea;
    private int idModulo;
    private String titulo;
    private String descripcion;

    public PooTarea(int idTarea, int idModulo, String titulo, String descripcion) {
        this.idTarea = idTarea;
        this.idModulo = idModulo;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public PooTarea() {
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
