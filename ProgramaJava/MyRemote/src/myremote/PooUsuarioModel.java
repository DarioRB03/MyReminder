/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myremote;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 1erDAM
 */
public class PooUsuarioModel extends DBUtil{
    
        public ArrayList<PooUsuario> getUsuarios(){
            ArrayList<PooUsuario> arrayUsuarios = new ArrayList<PooUsuario>();
        try {
			String insertSql = "SELECT idUsuario, nombre, apellido, nick, password FROM usuarios";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
			ResultSet rs = prest.executeQuery();
                        
                        while (rs.next()){
                           int idUsuario = rs.getInt("idModulo");
                           String nombre = rs.getString("nombre");
                           String apellido = rs.getString("apellido");
                           String nick = rs.getString("nick");
                           String password = rs.getString("password");
                            
                            PooUsuario u = new PooUsuario(idUsuario,nombre,apellido,nick,password);
                            arrayUsuarios.add(u);
                        }
                        
                        return arrayUsuarios;
                } catch (SQLException e) {
			e.printStackTrace();
                        return null;
		} 
		finally {
			this.cerrarConexion();
		}
        }
       
    
        public boolean agregarUsuario(String nombre, String apellido, String nick, String password ) {
		Boolean resultado = false;
		try {
			String insertSql = "INSERT INTO usuarios (nombre, apellido, nick, password) VALUES (?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
			
			prest.setString(1, nombre);
			prest.setString(2, apellido);
			prest.setString(3, nick);
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
    
    
        public boolean eliminarUsuario(int idUsuario) {
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

        
            public boolean editarUsuario(int idUsuario, String nombre, String apellido, String nick, String password) {
		Boolean resultado = false;
		try {
			String Sql = "UPDATE usuarios SET nombre=?, apellido=?, nick=?, password=? WHERE idUsuario=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(5, idUsuario);
			prest.setString(1, nombre);
			prest.setString(2, apellido);
			prest.setString(3, nick);
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
