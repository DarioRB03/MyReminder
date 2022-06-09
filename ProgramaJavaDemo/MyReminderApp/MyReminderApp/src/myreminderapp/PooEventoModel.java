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
 * Clase model de evento
 * @author 1erDAM
 */
public class PooEventoModel extends DBUtil{
        /**
         * Obtener un ArrayList de eventos de la base de datos
         * @return ArrayList
         */
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
                    Date fecha = rs.getDate("fechaEvento");
                    String fechaEvento = fecha.toString();
                    int prioridad = rs.getInt("prioridad");
                    
                    PooEvento e = new PooEvento(idEvento,idModulo,titulo,descripcion,fechaEvento,prioridad);
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
        
        /**
         * Obtener un ArrayList de eventos correspondientes a un usuario específico de la base de datos
         * @param idUsuarioActivo id del usuario correspondiente
         * @return ArrayList
         */
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
                    Date fecha = rs.getDate("fechaEvento");
                    String fechaEvento = fecha.toString();
                    int prioridad = rs.getInt("prioridad");
                    
                    PooEvento e = new PooEvento(idEvento,idModulo,titulo,descripcion,fechaEvento,prioridad);
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
    
        /**
         * Inserta un evento en la base de datos
         * @param idModulo id del modulo del evento 
         * @param titulo titulo del evento
         * @param descripcion descripcion del evento
         * @param fechaEvento fecha del evento
         * @param prioridad prioridad del evento, valores de 1 a 3
         * @return booleana
         */
        public boolean agregarEvento(int idModulo, String titulo, String descripcion, String fechaEvento, int prioridad) {
		Boolean resultado = false;
		try {
			String insertSql = "INSERT INTO eventos (idModulo, titulo, descripcion, fechaEvento, prioridad) VALUES (?, ?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
			
			prest.setInt(1, idModulo);
			prest.setString(2, titulo);
			prest.setString(3, descripcion);
                        
                        Date fecha = new Date();
                        String[] camposDatos = fechaEvento.split("-");
                        int year = Integer.parseInt(camposDatos[0]);
                        int month = Integer.parseInt(camposDatos[1]);
                        int day = Integer.parseInt(camposDatos[2]);;
                        fecha.setYear(year);
                        fecha.setMonth(month);
                        fecha.setDate(day);
                        
                        prest.setDate(4, (java.sql.Date) fecha);
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
    
        /**
         * Eliminar un evento de la base de datos
         * @param idEvento id del evento a eliminar
         * @return booleana
         */
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

            /**
             * Editar un evento de la base de datos
             * @param idEvento id del evento a cambiar
             * @param idModulo id del modulo al que pertenece el evento que se cambia
             * @param titulo titulo del evento que se cambia
             * @param descripcion descripcion del evento que se cambia
             * @param fechaEvento fecha del evento que se cambia
             * @param prioridad prioridad del evento a cambiar, de 1 a 3
             * @return booleana
             */
            public boolean editarEvento(int idEvento, int idModulo, String titulo, String descripcion, String fechaEvento, int prioridad) {
		Boolean resultado = false;
		try {
			String Sql = "UPDATE eventos SET idModulo=?,titulo=?,descripcion=?,fechaEvento=?,prioridad=? WHERE idEvento=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(6, idEvento);
			prest.setInt(1, idModulo);
			prest.setString(2, titulo);
			prest.setString(3, descripcion);
                        
                        Date fecha = new Date();
                        String[] camposDatos = fechaEvento.split("-");
                        int year = Integer.parseInt(camposDatos[0]);
                        int month = Integer.parseInt(camposDatos[1]);
                        int day = Integer.parseInt(camposDatos[2]);;
                        fecha.setYear(year);
                        fecha.setMonth(month);
                        fecha.setDate(day);
                        
                        prest.setDate(4, (java.sql.Date) fecha);
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
            
            /**
             * Obtener una ObservableList de eventos correspondientes a un usuario específico de la base de datos
             * @param idUsuarioActivo id del usuario correspondiente a el array de eventos que se obtiene
             * @return ObservableList
             */
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
                        Date fecha = rs.getDate("fechaEvento");
                        String fechaEvento = fecha.toString();
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
    /**
     * Obtener una ArrayList de 3 eventos correspondientes a un usuario específico de la base de datos
     * de fecha más cercana
     * @param idUsuarioActivo id del usuario correspondiente a los eventos que se obtienen
     * @return ArrayList
     */
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
                    Date fecha = rs.getDate("fechaEvento");
                    String fechaEvento = fecha.toString();
                    int prioridad = rs.getInt("prioridad");
                    
                    
                    
                    PooEvento e = new PooEvento(idEvento,idModulo,titulo,descripcion,fechaEvento,prioridad);
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

