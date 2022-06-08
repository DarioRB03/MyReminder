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
 * Clase model de evaluacion
 * @author 1erDAM
 */
public class PooEvaluacionModel extends DBUtil {
    
        /**
         * Obtener un ArrayList de evaluaciones de la base de datos
         * @return ArrayList 
         */
        public ArrayList<PooEvaluacion> getEvaluacion(){
            ArrayList<PooEvaluacion> arrayEvaluaciones = new ArrayList<PooEvaluacion>();
            try{

                    String insertSql = "SELECT idModulo,numEvaluacion,porcentaje,nota FROM evaluacion";
                    PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
                    ResultSet rs = prest.executeQuery();

                    while (rs.next()){
			int idMod = rs.getInt("idModulo");
                        int numEvaluacion = rs.getInt("numEvaluacion");
                        int porcentaje = rs.getInt("porcentaje");
                        int nota = rs.getInt("nota");
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
    
        /**
         * Obtener un ArrayList de evaluaciones correspondientes a un modulo específico de la base de datos
         * @param idModulo el módulo específico
         * @return ArrayList
         */
        public ArrayList<PooEvaluacion> getEvaluacionDeModulo(int idModulo){
            ArrayList<PooEvaluacion> arrayEvaluaciones = new ArrayList<PooEvaluacion>();
            try{

                    String insertSql = "SELECT idModulo,numEvaluacion,porcentaje,nota FROM evaluacion WHERE idModulo=?";
                    PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
                    prest.setInt(1, idModulo);
                    ResultSet rs = prest.executeQuery();

                    while (rs.next()){
			int idMod = rs.getInt("idModulo");
                        int numEvaluacion = rs.getInt("numEvaluacion");
                        int porcentaje = rs.getInt("porcentaje");
                        int nota = rs.getInt("nota");
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
        
        /**
         * devuelve un ObservableList de evaluaciones correspondientes a un modulo
         * @param idModulo el modulo correspondiente
         * @return la ObservableList
         */
        public ObservableList<PooEvaluacion> getEva(int idModulo){
            ObservableList<PooEvaluacion> evaluacionesObservables = FXCollections.observableArrayList();

                try{

                    String insertSql = "SELECT idModulo,numEvaluacion,porcentaje,nota FROM evaluacion WHERE idModulo=?";
	
                    PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
                    
                    prest.setInt(1, idModulo);

                    ResultSet rs = prest.executeQuery();

                    while (rs.next()){
			int idMod = rs.getInt("idModulo");
                        int numEvaluacion = rs.getInt("numEvaluacion");
                        int porcentaje = rs.getInt("porcentaje");
                        int nota = rs.getInt("nota");
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
        
        /**
         * Inserta una evaluacion en la base de datos
         * @param idModulo id del modulo correspondiente a la evaluacion
         * @param numEvaluacion numero de la evaluacion correspondiente a la evaluacion
         * @param procentaje porcentaje que cuenta de la evaluacion en la nota
         * @param nota valor de la nota de la evaluacion
         * @return booleana
         */
        public boolean agregarEvaluacion(int idModulo, int numEvaluacion, int porcentaje,int nota) {
		Boolean resultado = false;
		try {
			String insertSql = "INSERT INTO evaluacion (idModulo, numEvaluacion, porcentaje, nota) VALUES (?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
			
			prest.setInt(1, idModulo);
			prest.setInt(2, numEvaluacion);
			prest.setInt(3, porcentaje);
			prest.setInt(4, nota);
			
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
    
        /**
         * Eliminar una evaluacion de la base de datos
         * @param idModulo id del modulo correspondiente a la evaluacion
         * @param idEvaluacion id de la evaluacion correspondiente
         * @return booleana
         */
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

        /**
         * Editar evaluacion en la base de datos
         * @param idModulo id de modulo correspondiente a la evaluacion a cambiar
         * @param numEvaluacion numero de la evaluacion que se cambia
         * @param procentaje porcentaje a cambiar
         * @param nota nota a cambiar
         * @return booleana
         */
            public boolean editarEvaluacion(int idModulo, int numEvaluacion, int procentaje,int nota) {
		Boolean resultado = false;
		try {
			String Sql = "UPDATE evaluacion SET procentaje=?, nota=? WHERE idModulo=? AND numEvaluacion=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(3, idModulo);
			prest.setInt(4, numEvaluacion);
			prest.setInt(1, procentaje);
			prest.setInt(2, nota);
			
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
