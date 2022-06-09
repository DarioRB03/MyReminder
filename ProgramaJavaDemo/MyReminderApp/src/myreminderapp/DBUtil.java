/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myreminderapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase utilitaria de acceso a la base de datos
 * @author 1erDAM
 */
public class DBUtil {
    
	private Connection conn;
	private String cadenaConexion = "jdbc:mysql://myreminder.ddns.net:3306/myre_myreminderdb";
	private String nombreUsuario = "myre_myreminderdbusr";
	private String password = "MyReminder1234!";
	
        /**
         * Devuelve la conexion con la base de datos
         * @return 
         */
	public Connection getConexion() {
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			this.conn = DriverManager.getConnection(this.cadenaConexion, this.nombreUsuario, this.password);
			return this.conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
        /**
         * Cierra la conexion con la base de datos
         */
	public void cerrarConexion() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
