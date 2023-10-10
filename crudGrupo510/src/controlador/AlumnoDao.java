package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Alumno;

public class AlumnoDao {

	private Connection con;
	private SeConecta sc = new SeConecta();
	private PreparedStatement ps;	
	private ResultSet rs;
	public boolean guardar (Alumno al) {
		con = sc.conectar();
		boolean guardado = false;
		try {
			ps = con.prepareStatement("insert into alumnos values(?,?,?,?,?,?)");
			ps.setInt(1, al.getnControl());
			ps.setString(2, al.getNombre());
			ps.setString(3, al.getApellido_p());
			ps.setString(4, al.getApellido_m());
			ps.setString(5, al.getCurp());
			ps.setString(6, al.getTelefono());	
			int guarda = ps.executeUpdate();
			if(guarda >0) {
				JOptionPane.showMessageDialog(null, "Guardado");
			}else {
				JOptionPane.showMessageDialog(null, "No guardado");
			}	
			con.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return guardado;
	}
	public Alumno consultar(int parseInt) {
		Alumno alu = new Alumno();
		SeConecta sc = new SeConecta();
		con = sc.conectar();
		try {
			ps = con.prepareStatement("select * from alumnos where ncontrol =?");
			ps.setInt(1, parseInt);
			rs = ps.executeQuery(); 
			
			if(rs.next()) {
				alu.setnControl(rs.getInt(1));
				alu.setNombre(rs.getString(2));
				alu.setApellido_p(rs.getString("ap"));
				alu.setApellido_m(rs.getString(4));
				alu.setCurp(rs.getString(5));
				alu.setTelefono(rs.getString(6));
			}else {
				JOptionPane.showMessageDialog(null, "No existe el alumno");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alu;
	}
}
