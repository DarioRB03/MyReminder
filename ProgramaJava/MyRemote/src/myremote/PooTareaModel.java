/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myremote;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author 1erDAM
 */
public class PooTareaModel extends DBUtil{
    
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
                    Date fecha = rs.getDate("fechaTarea");
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
                    Date fecha = rs.getDate("fechaTarea");
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
    
        public boolean agregarTarea(int idTarea, int idModulo, String titulo, String descripcion, Date fechaTarea, int prioridad, int realizado) {
		Boolean resultado = false;
		try {
			String insertSql = "INSERT INTO tareas (idModulo, titulo, descripcion, fechaTarea, prioridad, realizado) VALUES (?, ?, ?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
			
			prest.setInt(1, idModulo);
			prest.setString(2, titulo);
			prest.setString(3, descripcion);
                        prest.setDate(4, (java.sql.Date) fechaTarea);
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

        
            public boolean editarTarea(int idTarea, int idModulo, String titulo, String descripcion, Date fechaTarea, int prioridad, int realizado) {
		Boolean resultado = false;
		try {
			String Sql = "UPDATE tareas SET idModulo=?,titulo=?,descripcion=?,fechaTarea=?,prioridad=?,realizado=? WHERE idTarea=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(7, idTarea);
			prest.setInt(1, idModulo);
			prest.setString(2, titulo);
			prest.setString(3, descripcion);
                        prest.setDate(4, (java.sql.Date) fechaTarea);
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
                        Date fecha = rs.getDate("fechaTarea");
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
            
    public ArrayList<PooTarea> getTareasCerca(int idUsuarioActivo){
            ArrayList<PooTarea> tareas = new ArrayList<PooTarea>();
            
            try{
                String insertSql = "SELECT idTarea, idModulo, titulo, descripcion FROM tareas WHERE idModulo IN (SELECT idModulo FROM modulos WHERE idUsuario=?) ORDER BY fecha ASC LIMIT 3";
                PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
                ResultSet rs = prest.executeQuery();
                
                while (rs.next()){
                    int idTarea = rs.getInt("idTarea");
                    int idModulo = rs.getInt("idModulo");
                    String titulo = rs.getString("titulo");
                    String descripcion = rs.getString("descripcion");
                    Date fecha = rs.getDate("fechaTarea");
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
