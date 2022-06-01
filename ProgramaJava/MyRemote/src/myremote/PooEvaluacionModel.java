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
public class PooEvaluacionModel extends DBUtil {
    
        public boolean agregarEvaluacion(int idModulo, int numEvaluacion, float procentaje,float nota) {
		Boolean resultado = false;
		try {
			String insertSql = "INSERT INTO evaluacion (idModulo, numEvaluacion, procentaje, nota) VALUES (?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(insertSql);
			
			prest.setInt(1, idModulo);
			prest.setInt(2, numEvaluacion);
			prest.setFloat(3, procentaje);
			prest.setFloat(4, nota);
			
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
    
    
        public boolean eliminarEvaluacion(int idModulo, int idEvaluacion) {
		Boolean resultado = false;
		try {
			String Sql = "DELETE FROM evaluacion WHERE idModulo=? AND idEvaluacion=?";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(1, idModulo);
                        prest.setInt(2, idEvaluacion);
			
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

        
            public boolean editarEvaluacion(int idModulo, int numEvaluacion, float procentaje,float nota) {
		Boolean resultado = false;
		try {
			String Sql = "UPDATE evaluacion SET (idModulo, numEvaluacion, procentaje, nota) VALUES (?, ?, ?, ?)";
				  
			PreparedStatement prest = this.getConexion().prepareStatement(Sql);
			
			prest.setInt(1, idModulo);
			prest.setInt(2, numEvaluacion);
			prest.setFloat(3, procentaje);
			prest.setFloat(4, nota);
			
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
