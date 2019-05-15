package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Profesor;

public class ProfesorDAO implements DAO<Profesor, Integer>{
	
	Connection conn;
	
	private final String INSERT = "INSERT IN TO PROFESOR(NOMBRE_PROFESOR, APELLIDO1_PROFESOR, APELLIDO2_PROFESOR, DI_PROFESOR) VALUES (?, ?, ?, ?)";
	private final String UPDATE = "UPDATE PROFESOR SET NOMBRE_PROFESOR = ?, APELLIDO1_PROFESOR= ?, APELLIDO2_PROFESOR= ?, DI_PROFESOR= ? WHERE CODIGO_PROFESOR = ?";
	private final String DELETE = "DELETE FROM PROFESOR WHERE CODIGO_PROFESOR = ?";
	private final String GETALL = "SELECT CODIGO_PROFESOR, NOMBRE_PROFESOR, APELLIDO1_PROFESOR, APELLIDO2_PROFESOR, DI_PROFESOR FROM PROFESOR";
	private final String GETONE = "SELECT NOMBRE_PROFESOR, APELLIDO1_PROFESOR, APELLIDO2_PROFESOR, DI_PROFESOR FROM PROFESOR WHERE CODIGO_PROFESOR = ?";
	
	
	
	public ProfesorDAO(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertar(Profesor p) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = (PreparedStatement) conn.prepareStatement(INSERT);
			stat.setString(1, p.getNombre());
			stat.setString(2, p.getApellido1());
			stat.setString(3, p.getApellido2());
			stat.setString(4, p.getDni());
			if(stat.executeUpdate()==0) {
				throw new DAOException("puede que no se haya guardado");
			}
		}catch(SQLException ex) {
			throw new DAOException("Error en el SQL", ex);
		}finally {
			if (stat != null) {
				try {
					stat.close();
				}
				catch (SQLException ex) {
					throw new DAOException("Error en el SQL", ex);
				}
			}
		}
	}

	@Override
	public void modificar(Profesor p) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = (PreparedStatement) conn.prepareStatement(UPDATE);
			stat.setString(1, p.getNombre());
			stat.setString(2, p.getApellido1());
			stat.setString(3, p.getApellido2());
			stat.setString(4, p.getDni());
			stat.setInt(5, p.getCodigo());
			if(stat.executeUpdate()==0) {
				throw new DAOException("Puede que no se haya guardado");
			}
		} catch (SQLException ex) {
			throw new DAOException("error en el SQL", ex);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException ex) {
					throw new DAOException("error en el SQL", ex);
				}
			}
		}
		
	}

	@Override
	public void eliminar(Profesor P) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = (PreparedStatement) conn.prepareStatement(DELETE);
			stat.setInt(1, P.getCodigo());
			if (stat.executeUpdate()==0) {
				throw new DAOException("puede que no se haya borrado");
			}
		}catch(SQLException ex) {
			throw new DAOException("Error en el SQL", ex);
		}finally {
			if (stat != null) {
				try {
					stat.close();
				}catch(SQLException ex) {
					throw new DAOException("Error en el SQL", ex);
				}
			}
		}
	}
	
	private Profesor convertir(ResultSet rs) throws SQLException {
		Integer codigo = rs.getInt("CODIGO_PROFESOR");
		String nombre = rs.getString("NOMBRE_PROFESOR");
		String apellido1 = rs.getString("APELLIDO1_PROFESOR");
		String apellido2 = rs.getString("APELLIDO2_PROFESOR");
		String dni = rs.getString("DI_PROFESOR");
		return new Profesor(codigo, nombre, apellido1, apellido2, dni);
	}

	@Override
	public List<Profesor> obtenerTodos() throws DAOException {
		List<Profesor> profesores = new ArrayList<Profesor>();
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			stat = (PreparedStatement) conn.prepareStatement(GETALL);
			rs = stat.executeQuery();
			while(rs.next()) {
				profesores.add(convertir(rs));
			}
		} catch (SQLException e) {
			throw new DAOException("error en el SQL", e);
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DAOException("error en el SQL",e);
				}
			}
			if(stat!=null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new DAOException("error en el SQL", e);
				}
			}
		}
		
		return profesores;
	}

	@Override
	public Profesor obtener(Integer id) throws DAOException {
		ResultSet rs = null;
		PreparedStatement stat = null;
		Profesor p = null;
		try {
			stat = conn.prepareStatement(GETONE);
			stat.setInt(1, id);
			rs = stat.executeQuery();
			if(rs.next()) {
				p = convertir(rs);
			}else {
				throw new DAOException("ResultSet vacio");
			}
		} catch (SQLException e) {
			throw new DAOException("error en el SQL");
		} finally {
			if (rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DAOException("Error en el SQL", e);
				}
			}
			if (stat!=null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new DAOException("Error en el SQL", e);
				}
			}
		}
		return null;
	}

}
