/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myremote;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author 1erDAM
 */
public class PooTareaModel extends DBUtil{
    
        public boolean agregarTarea(int idTarea, int idModulo, String titulo, String descripcion) {
		Boolean resultado = false;
		try {
			String insertSql = "INSERT INTO administrador (idTarea, idModulo, titulo, descripcion) VALUES (?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
			
			prest.setInt(1, idTarea);
			prest.setInt(2, idModulo);
			prest.setString(3, titulo);
			prest.setString(4, descripcion);
                        
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
    
    
        public boolean eliminarModulo(int idTarea, int idModulo) {
		Boolean resultado = false;
		try {
			String Sql = "DELETE FROM administrador WHERE idTarea=? AND idModulo=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(1, idTarea);
                        prest.setInt(2, idModulo);
			
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

        
            public boolean editarModulo(int idTarea, int idModulo, String titulo, String descripcion) {
		Boolean resultado = false;
		try {
			String Sql = "UPDATE administrador SET (idTarea, idModulo, titulo, descripcion) VALUES (?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(1, idTarea);
			prest.setInt(2, idModulo);
			prest.setString(3, titulo);
			prest.setString(4, descripcion);
			
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

                    String insertSql = "SELECT idTarea, idModulo, titulo, descripcion, fecha, prioridad FROM tareas WHERE idModulo IN (SELECT idModulo FROM modulos WHERE idUsuario=?)";
	
                    PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
                    
                    prest.setInt(1, idUsuarioActivo);

                    ResultSet rs = prest.executeQuery();

                    while (rs.next()){
			int idTarea = rs.getInt("idTarea");
                        int idModulo = rs.getInt("idModulo");
                        String titulo = rs.getString("titulo");
                        String descripcion = rs.getString("descripcion");
                            /* falta modificar los POO base para poder crear los objetos correctamente */
                        PooTarea t = new PooTarea(idTarea,idModulo,titulo,descripcion);
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
}
