package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	public void conectar() {
		
		Connection conexion = null;
		
		try {
			
			String url = "jdbc:mysql://192.168.64.2:3306/BD_INSTITUTO";
			String user = "prueba";
			String password = "prueba";

			conexion = DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conexion != null) {
				try {
					conexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
