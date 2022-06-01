/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myremote;

import java.util.Date;

/**
 *
 * @author 1erDAM
 */
public class PooEvento {
    
    private int idEvento;
    private int idModulo;
    private String titulo;
    private String descripcion;
    private Date fechaEvento;
    private int prioridad;

    public PooEvento() {
    }

    public PooEvento(int idEvento, int idModulo, String titulo, String descripcion, Date fechaEvento, int prioridad) {
        this.idEvento = idEvento;
        this.idModulo = idModulo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaEvento = fechaEvento;
        this.prioridad = prioridad;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
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

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
}
