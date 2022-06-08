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
 * Clase model de tarea
 * @author 1erDAM
 */
public class PooTareaModel extends DBUtil{
        /**
         * Obtener un ArrayList de tareas de la base de datos
         * @return ArrayList
         */
        public ArrayList<PooTarea> getTareas(){
            ArrayList<PooTarea> tareas = new ArrayList<PooTarea>();
            
            try{
                String insertSql = "SELECT idTarea, idModulo, titulo, descripcion, fechaTarea, prioridad, realizado FROM tareas";
                PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
                ResultSet rs = prest.executeQuery();
                
                while (rs.next()){
                    int idTarea = rs.getInt("idTarea");
                    int idModulo = rs.getInt("idModulo");
                    String titulo = rs.getString("titulo");
                    String descripcion = rs.getString("descripcion");
                    String fecha = rs.getString("fechaTarea");
                    int prioridad = rs.getInt("prioridad");
                    int realizado = rs.getInt("realizado");
                    
                    PooTarea t = new PooTarea(idTarea,idModulo,titulo,descripcion,fecha,prioridad,realizado);
                    tareas.add(t);
                }
                
                return tareas;
            } catch (SQLException e){
                e.printStackTrace();
                return null;
            } finally {
                this.cerrarConexion();
            }
        }
        
        /**
         * Obtener un ArrayList de tareas correspondiente a un usuario
         * @param idUsuarioActivo id del usuario correspondiente
         * @return ArrayList
         */
        public ArrayList<PooTarea> getTareasDeUsuario(int idUsuarioActivo){
            ArrayList<PooTarea> tareas = new ArrayList<PooTarea>();
            
            try{
                String insertSql = "SELECT idTarea, idModulo, titulo, descripcion, fechaTarea, prioridad, realizado FROM tareas WHERE idModulo IN (SELECT idModulo FROM modulos WHERE idUsuario=?)";
                PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
                ResultSet rs = prest.executeQuery();
                
                while (rs.next()){
                    int idTarea = rs.getInt("idTarea");
                    int idModulo = rs.getInt("idModulo");
                    String titulo = rs.getString("titulo");
                    String descripcion = rs.getString("descripcion");
                    String fecha = rs.getString("fechaTarea");
                    int prioridad = rs.getInt("prioridad");
                    int realizado = rs.getInt("realizado");
                    
                    PooTarea t = new PooTarea(idTarea,idModulo,titulo,descripcion,fecha,prioridad,realizado);
                    tareas.add(t);
                }
                
                return tareas;
            } catch (SQLException e){
                e.printStackTrace();
                return null;
            } finally {
                this.cerrarConexion();
            }
        }
    
