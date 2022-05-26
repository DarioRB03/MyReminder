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
public class PooAdministradorModel extends DBUtil{
    
    public boolean agregarAdmin(int idAdmin, String nombre, String apellido, String nick, String password) {
		Boolean resultado = false;
		try {
			String insertSql = "INSERT INTO administrador (idAdmin, nombre, apellido, nick, password) VALUES (?, ?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
			
			prest.setInt(1, idAdmin);
			prest.setString(2, nombre);
			prest.setString(3, apellido);
			prest.setString(4, nick);
                        prest.setString(5, password);
			
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
    
    
        public boolean eliminarAdmin(int idAdmin) {
		Boolean resultado = false;
		try {
			String Sql = "DELETE FROM administrador WHERE idAdmin=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(1, idAdmin);
			
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

        
            public boolean editarAdmin(int idAdmin, String nombre, String apellido, String nick, String password) {
		Boolean resultado = false;
		try {
			String Sql = "UPDATE administrador SET (idAdmin, nombre, apellido, nick, password) VALUES (?, ?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(1, idAdmin);
			prest.setString(2, nombre);
			prest.setString(3, apellido);
			prest.setString(4, nick);
                        prest.setString(5, password);
			
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
