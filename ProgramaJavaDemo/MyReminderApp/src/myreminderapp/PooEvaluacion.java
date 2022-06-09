/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myreminderapp;

/**
 *
 * @author 1erDAM
 */
public class PooEvaluacion {
    
    private int idModulo;
    private int numEvaluacion;
    private float porcentaje;
    private float nota;

    public PooEvaluacion(int idModulo, int numEvaluacion, float porcentaje, float nota) {
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

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
}
