package dao;

import java.util.List;

public interface DAO <T,K>{

	public void insertar(T a) throws DAOException;
	
	public void modificar(T a) throws DAOException;
	
	public void eliminar(T a) throws DAOException;
	
	public List<T> obtenerTodos() throws DAOException;
	
	public T obtener(K id) throws DAOException;
}
