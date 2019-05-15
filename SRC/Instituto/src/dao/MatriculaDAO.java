package dao;

import java.sql.Connection;
import java.util.List;

import model.Matricula;

public class MatriculaDAO implements DAO<Matricula, Integer>{
	
	private Connection conn;
	
	public MatriculaDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertar(Matricula a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Matricula a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Matricula a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Matricula> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Matricula obtener(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
