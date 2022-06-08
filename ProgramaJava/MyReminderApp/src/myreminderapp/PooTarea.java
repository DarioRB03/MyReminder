/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myreminderapp;


/**
 * Clase de objeto tarea
 * @author 1erDAM
 */
public class PooTarea {
    
    private int idTarea;
    private int idModulo;
    private String titulo;
    private String descripcion;
    private String fecha;
    private int prioridad;
    private int realizado;


    /**
     * Constructor de tarea con parametros
     * @param idTarea id de la tarea creada
     * @param idModulo id del modulo al que se asigna
     * @param titulo titulo de la tarea
     * @param descripcion descripcion de la tarea 
     * @param fecha fecha de la tarea
     * @param prioridad prioridad de la tarea, valores del 1 al 3
     * @param realizado  si esta realizada la tarea (1) o no (2)
     */
    public PooTarea(int idTarea, int idModulo, String titulo, String descripcion, String fecha, int prioridad, int realizado) {
        this.idTarea = idTarea;
        this.idModulo = idModulo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.prioridad = prioridad;
        this.realizado = realizado;
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
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getRealizado() {
        return realizado;
    }

    public void setRealizado(int realizado) {
        this.realizado = realizado;
    }
    
    /**
     * Devuelve una string leíble con los datos de la tarea
     * @return 
     */
    @Override
    public String toString(){
        String texto;
        
        texto = ("TAREA: " + this.idTarea + " ; MODULO: " + this.idModulo + " ; TITULO: " + this.titulo + " ; PRORIDAD: " + this.prioridad);
        
        return texto;
    }
}