        /**
         * Insertar una tarea en la base de datos
         * @param idTarea id de la tarea
         * @param idModulo id del modulo respectivo de la tarea
         * @param titulo titulo de la tarea
         * @param descripcion descripcion de la tarea
         * @param fechaTarea fecha de la tarea
         * @param prioridad prioridad de la tarea, de 1 a 3
         * @param realizado si esta realizada la tarea (1) o no (2)
         * @return booleana
         */
        public boolean agregarTarea(int idTarea, int idModulo, String titulo, String descripcion, String fechaTarea, int prioridad, int realizado) {
		Boolean resultado = false;
		try {
			String insertSql = "INSERT INTO tareas (idModulo, titulo, descripcion, fechaTarea, prioridad, realizado) VALUES (?, ?, ?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
			
			prest.setInt(1, idModulo);
			prest.setString(2, titulo);
			prest.setString(3, descripcion);
                        prest.setString(4, fechaTarea);
                        prest.setInt(5, prioridad);
                        prest.setInt(6, realizado);
                        
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
         * Eliminar una tarea de la base de datos
         * @param idTarea id de la tarea a eliminar
         * @return booleana
         */
        public boolean eliminarTarea(int idTarea) {
		Boolean resultado = false;
		try {
			String Sql = "DELETE FROM tareas WHERE idTarea=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(1, idTarea);
			
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
             * Editar una tarea en la base de datos
             * @param idTarea id de la tarea a editar
             * @param idModulo id del modulo respectivo de la tarea editado 
             * @param titulo titulo de la tarea editado
             * @param descripcion descripcion de la tarea editada
             * @param fechaTarea fecha de la tarea editada
             * @param prioridad prioridad de la tarea editada, de 1 a 3
             * @param realizado si esta realizada la tarea (1) o no (2), valor editado
             * @return 
             */
            public boolean editarTarea(int idTarea, int idModulo, String titulo, String descripcion, String fechaTarea, int prioridad, int realizado) {
		Boolean resultado = false;
		try {
			String Sql = "UPDATE tareas SET idModulo=?,titulo=?,descripcion=?,fechaTarea=?,prioridad=?,realizado=? WHERE idTarea=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(7, idTarea);
			prest.setInt(1, idModulo);
			prest.setString(2, titulo);
			prest.setString(3, descripcion);
                        prest.setString(4, fechaTarea);
                        prest.setInt(5, prioridad);
			prest.setInt(6, realizado);
			
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
             * Editar la tarea para asignar si esta realizada o no
             * @param idTarea id de la tarea a editar
             * @param realizado si esta realizada o no, 1 (si) o 2 (no)
             * @return booleana
             */
            public boolean realizarTarea (int idTarea, int realizado){
                Boolean resultado = false;
		try {
			String Sql = "UPDATE tareas SET realizado=? WHERE idTarea=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
		
                        prest.setInt(1, realizado);
			prest.setInt(2, idTarea);
			
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
             * Obtener una ObservableList de tareas correspondiente a un usuario
             * @param idUsuarioActivo id de la tarea correspondiente
             * @return ObservableList
             */
            public ObservableList<PooTarea> getTarea(int idUsuarioActivo){

                ObservableList<PooTarea> tareasObservables = FXCollections.observableArrayList();

                try{

                    String insertSql = "SELECT idTarea, idModulo, titulo, descripcion, fechaTarea, prioridad, realizado FROM tareas WHERE idModulo IN (SELECT idModulo FROM modulos WHERE idUsuario=?)";
	
                    PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
                    
                    prest.setInt(1, idUsuarioActivo);

                    ResultSet rs = prest.executeQuery();

                    while (rs.next()){
			int idTarea = rs.getInt("idTarea");
                        int idModulo = rs.getInt("idModulo");
                        String titulo = rs.getString("titulo");
                        String descripcion = rs.getString("descripcion");
                        String fecha = rs.getString("fechaTarea");
                        int prioridad = rs.getInt("prioridad");
                        int realizado = rs.getInt("realizado");
                        
                        PooTarea t = new PooTarea(idTarea,idModulo,titulo,descripcion,fecha,prioridad,realizado);
                        tareasObservables.add(t);
		}

		return tareasObservables;
	} catch (SQLException e){
		e.printStackTrace();
		return null;
	}finally{
		this.cerrarConexion();
        }
    }
    /**
     * Obtener un ArrayList de las 3 tareas correspondiente a un usuario más cercanas
     * @param idUsuarioActivo id del usuario
     * @return ArrayList
     */
    public ArrayList<PooTarea> getTareasCerca(int idUsuarioActivo){
            ArrayList<PooTarea> tareas = new ArrayList<PooTarea>();
            
            try{
                String insertSql = "SELECT idTarea, idModulo, titulo, descripcion, fecha, prioridad, realizado FROM tareas WHERE realizado=0 AND idModulo IN (SELECT idModulo FROM modulos WHERE idUsuario=?) ORDER BY fecha ASC LIMIT 3";
                PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
                ResultSet rs = prest.executeQuery();
                
                while (rs.next()){
                    int idTarea = rs.getInt("idTarea");
                    int idModulo = rs.getInt("idModulo");
                    String titulo = rs.getString("titulo");
                    String descripcion = rs.getString("descripcion");
                    String fecha = rs.getString("fecha");
                    int prioridad = rs.getInt("prioridad");
                    int realizado = rs.getInt("realizado");
                    
                    PooTarea t = new PooTarea(idTarea,idModulo,titulo,descripcion,fecha,prioridad,realizado);
                    tareas.add(t);
                }
                
                return tareas;
            } catch (SQLException e){
                e.printStackTrace();
                return null;
            } finally {
                this.cerrarConexion();
            }
        }
}
