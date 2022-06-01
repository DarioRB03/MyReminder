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
public class PooUsuarioModel extends DBUtil{
    
        public boolean agregarUsuario(int idUsuario, String nombre, String apellido, String nick, String password ) {
		Boolean resultado = false;
		try {
			String insertSql = "INSERT INTO usuarios (idUsuario, nombre, apellido, nick, password) VALUES (?, ?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
			
			prest.setInt(1, idUsuario);
			prest.setString(2, nombre);
			prest.setString(3, apellido);
			prest.setString(4, nick);
                        prest.setString(4, password);
                        
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
    
    
        public boolean eliminarModulo(int idUsuario) {
		Boolean resultado = false;
		try {
			String Sql = "DELETE FROM usuarios WHERE idUsuario=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(1, idUsuario);
			
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

        
            public boolean editarModulo(int idUsuario, String nombre, String apellido, String nick, String password) {
		Boolean resultado = false;
		try {
			String Sql = "UPDATE usuarios SET (idUsuario, nombre, apellido, nick, password) VALUES (?, ?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(1, idUsuario);
			prest.setString(2, nombre);
			prest.setString(3, apellido);
			prest.setString(4, nick);
                        prest.setString(4, password);
			
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
