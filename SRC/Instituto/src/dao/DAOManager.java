package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOManager {

	private Connection conn;
	
	private AlumnoDAO alumnos = null;
	private ProfesorDAO profesores = null;
	private AsignaturaDAO asignaturas = null;
	private MatriculaDAO matriculas = null;
	
	public DAOManager(String host, String username, String password, String database) throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, username, password);		
	}
	
	public AlumnoDAO getAlumnoDAO() {
		if (alumnos == null) {
			alumnos = new AlumnoDAO(conn);
		}
		return alumnos;
	}
	
	public ProfesorDAO getProfesorDAO() {
		if (profesores == null) {
			profesores = new ProfesorDAO(conn);
		}
		return profesores;
	}
	
	public AsignaturaDAO getAsignaturaDAO() {
		if(asignaturas == null) {
			asignaturas = new AsignaturaDAO(conn);
		}
		return asignaturas;
	}
	
	public MatriculaDAO getMatriculaDAO() {
		if(matriculas == null) {
			matriculas = new MatriculaDAO(conn);
		}
		return matriculas;
	}
	
}
