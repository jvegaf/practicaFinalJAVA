package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Asignatura;

public class AsignaturaDAO implements DAO<Asignatura, Integer>{

	Connection conn;
	
	private final String INSERT = "INSERT INTO ASIGNATURA (NOMBRE_ASIGNATURA, PRECIO_ASIGNATURA, CODIGO_PROFESOR VALUES(?, ?, ?)";
	private final String UPDATE= "UPDATE ASIGNATURA SET NOMBRE_ASIGNATURA = ?, PRECIO_ASIGNATURA = ?, CODIGO_PROFESOR = ? WHERE CODIGO_ASIGNATURA = ?";
	private final String DELETE = "DELETE FROM ASIGNATURA WHERE CODIGO_ASIGNATURA = ?";
	private final String GETALL = "SELECT CODIGO_ASIGNATURA, NOMBRE_ASIGNATURA, PRECIO_ASIGNATURA, CODIGO_PROFESOR FROM ASIGNATURA";
	private final String GETONE= "SELECT NOMBRE_ASIGNATURA, PRECIO_ASIGNATURA, CODIGO_PROFESOR WHERE CODIGO_ASIGNATURA = ?";
	
	public AsignaturaDAO(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insertar(Asignatura a) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(INSERT);
			stat.setString(1, a.getNombre());
			stat.setInt(2, a.getPrecio());
			stat.setInt(3, a.getCodProfesor());
			if (stat.executeUpdate() == 0) {
				throw new DAOException("puede que no se haya guardado");
			}
		} catch (SQLException e) {
			throw new DAOException("error en el SQL", e);
		} finally {
			if (stat!=null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new DAOException("error en el SQL", e);
				}
			}
		}
	}

	@Override
	public void modificar(Asignatura a) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(UPDATE);
			stat.setString(1, a.getNombre());
			stat.setInt(2, a.getPrecio());
			stat.setInt(2, a.getCodProfesor());
			stat.setInt(4, a.getCodAsignatura());
			if(stat.executeUpdate()==0) {
				throw new DAOException("puede que no se haya guardado");
			}
		} catch (SQLException e) {
			throw new DAOException("Error en el SQL",e);
		} finally {
			if (stat!=null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new DAOException("error en el SQL",e);
				}
			}
		}
		
	}

	@Override
	public void eliminar(Asignatura a) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = conn.prepareStatement(DELETE);
			stat.setInt(1, a.getCodAsignatura());
			if (stat.executeUpdate()==0) {
				throw new DAOException("puede que no se haya borrado");
			}
		} catch (SQLException e) {
			throw new DAOException("error en el SQL",e);
		} finally {
			if (stat!=null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new DAOException("error en el SQL", e);
				}
			}
		}
		
	}

	@Override
	public List<Asignatura> obtenerTodos() throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<Asignatura> asignaturas = new ArrayList<Asignatura>();
		try {
			stat = conn.prepareStatement(GETALL);
			rs = stat.executeQuery();
			while(rs.next()) {
				asignaturas.add(convierte(rs));
			}
		} catch (SQLException e) {
			throw new DAOException("Error en el SQL", e);
		} finally {
			if (stat!=null) {
				try {
					stat.close();
				} catch (SQLException e) {
					throw new DAOException("error en el SQL",e);
				}
			}
			if (rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new DAOException("error en el SQL", e);
				}
			}
		}
		return asignaturas;
	}

	@Override
	public Asignatura obtener(Integer id) throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		Asignatura as = null;
		try {
			stat = conn.prepareStatement(GETONE);
			stat.setInt(1, id);
			rs = stat.executeQuery();
			if (rs.next()) {
				as = convierte(rs);
			}
		} catch (SQLException e) {
			throw new DAOException("error en el SQL", e);
		} finally {
			if (rs!=null) {
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
					throw new DAOException("error en el SQL",e);
				}
			}
		}
		return as;
	}

	private Asignatura convierte (ResultSet rs) throws SQLException {
		Integer codAsignatura = rs.getInt("CODIGO_ASIGNATURA");
		String nombre = rs.getString("NOMBRE_ASIGNATURA");
		int precio = rs.getInt("PRECIO_ASIGNATURA");
		int codProfesor = rs.getInt("CODIGO_PROFESOR");
		return new Asignatura(codAsignatura, nombre, precio, codProfesor);
	}
}
