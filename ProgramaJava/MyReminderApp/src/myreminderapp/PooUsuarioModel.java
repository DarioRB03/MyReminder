/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myreminderapp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase model de usuario
 * @author 1erDAM
 */
public class PooUsuarioModel extends DBUtil{
        /**
         * Obtener un ArrayList de usuarios de la base de datos
         * @return ArrayList
         */
        public ArrayList<PooUsuario> getUsuarios(){
            ArrayList<PooUsuario> arrayUsuarios = new ArrayList<PooUsuario>();

            try {

			String insertSql = "SELECT idUsuario, nombre, apellido, nick, password FROM usuarios";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
			ResultSet rs = prest.executeQuery();
                        
                        while (rs.next()){
                           int idUsuario = rs.getInt("idUsuario");
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
       
        /**
         * Añadir Usuario a la base de datos
         * @param nombre nombre del usuario
         * @param apellido apellido del usuario
         * @param nick nick (identificador) del usuario
         * @param password contraseña del usuario, se encripta con MD5()
         * @return booleana
         */
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
    
        /**
         * Eliminar usuario de la base de datos
         * @param idUsuario id del usuario a eliminar
         * @return booleana
         */
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

            /**
             * Editar usuario de la base de datos
             * @param idUsuario id del usuario a editar
             * @param nombre nombre editado
             * @param apellido apellido editado
             * @param nick nick editado
             * @param password contraseña editada
             * @return booleana
             */
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
