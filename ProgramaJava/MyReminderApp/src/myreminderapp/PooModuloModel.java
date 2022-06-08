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
 * Clase model de modulo
 * @author 1erDAM
 */
public class PooModuloModel extends DBUtil {
    
    /**
     * Obtener un ArrayList de modulos de la base de datos
     * @return ArrayList
     */
    public ArrayList<PooModulo> getModulos(){
        ArrayList<PooModulo> arrayModulos = new ArrayList<PooModulo>();
        try {
			String insertSql = "SELECT idModulo, idUsuario, titulo, notaFinal FROM modulos";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
			ResultSet rs = prest.executeQuery();
                        
                        while (rs.next()){
                            int idModulo = rs.getInt("idModulo");
                            int idUsuario = rs.getInt("idUsuario");
                            String titulo = rs.getString("titulo");
                            float notaFinal = rs.getFloat("notaFinal");
                            
                            PooModulo m = new PooModulo(idModulo,idUsuario,titulo,notaFinal);
                            arrayModulos.add(m);
                        }
                        
                        return arrayModulos;
                } catch (SQLException e) {
			e.printStackTrace();
                        return null;
		} 
		finally {
			this.cerrarConexion();
		}
    }
    
    /**
     * Obtener un ArrayList de modulos correspondientes a un usuario específico de la base de datos
     * @param idUsuario el usuario específico
     * @return ArrayList
     */
    public ArrayList<PooModulo> getModulosDeUsuario(int idUsuario){
        ArrayList<PooModulo> arrayModulos = new ArrayList<PooModulo>();
        try {
			String insertSql = "SELECT idModulo, titulo, notaFinal FROM modulos WHERE idUsuario=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
                        prest.setInt(1, idUsuario);
			ResultSet rs = prest.executeQuery();
                        
                        while (rs.next()){
                            int idModulo = rs.getInt("idModulo");
                            String titulo = rs.getString("titulo");
                            float notaFinal = rs.getFloat("notaFinal");
                            
                            PooModulo m = new PooModulo(idModulo,idUsuario,titulo,notaFinal);
                            arrayModulos.add(m);
                        }
                        
                        return arrayModulos;
                } catch (SQLException e) {
			e.printStackTrace();
                        return null;
		} 
		finally {
			this.cerrarConexion();
		}
    }
    
    /**
     * Inserta un modulo en la base de datos
     * @param idUsuario id del usuario correspondiente al modulo añadido
     * @param titulo titulo del modulo
     * @return booleana
     */
    public boolean agregarModulo(int idUsuario, String titulo) {
		Boolean resultado = false;
		try {
			String insertSql = "INSERT INTO modulos (idUsuario, titulo) VALUES (?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
			
			prest.setInt(1, idUsuario);
			prest.setString(2, titulo);
                        
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
     * Eliminar un modulo de la base de datos
     * @param idModulo id del modulo que se elimina
     * @return booleana
     */
        public boolean eliminarModulo(int idModulo) {
		Boolean resultado = false;
		try {
			String Sql = "DELETE FROM modulos WHERE idModulo=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(1, idModulo);
			
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
         * Editar un modulo en la base de datos
         * @param idModulo id del modulo a editar
         * @param idUsuario id del usuario que se edita
         * @param titulo titulo que se edita
         * @return booleana
         */
            public boolean editarModulo(int idModulo, int idUsuario, String titulo) {
		Boolean resultado = false;
		try {
			String Sql = "UPDATE modulos SET titulo=? WHERE idModulo=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(2, idModulo);
			prest.setString(1, titulo);
			
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
