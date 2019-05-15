package dao;

import java.sql.Connection;
import java.util.List;

import model.Asignatura;

public class AsignaturaDAO implements DAO<Asignatura, Integer>{

	Connection conn;
	
	private final String INSERT = "INSERT INTO ASIGNATURA (NOMBRE_ASIGNATURA, PRECIO_ASIGNATURA, CODIGO_PROFESOR VALUES(?, ?, ?)";
	
	
	public AsignaturaDAO(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insertar(Asignatura a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Asignatura a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Asignatura a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Asignatura> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Asignatura obtener(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
