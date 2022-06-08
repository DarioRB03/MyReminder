/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myreminderapp;

/**
 *Clase de objeto evaluacion
 * @author 1erDAM
 */
public class PooEvaluacion {
    
    private int idModulo;
    private int numEvaluacion;
    private int porcentaje;
    private int nota;

    /**
     * Constructor de evaluacion con parametros
     * @param idModulo id del modulo al que se asigna
     * @param numEvaluacion numero de la evaluacion que representa
     * @param porcentaje porcentaje de nota
     * @param nota valor de la nota
     */
    public PooEvaluacion(int idModulo, int numEvaluacion, int porcentaje, int nota) {
        this.idModulo = idModulo;
        this.numEvaluacion = numEvaluacion;
        this.porcentaje = porcentaje;
        this.nota = nota;
    }
    public PooEvaluacion(){
        
    }

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public int getNumEvaluacion() {
        return numEvaluacion;
    }

    public void setNumEvaluacion(int numEvaluacion) {
        this.numEvaluacion = numEvaluacion;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
}
