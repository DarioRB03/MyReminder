/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myreminderapp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author 1erDAM
 */
public class PooEvaluacionModel extends DBUtil {
    
        public ArrayList<PooEvaluacion> getEvaluacion(){
            ArrayList<PooEvaluacion> arrayEvaluaciones = new ArrayList<PooEvaluacion>();
            try{

                    String insertSql = "SELECT idModulo,numEvaluacion,porcentaje,nota FROM evaluaciones";
                    PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
                    ResultSet rs = prest.executeQuery();

                    while (rs.next()){
			int idMod = rs.getInt("idModulo");
                        int numEvaluacion = rs.getInt("numEvaluacion");
                        float porcentaje = rs.getFloat("porcentaje");
                        float nota = rs.getFloat("nota");
                        PooEvaluacion e = new PooEvaluacion(idMod,numEvaluacion,porcentaje,nota);
                        arrayEvaluaciones.add(e);
		}

		return arrayEvaluaciones;
	} catch (SQLException e){
		e.printStackTrace();
		return null;
	}finally{
		this.cerrarConexion();
	}
        }
    
        public ArrayList<PooEvaluacion> getEvaluacionDeModulo(int idModulo){
            ArrayList<PooEvaluacion> arrayEvaluaciones = new ArrayList<PooEvaluacion>();
            try{

                    String insertSql = "SELECT idModulo,numEvaluacion,porcentaje,nota FROM evaluaciones WHERE idModulo=?";
                    PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
                    prest.setInt(1, idModulo);
                    ResultSet rs = prest.executeQuery();

                    while (rs.next()){
			int idMod = rs.getInt("idModulo");
                        int numEvaluacion = rs.getInt("numEvaluacion");
                        float porcentaje = rs.getFloat("porcentaje");
                        float nota = rs.getFloat("nota");
                        PooEvaluacion e = new PooEvaluacion(idMod,numEvaluacion,porcentaje,nota);
                        arrayEvaluaciones.add(e);
		}

		return arrayEvaluaciones;
	} catch (SQLException e){
		e.printStackTrace();
		return null;
	}finally{
		this.cerrarConexion();
	}
        }
        
        public ObservableList<PooEvaluacion> getEva(int idModulo){
            ObservableList<PooEvaluacion> evaluacionesObservables = FXCollections.observableArrayList();

                try{

                    String insertSql = "SELECT idModulo,numEvaluacion,porcentaje,nota FROM evaluaciones WHERE idModulo=?";
	
                    PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
                    
                    prest.setInt(1, idModulo);

                    ResultSet rs = prest.executeQuery();

                    while (rs.next()){
			int idMod = rs.getInt("idModulo");
                        int numEvaluacion = rs.getInt("numEvaluacion");
                        float porcentaje = rs.getFloat("porcentaje");
                        float nota = rs.getFloat("nota");
                        PooEvaluacion e = new PooEvaluacion(idMod,numEvaluacion,porcentaje,nota);
                        evaluacionesObservables.add(e);
		}

		return evaluacionesObservables;
	} catch (SQLException e){
		e.printStackTrace();
		return null;
	}finally{
		this.cerrarConexion();
	}
        }
        
        public boolean agregarEvaluacion(int idModulo, int numEvaluacion, float procentaje,float nota) {
		Boolean resultado = false;
		try {
			String insertSql = "INSERT INTO evaluacion (idModulo, numEvaluacion, procentaje, nota) VALUES (?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
			
			prest.setInt(1, idModulo);
			prest.setInt(2, numEvaluacion);
			prest.setFloat(3, procentaje);
			prest.setFloat(4, nota);
			
			prest.execute();
                        resultado = true;
                        
                } catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			this.cerrarConexion();
			return resultado;
		}
	} 
    
    
        public boolean eliminarEvaluacion(int idModulo, int idEvaluacion) {
		Boolean resultado = false;
		try {
			String Sql = "DELETE FROM evaluacion WHERE idModulo=? AND idEvaluacion=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(1, idModulo);
                        prest.setInt(2, idEvaluacion);
			
			prest.execute();
                        resultado = true;
                        
                } catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			this.cerrarConexion();
			return resultado;
		}
	
        }

        
            public boolean editarEvaluacion(int idModulo, int numEvaluacion, float procentaje,float nota) {
		Boolean resultado = false;
		try {
			String Sql = "UPDATE evaluacion SET procentaje=?, nota=? WHERE idModulo=? AND numEvaluacion=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(3, idModulo);
			prest.setInt(4, numEvaluacion);
			prest.setFloat(1, procentaje);
			prest.setFloat(2, nota);
			
			prest.execute();
                        resultado = true;
                        
                } catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			this.cerrarConexion();
			return resultado;
		}
	
            }

}
