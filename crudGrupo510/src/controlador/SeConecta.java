package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SeConecta {
	Connection con;
	public Connection conectar() {		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/grupo510","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
}
