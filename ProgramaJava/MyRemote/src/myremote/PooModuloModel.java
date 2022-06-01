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
public class PooModuloModel extends DBUtil {
    
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
    
    public ArrayList<PooModulo> getModulos(int idUsuario){
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
    
    public boolean agregarModulo(int idModulo, int idUsuario, String titulo, float notaFinal) {
		Boolean resultado = false;
		try {
			String insertSql = "INSERT INTO modulos (idModulo, idUsuario, titulo, notaFianl) VALUES (?, ?, ?, ?)";
				  
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
			String Sql = "DELETE FROM modulos WHERE idModulo=? AND idUsuario=?";
				  
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
			String Sql = "UPDATE modulos SET (idModulo, idUsuario, titulo, notaFianl) VALUES (?, ?, ?, ?)";
				  
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
