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
public class PooModuloModel extends DBUtil {
    
    public boolean agregarModulo(int idModulo, int idUsuario, String titulo, float notaFinal) {
		Boolean resultado = false;
		try {
			String insertSql = "INSERT INTO administrador (idModulo, idUsuario, titulo, notaFianl) VALUES (?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
			
			prest.setInt(1, idModulo);
			prest.setInt(2, idUsuario);
			prest.setString(3, titulo);
			prest.setFloat(4, notaFinal);
                        
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
    
    
        public boolean eliminarModulo(int idModulo, int idUsuario) {
		Boolean resultado = false;
		try {
			String Sql = "DELETE FROM administrador WHERE idModulo=? AND idUsuario=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(1, idModulo);
                        prest.setInt(2, idUsuario);
			
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

        
            public boolean editarModulo(int idModulo, int idUsuario, String titulo, float notaFinal) {
		Boolean resultado = false;
		try {
			String Sql = "UPDATE administrador SET (idModulo, idUsuario, titulo, notaFianl) VALUES (?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(1, idModulo);
			prest.setInt(2, idUsuario);
			prest.setString(3, titulo);
			prest.setFloat(4, notaFinal);
			
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
