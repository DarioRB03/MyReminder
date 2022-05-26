/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myremote;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 1erDAM
 */
public class PooEventoModel extends DBUtil{
    
        public boolean agregarEvento(int idEvento, int idModulo, String titulo, String descripcion, int fechaEvento, int prioridad) {
		Boolean resultado = false;
		try {
			String insertSql = "INSERT INTO administrador (idEvento, idModulo, titulo, descripcion, fechaEvento, prioridad) VALUES (?, ?, ?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
			
			prest.setInt(1, idEvento);
			prest.setInt(2, idModulo);
			prest.setString(3, titulo);
			prest.setString(4, descripcion);
                        prest.setInt(5, fechaEvento);
                        prest.setInt(6, prioridad);
                        
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
    
    
        public boolean eliminarEvento(int idModulo, int idEvento) {
		Boolean resultado = false;
		try {
			String Sql = "DELETE FROM administrador WHERE idModulo=? AND idEvento=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(1, idModulo);
                        prest.setInt(2, idEvento);
			
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

        
            public boolean editarEvento(int idEvento, int idModulo, String titulo, String descripcion, int fechaEvento, int prioridad) {
		Boolean resultado = false;
		try {
			String Sql = "UPDATE administrador SET (idEvento, idModulo, titulo, descripcion, fechaEvento, prioridad) VALUES (?, ?, ?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(1, idEvento);
			prest.setInt(2, idModulo);
			prest.setString(3, titulo);
			prest.setString(4, descripcion);
                        prest.setInt(5, fechaEvento);
                        prest.setInt(6, prioridad);
			
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

