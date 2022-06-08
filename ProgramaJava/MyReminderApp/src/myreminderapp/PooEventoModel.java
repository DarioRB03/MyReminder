/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myreminderapp;

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
public class PooEventoModel extends DBUtil{
    
        public ArrayList<PooEvento> getEventos(){
            ArrayList<PooEvento> eventos = new ArrayList<PooEvento>();
            
            try{
                String insertSql = "SELECT idTarea, idModulo, titulo, descripcion, fechaEvento, prioridad FROM eventos";
                PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
                ResultSet rs = prest.executeQuery();
                
                while (rs.next()){
                    int idEvento = rs.getInt("idEvento");
                    int idModulo = rs.getInt("idModulo");
                    String titulo = rs.getString("titulo");
                    String descripcion = rs.getString("descripcion");
                    String fecha = rs.getString("fechaEvento");
                    int prioridad = rs.getInt("prioridad");
                    
                    PooEvento e = new PooEvento(idEvento,idModulo,titulo,descripcion,fecha,prioridad);
                    eventos.add(e);
                }
                
                return eventos;
            } catch (SQLException e){
                e.printStackTrace();
                return null;
            } finally {
                this.cerrarConexion();
            }
        }
        
        public ArrayList<PooEvento> getEventosDeUsuario(int idUsuarioActivo){
            ArrayList<PooEvento> eventos = new ArrayList<PooEvento>();
            
            try{
                String insertSql = "SELECT idEvento, idModulo, titulo, descripcion, fechaEvento, prioridad FROM eventos WHERE idModulo IN (SELECT idModulo FROM modulos WHERE idUsuario=?)";
                PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
                prest.setInt(1, idUsuarioActivo);
                ResultSet rs = prest.executeQuery();
                
                while (rs.next()){
                    int idEvento = rs.getInt("idEvento");
                    int idModulo = rs.getInt("idModulo");
                    String titulo = rs.getString("titulo");
                    String descripcion = rs.getString("descripcion");
                    String fecha = rs.getString("fechaEvento");
                    int prioridad = rs.getInt("prioridad");
                    
                    PooEvento e = new PooEvento(idEvento,idModulo,titulo,descripcion,fecha,prioridad);
                    eventos.add(e);
                }
                
                return eventos;
            } catch (SQLException e){
                e.printStackTrace();
                return null;
            } finally {
                this.cerrarConexion();
            }
        }
    
    
        public boolean agregarEvento(int idModulo, String titulo, String descripcion, String fechaEvento, int prioridad) {
		Boolean resultado = false;
		try {
			String insertSql = "INSERT INTO eventos (idModulo, titulo, descripcion, fechaEvento, prioridad) VALUES (?, ?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
			
			prest.setInt(1, idModulo);
			prest.setString(2, titulo);
			prest.setString(3, descripcion);
                        prest.setString(4, fechaEvento);
                        prest.setInt(5, prioridad);
                        
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
    
    
        public boolean eliminarEvento(int idEvento) {
		Boolean resultado = false;
		try {
			String Sql = "DELETE FROM eventos WHERE idEvento=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
                        prest.setInt(1, idEvento);
			
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

        
            public boolean editarEvento(int idEvento, int idModulo, String titulo, String descripcion, String fechaEvento, int prioridad) {
		Boolean resultado = false;
		try {
			String Sql = "UPDATE eventos SET idModulo=?,titulo=?,descripcion=?,fechaEvento=?,prioridad=? WHERE idEvento=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(6, idEvento);
			prest.setInt(1, idModulo);
			prest.setString(2, titulo);
			prest.setString(3, descripcion);
                        prest.setString(4, fechaEvento);
                        prest.setInt(5, prioridad);
			
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
            
            public ObservableList<PooEvento> getEvento(int idUsuarioActivo){

                ObservableList<PooEvento> eventosObservables = FXCollections.observableArrayList();

                try{

                    String insertSql = "SELECT idEvento, idModulo, titulo, descripcion, fechaEvento, prioridad FROM eventos WHERE idModulo IN (SELECT idModulo FROM modulos WHERE idUsuario=?)";
	
                    PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
                    
                    prest.setInt(1, idUsuarioActivo);

                    ResultSet rs = prest.executeQuery();

                    while (rs.next()){
			int idEvento = rs.getInt("idEvento");
                        int idModulo = rs.getInt("idModulo");
                        String titulo = rs.getString("titulo");
                        String descripcion = rs.getString("descripcion");
                        String fechaEvento = rs.getString("fechaEvento");
                        int prioridad = rs.getInt("prioridad");
                        PooEvento t = new PooEvento(idEvento,idModulo,titulo,descripcion,fechaEvento,prioridad);
                        eventosObservables.add(t);
		}

		return eventosObservables;
	} catch (SQLException e){
		e.printStackTrace();
		return null;
	}finally{
		this.cerrarConexion();
	}
}
    public ArrayList<PooEvento> getEventosCerca(int idUsuarioActivo){
            ArrayList<PooEvento> eventos = new ArrayList<PooEvento>();
            
            try{
                String insertSql = "SELECT idEvento, idModulo, titulo, descripcion, fechaEvento, prioridad FROM eventos WHERE idModulo IN (SELECT idModulo FROM modulos WHERE idUsuario=?) ORDER BY fecha ASC LIMIT 3";
                PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
                prest.setInt(1, idUsuarioActivo);
                ResultSet rs = prest.executeQuery();
                
                while (rs.next()){
                    int idEvento = rs.getInt("idEvento");
                    int idModulo = rs.getInt("idModulo");
                    String titulo = rs.getString("titulo");
                    String descripcion = rs.getString("descripcion");
                    String fecha = rs.getString("fechaEvento");
                    int prioridad = rs.getInt("prioridad");
                    
                    
                    
                    PooEvento e = new PooEvento(idEvento,idModulo,titulo,descripcion,fecha,prioridad);
                    eventos.add(e);
                }
                
                return eventos;
            } catch (SQLException e){
                e.printStackTrace();
                return null;
            } finally {
                this.cerrarConexion();
            }
        }
}

